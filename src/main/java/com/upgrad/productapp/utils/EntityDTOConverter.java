package com.upgrad.productapp.utils;

import com.upgrad.productapp.dtos.EshopProductDto;
import com.upgrad.productapp.dtos.EshopShippingAddressDto;
import com.upgrad.productapp.dtos.EshopUserDto;
import com.upgrad.productapp.dtos.LoginDTO;
import com.upgrad.productapp.entities.EshopProduct;
import com.upgrad.productapp.entities.EshopShippingAddress;
import com.upgrad.productapp.entities.EshopUser;
import com.upgrad.productapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConverter {


   @Autowired
    UserService userService;


    public EshopUserDto convertToUserDTO(EshopUser customer){
        EshopUserDto customerDTO = new EshopUserDto();
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setPassword(customer.getPassword());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhoneNumber(customer.getPhoneNo());
        customerDTO.setUserName(customer.getUserName());
        customerDTO.setId(customer.getId());
        customerDTO.setCreated(customer.getCreated());
        customerDTO.setUpdated(customer.getUpdated());
        customerDTO.setRole(customer.getRole());
        return customerDTO;
    }



    public LoginDTO convertToLginDTO(EshopUser customer){
        LoginDTO customerDTO = new LoginDTO();
        customerDTO.setUserName(customer.getUserName());
        customerDTO.setPassword(customer.getPassword());
        customerDTO.setMessage("Success");
        return customerDTO;
    }

    public EshopShippingAddressDto convertToAddressSto(EshopShippingAddress address){
        EshopShippingAddressDto addressDto= new EshopShippingAddressDto();
        addressDto.setCity(address.getCity());
        addressDto.setLandmark(address.getLandmark());
        addressDto.setName(address.getName());
        addressDto.setPhone(address.getPhone());
        addressDto.setState(address.getState());
        addressDto.setStreet(address.getStreet());
        addressDto.setZipcode(address.getZipcode());
        addressDto.setUser(address.getUser());
        return addressDto;
    }

    public EshopProductDto convertToProductDto(EshopProduct product)  {
        EshopProductDto productDto= new EshopProductDto();
        productDto.setAvailableItems(product.getAvailable_items());
        productDto.setCategory(product.getCategory());
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImage_url());
        productDto.setManufacturer(product.getManufacturer());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
       productDto.setCreated(product.getCreated());
       productDto.setUpdated(product.getUpdated());
        return productDto;
    }







}
