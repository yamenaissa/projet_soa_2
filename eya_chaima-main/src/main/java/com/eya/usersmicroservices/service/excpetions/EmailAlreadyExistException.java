package com.eya.usersmicroservices.service.excpetions;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value= HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistException extends RuntimeException
{
    public EmailAlreadyExistException(String message)
    {
        super(message);
    }
}
