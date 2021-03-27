package com.sanvalero.hotelsapi.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Creado por @ author: Pedro Orós
 * el 16/03/2021
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "room")
public class Room {

    @Schema(description = "Identificador de la Habitacion", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Schema(description = "Tamaño de la habitacion", example = "mediana")
    @Column
    private String size;
    @Schema(description = "Numero de personas", example = "simple")
    @Column
    private String persons;
    @Schema(description = "Precio de la habitacion", example = "75", required = true)
    @NotBlank
    @Column
    private float prize;
    @Schema(description = "¿Desayuno incluido?", example = "true", defaultValue = "false")
    @Column
    private boolean breakfast;
    @Schema(description = "Disponibilidad de la habitacion", example = "true", defaultValue = "true")
    @NotBlank
    @Column
    private boolean available;
    @Schema(description = "identificador del hotel al que pertenece esta habitacion", example = "1", required = true)
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
