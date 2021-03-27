package com.sanvalero.hotelsapi.service;

import com.sanvalero.hotelsapi.domain.Hotel;
import com.sanvalero.hotelsapi.domain.Room;

import java.util.Optional;
import java.util.Set;

/**
 * Creado por @ author: Pedro Orós
 * el 16/03/2021
 */
public interface HotelService {

    Set<Hotel> findAll();
    Optional<Hotel> findHotelById(int id);
    Set<Hotel> findByLocation(String location);
    Set<Hotel> findByCategory(String category);
    Set<Hotel> findByLocationAndCategory(String location, String category);

    Hotel addHotel(Hotel hotel);
    Room addRoomToHotel(int id, Room room);
    Hotel modifyHotel(int id, Hotel hotel);
    void deleteHotel(int id);

}
