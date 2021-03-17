package com.sanvalero.hotelsapi.exception;

/**
 * Creado por @ author: Pedro Orós
 * el 16/03/2021
 */
public class HotelNotFoundException extends RuntimeException {

    public HotelNotFoundException() {
        super();
    }

    public HotelNotFoundException(String message){
        super(message);
    }

    public HotelNotFoundException(long id){
        super("Hotel not found: " + id);
    }
}

