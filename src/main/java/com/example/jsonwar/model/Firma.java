package com.example.jsonwar.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Firma {
    @JsonProperty("Nombre")
    private String nombre;

    @JsonProperty("Apellido")
    private String apellido;

    @JsonProperty("Cargo")
    private String cargo;

    @JsonProperty("Empresa")
    private String empresa;

    @JsonProperty("Fecha")
    private String fecha;

    @JsonProperty("Telefono")
    private String telefono;

    @JsonProperty("Correo")
    private String correo;

    @JsonProperty("Observaciones")
    private String observaciones;

    @JsonProperty("Imagen")
    private String imagen;
}
