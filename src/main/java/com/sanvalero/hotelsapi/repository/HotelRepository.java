package com.sanvalero.hotelsapi.repository;

import com.sanvalero.hotelsapi.domain.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Creado por @ author: Pedro Orós
 * el 16/03/2021
 */

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {

    Set<Hotel> findAll();
    Set<Hotel> findByLocation(String location);
    Set<Hotel> findByCategory(String category);
    Set<Hotel> findByLocationAndCategory(String location, String category);
}
