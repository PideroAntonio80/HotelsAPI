package com.sanvalero.hotelsapi.service;

import com.sanvalero.hotelsapi.domain.Hotel;
import com.sanvalero.hotelsapi.domain.Room;
import com.sanvalero.hotelsapi.exception.HotelNotFoundException;
import com.sanvalero.hotelsapi.exception.RoomNotFoundException;
import com.sanvalero.hotelsapi.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Creado por @ author: Pedro Orós
 * el 16/03/2021
 */

@Service
public class RoomServiceImp implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Set<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> findRoomById(int id) {
        return roomRepository.findById((long) id);
    }

    @Override
    public Set<Room> findBySize(String size) {
        return roomRepository.findBySize(size);
    }

    /*@Override
    public Set<Room> findByHotelAndPrize(Hotel hotel, float minPrize, float maxPrize) {
        Set<Room> roomsPrize = roomRepository.findByHotel(hotel);
        Set<Room> rooms = roomsPrize.stream()
                .filter(myRoom -> myRoom.getPrize() > minPrize)
                .filter(myRoom -> myRoom.getPrize() < maxPrize)
                .filter(myRoom -> myRoom.getHotel() == hotel)
                .filter(Room::isAvailable)
                .collect(Collectors.toSet());
        return rooms;
    }*/

    @Override
    public Set<Room> findByAvailable(boolean available) {
        return roomRepository.findByAvailable(available);
    }

    /*@Override
    public Set<Room> findByHotel(Hotel hotel) {
        return roomRepository.findByHotel(hotel);
    }*/

    @Override
    public Room modifyRoom(int id, Room newRoom) {
        Room room = roomRepository.findById((long)id)
                .orElseThrow(() -> new RoomNotFoundException(id));
        newRoom.setId(room.getId());
        return roomRepository.save(newRoom);
    }

    @Override
    public void deleteRoom(int id) {
        Room room = roomRepository.findById((long) id)
                .orElseThrow(() -> new RoomNotFoundException(id));
        roomRepository.delete(room);
    }
}

