package com.sanvalero.hotelsapi.controller;

import com.sanvalero.hotelsapi.domain.Room;
import com.sanvalero.hotelsapi.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Creado por @ author: Pedro Orós
 * el 16/03/2021
 */

@RestController
@Tag(name = "rooms", description = "API de las habitaciones de los hoteles")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Operation(summary = "Obtiene el listado de habitaciones de todos los hoteles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de habitaciones",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Room.class)))),
            @ApiResponse(responseCode = "404", description = "El puesto no existe",
                    content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @GetMapping(value = "/rooms", produces = "application/json")
    public Set<Room> getRooms() {
        return roomService.findAll();
    }
}
