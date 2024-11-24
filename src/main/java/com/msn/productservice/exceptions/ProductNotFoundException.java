package com.msn.productservice.exceptions;

public class ProductNotFoundException extends Exception {
    ProductNotFoundException(String message){
        super(message);
    }
}
