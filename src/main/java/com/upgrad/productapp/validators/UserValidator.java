package com.upgrad.productapp.validators;

import com.upgrad.productapp.dtos.EshopUserDto;
import com.upgrad.productapp.dtos.LoginDTO;
import com.upgrad.productapp.exceptions.APIException;

public interface UserValidator {

    public void validateUser(EshopUserDto userDto) throws APIException;
    public void validateuserLogin(LoginDTO loginDTO) throws APIException;
}
