package com.sanvalero.hotelsapi.exception;

/**
 * Creado por @ author: Pedro Orós
 * el 17/03/2021
 */
public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException() {
        super();
    }

    public RoomNotFoundException(String message){
        super(message);
    }

    public RoomNotFoundException(long id){
        super("Room not found: " + id);
    }
}
