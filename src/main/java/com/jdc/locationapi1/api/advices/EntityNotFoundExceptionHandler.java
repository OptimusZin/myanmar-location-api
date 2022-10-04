package com.jdc.locationapi1.api.advices;

import com.jdc.locationapi1.model.dto.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class EntityNotFoundExceptionHandler {


    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EntityNotFoundException.class)
    ErrorResult handle(EntityNotFoundException e){
            return new ErrorResult(e.getMessage());
    }

}
