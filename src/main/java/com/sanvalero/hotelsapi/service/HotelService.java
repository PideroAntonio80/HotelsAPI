package com.sanvalero.hotelsapi.service;

import com.sanvalero.hotelsapi.domain.Hotel;
import com.sanvalero.hotelsapi.domain.Room;

import java.util.Set;

/**
 * Creado por @ author: Pedro Orós
 * el 16/03/2021
 */
public interface HotelService {

    Set<Hotel> findAll();
    Hotel findHotelById(long id);
    Set<Hotel> findByLocation(String location);
    Set<Hotel> findByCategory(String category);
    Set<Hotel> findByLocationAndCategory(String location, String category);

    Hotel addHotel(Hotel hotel);
    Room addRoomToHotel(long id, Room room);
    Hotel modifyHotel(long id, Hotel hotel);
    void deleteHotel(long id);

}
