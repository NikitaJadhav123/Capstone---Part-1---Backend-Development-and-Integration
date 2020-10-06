package com.upgrad.productapp.controllers;

import com.upgrad.productapp.daos.EshopProductDAO;
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

@CrossOrigin
@Controller
public class ProductController {


    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    ProductService productService;

    @Autowired
    EshopProductDAO productDAO;
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


        EshopUser customere = userService.getCustomerInoByUserName(usernm);
        if(!customere.getRole().equalsIgnoreCase("admin")){
            throw new CustomException("You are not authorised to access this endpoint.");
        }

        productValidator.validateProduct(productDto);

        EshopProduct newProduct = dtoEntityConverter.convertToProductEntity(productDto);
        EshopProduct savedProduct = productService.saveProduct(newProduct);

        EshopProductDto savedProductDTO = entityDTOConverter.convertToProductDto(savedProduct);


        return ResponseEntity.status(HttpStatus.OK).body(savedProductDTO);

    }

    /*
    @GetMapping( value = "/products")
    @ResponseBody
    public ResponseEntity getDetails( @RequestParam (value="category") String category,
                                          @RequestParam (value="direction") boolean desc,
                                          @RequestParam (value="name") String name,
                                          @RequestParam (value="pageNo")  int pgno,
                                          @RequestParam (value="pageSize") int pgsz,
                                          @RequestParam (value="productId") int SortBy)  {


        Page<EshopProduct> productPage = null;

        // not filtering with salary
        if(category==null || name==null) {
            // not sorting with age
                // sorting with age and ascending
                if(!desc) {
                    Pageable requestedPage = PageRequest.of(pgno, pgsz, Sort.by("productId"));
                    productPage  = productDAO.findAll(requestedPage);
                }
                // sorting with age and descending
                else {
                    Pageable requestedPage = PageRequest.of(pgno, pgsz,
                            Sort.by("productId").descending());
                    productPage  = productDAO.findAll(requestedPage);
                }
            }
        /*
            // Filtering with salary
        } else {
            // not sorting with age
            if(agesorting == false) {
                Pageable requestedPage = PageRequest.of(page, size);
                // fitering request
                customers = customerRepository.findAllBySalary(salary, requestedPage);
            }else {
                // sorting with age and ascending
                if(false == desc) {
                    Pageable requestedPage = PageRequest.of(page, size, Sort.by("age"));
                    // filtering request
                    customers  = customerRepository.findAllBySalary(salary, requestedPage);
                }
                // sorting with age and descending
                else {
                    Pageable requestedPage = PageRequest.of(page, size,
                            Sort.by("age").descending());
                    // filtering request
                    customers  = customerRepository.findAllBySalary(salary, requestedPage);
                }
            }
        }




        EshopProduct eshopProduct= (EshopProduct) productPage;
        EshopProductDto savedProductDTO=entityDTOConverter.convertToProductDto(eshopProduct);
        return ResponseEntity.status(HttpStatus.OK).body(savedProductDTO);


    }
*/
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

    @GetMapping( value = "/products/category/{category}")
    @ResponseBody
    public ResponseEntity getProductDetailsByCategory( @PathVariable String category ) throws ProductDetailsNotFound {

        List<EshopProduct> eshopProduct=productService.getProductDetailsByCategory(category);
        if (eshopProduct==null) {
            CustomResponse response = new CustomResponse(LocalDateTime.now(), "No Product found for category- "+category+"!", 400);
            return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        }
       // List<EshopProductDto> savedProductDTO=new ArrayList<>();
       // for(EshopProduct p:eshopProduct) {
       //         savedProductDTO.add(entityDTOConverter.convertToProductDto(p));

       // }

        return ResponseEntity.status(HttpStatus.OK).body(eshopProduct);


    }

    @PutMapping( value = "/products/{id}")
    @ResponseBody
    public ResponseEntity updateProductDetailsById( @PathVariable int id,@RequestBody EshopProductDto productDto, @RequestHeader(value = "X-ACCESS-TOKEN")  String accessToken  ) throws ProductDetailsNotFound, APIException, UserDetailsNotfoundException, CustomException {

        String usernm = jwtTokenProvider.getUsernm(accessToken);
        ResponseEntity responseEntity;
        if(usernm == null)
            throw new APIException("Please Login first to access this endpoint!");


        EshopUser customere = userService.getCustomerInoByUserName(usernm);
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


        EshopUser customere = userService.getCustomerInoByUserName(usernm);
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

    @GetMapping( value = "/products")
    @ResponseBody
    public ResponseEntity getProducts() {

        List<EshopProduct> products = productService.getProductDetails();

        return ResponseEntity.status(HttpStatus.OK).body(products);


    }





    }
