package com.upgrad.productapp.controllers;

import com.upgrad.productapp.dtos.EshopUserDto;
import com.upgrad.productapp.entities.EshopUser;
import com.upgrad.productapp.exceptions.APIException;
import com.upgrad.productapp.exceptions.UserAlreadyExistsException;
import com.upgrad.productapp.exceptions.UserDetailsNotfoundException;
import com.upgrad.productapp.security.JwtTokenProvider;
import com.upgrad.productapp.services.UserService;
import com.upgrad.productapp.utils.DTOEntityConverter;
import com.upgrad.productapp.utils.EntityDTOConverter;
import com.upgrad.productapp.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserService userService;
    @Autowired
    UserValidator userValidator;
    @Autowired
    EntityDTOConverter entityDTOConverter;
    @Autowired
    DTOEntityConverter dtoEntityConverter;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping( value = "/users/details")
    @ResponseBody
    public ResponseEntity getUserDetails(@RequestHeader(value = "X-ACCESS-TOKEN") String accessToken) throws UserAlreadyExistsException, APIException, UserDetailsNotfoundException {

        String usernm = jwtTokenProvider.getUsernm(accessToken);
            ResponseEntity responseEntity;
            if(usernm == null)
                throw new APIException("Please Login first to access this endpoint!");

        EshopUser customere = userService.getCustomerDetailsByUserName(usernm);
        EshopUserDto savedCustomerDTO = entityDTOConverter.convertToUserDTO(customere);
            return ResponseEntity.status(HttpStatus.OK).body(savedCustomerDTO);



    }


}
