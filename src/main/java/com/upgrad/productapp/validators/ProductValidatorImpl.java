package com.upgrad.productapp.validators;

import com.upgrad.productapp.dtos.EshopProductDto;
import com.upgrad.productapp.exceptions.APIException;
import org.springframework.stereotype.Service;


@Service
public class ProductValidatorImpl  implements  ProductValidator{

    @Override
    public void validateProduct(EshopProductDto productDto) throws APIException {
        if(productDto.getCategory() == null || productDto.getCategory().length() <= 0)
            throw new APIException("Invalid username");
        if(productDto.getDescription() == null || productDto.getDescription().length() <= 0 )
            throw new APIException("Invalid firstname");
        if(productDto.getImageUrl() == null || productDto.getImageUrl().length() <= 0 )
            throw new APIException("Invalid lastname");
        if(productDto.getManufacturer() == null || productDto.getManufacturer().length() <= 0   )
            throw new APIException("Invalid password");
        if(productDto.getName() == null || productDto.getName().length() <= 0   )
            throw new APIException("Invalid password");


    }
}
