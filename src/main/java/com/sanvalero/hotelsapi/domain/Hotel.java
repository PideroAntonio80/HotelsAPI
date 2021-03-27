package com.sanvalero.hotelsapi.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Creado por @ author: Pedro Orós
 * el 16/03/2021
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "hotel")
public class Hotel {

    @Schema(description = "Identificador del Hotel", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Schema(description = "Nombre del Hotel", example = "Pirineos", required = true)
    @NotBlank
    @Column
    private String name;
    @Schema(description = "Descripcion del Hotel", example = "Acogedor, centrico, todos los servicios...")
    @Column
    private String description;
    @Schema(description = "Categoria del Hotel", example = "3", required = true)
    @NotBlank
    @Column
    private String category;
    @Schema(description = "¿Tiene piscina el Hotel?", example = "true", defaultValue = "false")
    @NotBlank
    @Column
    private boolean pool;
    @Schema(description = "Localidad donde se encuentra el Hotel", example = "Huesca", required = true)
    @NotBlank
    @Column
    private String location;
    /*@Schema(description = "Identificadores de las habitaciones que tiene el Hotel", example = "1", required = true)
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;*/

    /*public void includeRoom(Room room) {
        if(rooms == null) rooms = new ArrayList<>();

        rooms.add(room);
        room.setHotel(this);
    }*/

    /*public void includeRoom(long idRoom) {
        if(rooms.size() == 0) rooms = new ArrayList<>();

        rooms.add(idRoom);
    }*/
}
