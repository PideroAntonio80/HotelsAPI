package com.sanvalero.hotelsapi.service;

import com.sanvalero.hotelsapi.domain.Room;

import java.util.Optional;
import java.util.Set;

/**
 * Creado por @ author: Pedro Orós
 * el 16/03/2021
 */
public interface RoomService {

    Set<Room> findAll();
    Optional<Room> findRoomById(long id);
    Set<Room> findBySize(String size);
//    Set<Room> findByHotelAndPrize(Hotel hotel, float minPrize, float maxPrize);
    Set<Room> findByAvailable(boolean available);
//    Set<Room> findByHotel(Hotel hotel);
    Room modifyRoom(long id, Room room);
    void deleteRoom(long id);
}
