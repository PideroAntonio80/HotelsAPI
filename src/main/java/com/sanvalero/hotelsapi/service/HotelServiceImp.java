package com.sanvalero.hotelsapi.service;

import com.sanvalero.hotelsapi.domain.Hotel;
import com.sanvalero.hotelsapi.domain.Room;
import com.sanvalero.hotelsapi.exception.HotelNotFoundException;
import com.sanvalero.hotelsapi.repository.HotelRepository;
import com.sanvalero.hotelsapi.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * Creado por @ author: Pedro Orós
 * el 16/03/2021
 */

@Service
public class HotelServiceImp implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Set<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Optional<Hotel> findHotelById(int id) {
        Optional<Hotel> hotel = Optional.ofNullable(hotelRepository.findById((long) id)
                .orElseThrow(() -> new HotelNotFoundException()));
        return hotel;
    }

    @Override
    public Set<Hotel> findByLocation(String location) {
        return hotelRepository.findByLocation(location);
    }

    @Override
    public Set<Hotel> findByCategory(String category) {
        return hotelRepository.findByCategory(category);
    }

    @Override
    public Set<Hotel> findByLocationAndCategory(String location, String category) {
        return hotelRepository.findByLocationAndCategory(location, category);
    }

    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Room addRoomToHotel(int id, Room room) {
        Room newRoom = new Room();
        newRoom.setAvailable(room.isAvailable());
        newRoom.setBreakfast(room.isBreakfast());
        newRoom.setPersons(room.getPersons());
        newRoom.setSize(room.getSize());
        newRoom.setPrize(room.getPrize());
        newRoom = roomRepository.save(newRoom);

        Hotel hotel = hotelRepository.findById((long) id)
                .orElseThrow(() -> new HotelNotFoundException());
        newRoom.setHotel_id(hotel);

        hotel.includeRoom(newRoom);

        return newRoom;
    }

    @Override
    public Hotel modifyHotel(int id, Hotel newHotel) {
        Hotel hotel = hotelRepository.findById((long) id)
                .orElseThrow(() -> new HotelNotFoundException());
        newHotel.setId(hotel.getId());
        return hotelRepository.save(newHotel);
    }

    @Override
    public void deleteHotel(int id) {
        Hotel hotel = hotelRepository.findById((long) id)
                .orElseThrow(() -> new HotelNotFoundException(id));
        hotelRepository.delete(hotel);
    }
}
