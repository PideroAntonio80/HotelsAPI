package com.sanvalero.hotelsapi.controller;

import com.sanvalero.hotelsapi.domain.Hotel;
import com.sanvalero.hotelsapi.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Creado por @ author: Pedro Orós
 * el 16/03/2021
 */

@RestController
@Tag(name = "hotels", description = "API de Hoteles")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Operation(summary = "Obtiene el listado de hoteles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de Hoteles",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Hotel.class)))),
            @ApiResponse(responseCode = "404", description = "El puesto no existe",
                    content = @Content(schema = @Schema(implementation = Response.class)))
    })

    @GetMapping(value = "/hotels", produces = "application/json")
    public Set<Hotel> getHotels() {
        return hotelService.findAll();
    }

    @Operation(summary = "Obtiene los hoteles de una locadidad y una categoria determinadas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe el hotel", content = @Content(schema = @Schema(implementation = Hotel.class))),

    })

    @GetMapping(value = "/hotels/{location}/{category}", produces = "application/json")
    public ResponseEntity<Set<Hotel>> getHotelByLocationAndCategory(@PathVariable String location, @PathVariable String category) {
        Set<Hotel> myHotels = hotelService.findByLocationAndCategory(location, category);
        return new ResponseEntity<>(myHotels, HttpStatus.OK);
    }

    @Operation(summary = "Registra un nuevo hotel")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se registra un nuevo hotel", content = @Content(schema = @Schema(implementation = Hotel.class)))
    })
    @PostMapping(value = "/hotels", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        Hotel addedHotel = hotelService.addHotel(hotel);
        return new ResponseEntity<>(addedHotel, HttpStatus.CREATED);
    }
}
