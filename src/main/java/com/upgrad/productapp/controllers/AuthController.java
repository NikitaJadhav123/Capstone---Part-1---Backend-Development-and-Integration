package com.upgrad.productapp.controllers;


import com.upgrad.productapp.dtos.EshopUserDto;
import com.upgrad.productapp.dtos.LoginDTO;
import com.upgrad.productapp.entities.EshopUser;
import com.upgrad.productapp.exceptions.APIException;
import com.upgrad.productapp.exceptions.CustomException;
import com.upgrad.productapp.exceptions.UserAlreadyExistsException;
import com.upgrad.productapp.exceptions.UserDetailsNotfoundException;
import com.upgrad.productapp.responses.CustomResponse;
import com.upgrad.productapp.security.JwtTokenProvider;
import com.upgrad.productapp.services.UserService;
import com.upgrad.productapp.utils.DTOEntityConverter;
import com.upgrad.productapp.utils.EntityDTOConverter;
import com.upgrad.productapp.utils.ValidatorUtil;
import com.upgrad.productapp.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
@CrossOrigin
@Controller
public class AuthController {

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

    @PostMapping( value = "/auth/register")
    @ResponseBody
    public ResponseEntity signUp(@RequestBody EshopUserDto customerDTO) throws UserAlreadyExistsException, APIException, UserDetailsNotfoundException {
        System.out.println("entered sign up");


            ResponseEntity responseEntity;

            String email = customerDTO.getEmail();
            String encodedPassword = bCryptPasswordEncoder.encode(customerDTO.getPassword());
            String mobileNo = customerDTO.getPhoneNumber();
                boolean customere = userService.getCustomerDetailsByEmail(customerDTO.getEmail());
                boolean customer = userService.getCustomerDetailsByUserName(customerDTO.getUserName());
                if (customer) {
                    CustomResponse response = new CustomResponse(LocalDateTime.now(), "Try any other username, this username is already registered!", 400);
                    responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
                    return responseEntity;
                }
                if (customere) {
                    CustomResponse response = new CustomResponse(LocalDateTime.now(), "Try any other email address, this email address is already registered!", 400);
                    responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
                    return responseEntity;
                }



            if (!ValidatorUtil.isValid(email)) {
                CustomResponse response = new CustomResponse(LocalDateTime.now(), "Invalid email-id format!", 400);
                responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
                return responseEntity;
            }
            if (StringUtils.isEmpty(encodedPassword) || encodedPassword.length() < 8) {
                CustomResponse response = new CustomResponse(LocalDateTime.now(), "Weak password!", 400);
                responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
                return responseEntity;
            }
            if (StringUtils.isEmpty(mobileNo) || mobileNo.length() != 10) {
                CustomResponse response = new CustomResponse(LocalDateTime.now(), "Invalid contact number!", 400);
                responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
                return responseEntity;
            }
            if (StringUtils.isEmpty(email)) {
                CustomResponse response = new CustomResponse(LocalDateTime.now(), "EmailId can not be null", 400);
                responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
                return responseEntity;

            }
            if(!customerDTO.getUserName().equalsIgnoreCase("admin")){
                customerDTO.setRole("USER");
            }
            else{
                customerDTO.setRole("ADMIN");
            }

            userValidator.validateUser(customerDTO);
            String token = jwtTokenProvider.createToken(email);
            customerDTO.setPassword(encodedPassword);
            customerDTO.setCreated(LocalDateTime.now());
            customerDTO.setUpdated(LocalDateTime.now());
            EshopUser newCustomer = dtoEntityConverter.convertToUserEntity(customerDTO);
            EshopUser savedCustomer = userService.createUser(newCustomer);
            EshopUserDto savedCustomerDTO = entityDTOConverter.convertToUserDTO(savedCustomer);
            //savedCustomerDTO.setJwtToken(token);
           // CustomResponse response = new CustomResponse(LocalDateTime.now(), "User Successfully Signed Up", 200);
           // responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
           // return responseEntity;
            return ResponseEntity.status(HttpStatus.OK).body(savedCustomerDTO);



    }


    @PostMapping( value = "/auth/login")
    @ResponseBody
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) throws APIException, UserDetailsNotfoundException, BadCredentialsException, CustomException {
        System.out.println("Print statement here _____________________________");

            userValidator.validateuserLogin(loginDTO);
            Map<String, String> model = new HashMap<>();
            String userName = loginDTO.getUserName();
            String password = loginDTO.getPassword();
            boolean saved = userService.getCustomerByUserName(userName);
            if(StringUtils.isEmpty(userName) ||  StringUtils.isEmpty(password)){
                model.put("Error", "Username  is invalid/ Password is empty");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(model);
            }

            if(saved){
                throw new BadCredentialsException("This username has not been registered!");
            }
          //  if(!bCryptPasswordEncoder.matches(password, savedCustomer.getPassword())){
          //      throw new BadCredentialsException("Invalid Credentials");
          //  }
            EshopUser savedCustomer=userService.getCustomerInoByUserName(userName);
            ResponseEntity responseEntity;
            String token = jwtTokenProvider.createToken(userName);
            bCryptPasswordEncoder.encode(password);
            LoginDTO savedCustomerDTO = entityDTOConverter.convertToLginDTO(savedCustomer);
            savedCustomerDTO.setJwtToken(token);
             return ResponseEntity.status(HttpStatus.OK).body(savedCustomerDTO);

    }



}
