package com.upgrad.productapp.controllers;

import com.upgrad.productapp.dtos.EshopProductDto;
import com.upgrad.productapp.entities.EshopProduct;
import com.upgrad.productapp.entities.EshopUser;
import com.upgrad.productapp.exceptions.*;
import com.upgrad.productapp.responses.CustomResponse;
import com.upgrad.productapp.security.JwtTokenProvider;
import com.upgrad.productapp.services.ProductService;
import com.upgrad.productapp.services.UserService;
import com.upgrad.productapp.utils.DTOEntityConverter;
import com.upgrad.productapp.utils.EntityDTOConverter;
import com.upgrad.productapp.validators.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ProductController {


    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductValidator productValidator;
    @Autowired
    EntityDTOConverter entityDTOConverter;
    @Autowired
    DTOEntityConverter dtoEntityConverter;



    @PostMapping( value = "/products")
    @ResponseBody
    public ResponseEntity saveProduct(@RequestBody EshopProductDto productDto, @RequestHeader(value = "X-ACCESS-TOKEN") String accessToken) throws UserAlreadyExistsException, APIException, UserDetailsNotfoundException,CustomException {
        String usernm = jwtTokenProvider.getUsernm(accessToken);
        ResponseEntity responseEntity;
        if(usernm == null)
            throw new APIException("Please Login first to access this endpoint!");


        EshopUser customere = userService.getCustomerDetailsByUserName(usernm);
        if(!customere.getRole().equalsIgnoreCase("admin")){
            throw new CustomException("You are not authorised to access this endpoint.");
        }

        productValidator.validateProduct(productDto);

        EshopProduct newProduct = dtoEntityConverter.convertToProductEntity(productDto);
        EshopProduct savedProduct = productService.saveProduct(newProduct);

        EshopProductDto savedProductDTO = entityDTOConverter.convertToProductDto(savedProduct);


        return ResponseEntity.status(HttpStatus.OK).body(savedProductDTO);

    }

    @GetMapping( value = "/products")
    @ResponseBody
    public ResponseEntity getUserDetails( @RequestParam (value="Category") String category,
                                          @RequestParam (value="Direction") String direction,
                                          @RequestParam (value="Name") String name,
                                          @RequestParam (value="Page Number")  int pgno,
                                          @RequestParam (value="Page Size") int pgsz,
                                          @RequestParam (value="Sort By") String sortBy) throws ProductDetailsNotFound {


        EshopProduct eshopProduct=productService.getProductDetailsByGet(category,name);
        EshopProductDto savedProductDTO=entityDTOConverter.convertToProductDto(eshopProduct);
        return ResponseEntity.status(HttpStatus.OK).body(savedProductDTO);



    }

    @GetMapping( value = "/products/{id}")
    @ResponseBody
    public ResponseEntity getProductDetailsById( @PathVariable Integer id ) throws ProductDetailsNotFound {

        EshopProduct eshopProduct=productService.getProductDetailsById(id);
        if (eshopProduct==null) {
            CustomResponse response = new CustomResponse(LocalDateTime.now(), "No Product found for ID - "+id+"!", 400);
           return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        }
        EshopProductDto savedProductDTO=entityDTOConverter.convertToProductDto(eshopProduct);
        return ResponseEntity.status(HttpStatus.OK).body(savedProductDTO);


    }

    @PutMapping( value = "/products/{id}")
    @ResponseBody
    public ResponseEntity updateProductDetailsById( @PathVariable int id,@RequestBody EshopProductDto productDto, @RequestHeader(value = "X-ACCESS-TOKEN")  String accessToken  ) throws ProductDetailsNotFound, APIException, UserDetailsNotfoundException, CustomException {

        String usernm = jwtTokenProvider.getUsernm(accessToken);
        ResponseEntity responseEntity;
        if(usernm == null)
            throw new APIException("Please Login first to access this endpoint!");


        EshopUser customere = userService.getCustomerDetailsByUserName(usernm);
        if(!customere.getRole().equalsIgnoreCase("admin")){
            throw new CustomException("You are not authorised to access this endpoint.");
        }


        EshopProduct eshopProduct=productService.getProductDetailsById(id);
        if (eshopProduct==null) {
            CustomResponse response = new CustomResponse(LocalDateTime.now(), "No Product found for ID - "+id+"!", 400);
            return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }


        if(productDto.getName()!=null){
            eshopProduct.setName(productDto.getName());
        }
        if(!(productDto.getAvailableItems()<0)){
            eshopProduct.setAvailable_items(productDto.getAvailableItems());
        }
        if(!(productDto.getPrice()<0)){
            eshopProduct.setPrice(productDto.getPrice());
        }
        if(productDto.getCategory()!=null){
            eshopProduct.setCategory(productDto.getCategory());
        }
        if(productDto.getDescription()!=null){
            eshopProduct.setDescription(productDto.getDescription());
        }
        if(productDto.getManufacturer()!=null){
            eshopProduct.setManufacturer(productDto.getManufacturer());
        }
        if(productDto.getImageUrl()!=null){
            eshopProduct.setImage_url(productDto.getImageUrl());
        }

        EshopProductDto productDTO = entityDTOConverter.convertToProductDto(eshopProduct);

        return ResponseEntity.status(HttpStatus.OK).body(productDTO);

    }


    @DeleteMapping( value = "/products/{id}")
    @ResponseBody
    public ResponseEntity deleteProductDetailsById( @PathVariable Integer id, @RequestHeader(value = "X-ACCESS-TOKEN")  String accessToken  ) throws ProductDetailsNotFound, APIException, CustomException, UserDetailsNotfoundException {

        String usernm = jwtTokenProvider.getUsernm(accessToken);
        ResponseEntity responseEntity;
        if(usernm == null)
            throw new APIException("Please Login first to access this endpoint!");


        EshopUser customere = userService.getCustomerDetailsByUserName(usernm);
        if(!customere.getRole().equalsIgnoreCase("admin")){
            throw new CustomException("You are not authorised to access this endpoint.");
        }

        EshopProduct eshopProduct=productService.getProductDetailsById(id);
        if (eshopProduct==null) {
            CustomResponse response = new CustomResponse(LocalDateTime.now(), "No Product found for ID - "+id+"!", 400);
            return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        }
        productService.deleteProduct(eshopProduct);

        return ResponseEntity.status(HttpStatus.OK).body("Successfully Deleted");


    }


    @GetMapping( value = "/products/categories")
    @ResponseBody
    public ResponseEntity getProductCategories() throws ProductDetailsNotFound {

        List<String> categories=productService.getProductCategories();

        return ResponseEntity.status(HttpStatus.OK).body(categories);


    }






}
