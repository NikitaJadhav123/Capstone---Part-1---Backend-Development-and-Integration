package com.upgrad.productapp.validators;

import com.upgrad.productapp.dtos.EshopProductDto;
import com.upgrad.productapp.exceptions.APIException;

public interface ProductValidator {

    public void validateProduct(EshopProductDto productDto) throws APIException;
}
