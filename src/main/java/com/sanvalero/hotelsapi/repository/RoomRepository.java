package com.sanvalero.hotelsapi.repository;

import com.sanvalero.hotelsapi.domain.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Creado por @ author: Pedro Orós
 * el 16/03/2021
 */

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    Set<Room> findAll();
    Set<Room> findBySize(String size);
//    Set<Room> findByHotelAndPrize(Hotel hotel, float minPrize, float maxPrize);
    Set<Room> findByAvailable(boolean available);
//    Set<Room> findByHotel(Hotel hotel);
}
