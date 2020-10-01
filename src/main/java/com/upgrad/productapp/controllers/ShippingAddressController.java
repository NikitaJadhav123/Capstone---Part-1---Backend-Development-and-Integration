package com.upgrad.productapp.controllers;

import com.upgrad.productapp.dtos.EshopShippingAddressDto;
import com.upgrad.productapp.entities.EshopShippingAddress;
import com.upgrad.productapp.entities.EshopUser;
import com.upgrad.productapp.exceptions.APIException;
import com.upgrad.productapp.exceptions.CustomException;
import com.upgrad.productapp.exceptions.UserAlreadyExistsException;
import com.upgrad.productapp.exceptions.UserDetailsNotfoundException;
import com.upgrad.productapp.security.JwtTokenProvider;
import com.upgrad.productapp.services.AddressService;
import com.upgrad.productapp.services.UserService;
import com.upgrad.productapp.utils.DTOEntityConverter;
import com.upgrad.productapp.utils.EntityDTOConverter;
import com.upgrad.productapp.validators.AddressValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class ShippingAddressController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    AddressService addressService;
    @Autowired
    UserService userService;
    @Autowired
    AddressValidator addressValidator;
    @Autowired
    EntityDTOConverter entityDTOConverter;
    @Autowired
    DTOEntityConverter dtoEntityConverter;



    @PostMapping( value = "/user-addresses")
    @ResponseBody
    public ResponseEntity addAddress(@RequestBody EshopShippingAddressDto addressDto,@RequestHeader(value = "X-ACCESS-TOKEN") String accessToken) throws UserAlreadyExistsException, APIException, UserDetailsNotfoundException,CustomException {
        String usernm = jwtTokenProvider.getUsernm(accessToken);
        ResponseEntity responseEntity;
        if(usernm == null)
            throw new APIException("Please Login first to access this endpoint!");


        EshopUser customere = userService.getCustomerDetailsByUserName(usernm);
        if(customere.getRole().equalsIgnoreCase("admin")){
            throw new CustomException("You are not authorised to access this endpoint.");
        }

         addressValidator.validateAddress(addressDto);

         EshopShippingAddress newAddress = dtoEntityConverter.convertToAddressEntity(addressDto);
         EshopShippingAddress savedAddress = addressService.createAddress(newAddress);
         savedAddress.setUser(customere);
         EshopShippingAddressDto savedAddressDTO = entityDTOConverter.convertToAddressSto(savedAddress);


         return ResponseEntity.status(HttpStatus.OK).body(savedAddressDTO);

        }



}
