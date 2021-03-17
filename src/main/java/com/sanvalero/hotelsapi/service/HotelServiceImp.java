package com.sanvalero.hotelsapi.service;

import com.sanvalero.hotelsapi.domain.Hotel;
import com.sanvalero.hotelsapi.exception.HotelNotFoundException;
import com.sanvalero.hotelsapi.repository.HotelRepository;
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

    @Override
    public Set<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Optional<Hotel> findHotelById(int id) {
        return hotelRepository.findById((long) id);
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
    public Hotel modifyHotel(int id, Hotel newHotel) {
        Hotel hotel = hotelRepository.findById((long)id)
                .orElseThrow(() -> new HotelNotFoundException(id));
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
