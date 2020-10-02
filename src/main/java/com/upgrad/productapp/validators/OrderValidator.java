package com.upgrad.productapp.validators;

import com.upgrad.productapp.dtos.EshopOrderDto;
import com.upgrad.productapp.exceptions.APIException;

public interface OrderValidator {

    public void validateOrder(EshopOrderDto eshopOrderDto) throws APIException;
}
