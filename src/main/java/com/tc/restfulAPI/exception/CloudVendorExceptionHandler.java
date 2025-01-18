package com.tc.restfulAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudVendorExceptionHandler {


    @ExceptionHandler(value={CloudVendorNotFoundException.class})
    public ResponseEntity<Object> handleCloudVendorNotFoundException(CloudVendorNotFoundException cloudVendorNotFoundException){


        /*creating payload which will be returned back intern of responsibility  response enitity  and that error message
        will given back to client*/

        CloudVendorException cloudVendorException = new CloudVendorException(
                cloudVendorNotFoundException.getMessage(),
                cloudVendorNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );


        return new ResponseEntity<>(cloudVendorException,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {CloudVendorCreationException.class})
    public ResponseEntity<Object> handleCloudVendorCreationException(CloudVendorCreationException exception) {
        CloudVendorException cloudVendorException = new CloudVendorException(
                exception.getMessage(),
                exception.getCause(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(cloudVendorException, HttpStatus.BAD_REQUEST);
    }

}
