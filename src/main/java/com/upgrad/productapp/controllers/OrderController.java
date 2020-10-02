package com.upgrad.productapp.controllers;

import com.upgrad.productapp.dtos.EshopOrderDto;
import com.upgrad.productapp.dtos.EshopOrderResponseDto;
import com.upgrad.productapp.entities.EshopOrder;
import com.upgrad.productapp.entities.EshopUser;
import com.upgrad.productapp.exceptions.*;
import com.upgrad.productapp.responses.CustomResponse;
import com.upgrad.productapp.security.JwtTokenProvider;
import com.upgrad.productapp.services.AddressService;
import com.upgrad.productapp.services.OrderService;
import com.upgrad.productapp.services.ProductService;
import com.upgrad.productapp.services.UserService;
import com.upgrad.productapp.utils.DTOEntityConverter;
import com.upgrad.productapp.utils.EntityDTOConverter;
import com.upgrad.productapp.validators.OrderValidator;
import com.upgrad.productapp.validators.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class OrderController {


    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @Autowired
    AddressService addressService;

    @Autowired
    UserService userService;
    @Autowired
    ProductValidator productValidator;

    @Autowired
    OrderValidator orderValidator;


    @Autowired
    EntityDTOConverter entityDTOConverter;
    @Autowired
    DTOEntityConverter dtoEntityConverter;



    @PostMapping( value = "/orders")
    @ResponseBody
    public ResponseEntity createProduct(@RequestBody EshopOrderDto orderDto, @RequestHeader(value = "X-ACCESS-TOKEN") String accessToken) throws  APIException, UserDetailsNotfoundException,CustomException, ProductDetailsNotFound,AddressNotFound {
        String usernm = jwtTokenProvider.getUsernm(accessToken);
        ResponseEntity responseEntity;
        if(usernm == null)
            throw new APIException("Please Login first to access this endpoint!");


        EshopUser customere = userService.getCustomerDetailsByUserName(usernm);
        if(!customere.getRole().equalsIgnoreCase("user")){
            throw new CustomException("You are not authorised to access this endpoint.");
        }

        orderValidator.validateOrder(orderDto);

        if(productService.getProductDetailsById(orderDto.getProductId())==null){
            CustomResponse response = new CustomResponse(LocalDateTime.now(), "No Product found for ID - "+orderDto.getProductId()+"!", 400);
            return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }


        List<EshopOrder> orders=orderService.getOrders();

        for(EshopOrder o:orders) {
            if (orderDto.getProductId()==o.getEshopProduct().getProduct_id()) {
                CustomResponse response = new CustomResponse(LocalDateTime.now(), "Product with ID - "+orderDto.getProductId()+" is currently out of stock!", 400);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        }

        if(addressService.getAddressDetailsById(orderDto.getAddressId())==null){
            CustomResponse response = new CustomResponse(LocalDateTime.now(), "No Address found for ID - "+orderDto.getProductId()+"!", 400);
            return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }


        EshopOrder newOrder = dtoEntityConverter.convertToOrderEntity(orderDto);
        EshopOrder savedOrder = orderService.createOrder(newOrder);

        EshopOrderResponseDto savedProductDTO = entityDTOConverter.convertToResponseDto(savedOrder);

        return ResponseEntity.status(HttpStatus.OK).body(savedProductDTO);

    }
}
