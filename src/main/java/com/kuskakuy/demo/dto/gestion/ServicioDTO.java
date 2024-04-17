package com.kuskakuy.demo.dto.gestion;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.kuskakuy.demo.dto.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (callSuper= false)
@JsonPropertyOrder({"codigo","nombre_servicio","descripcion_servicio","precio_servicio","estado"})
public class ServicioDTO  extends BaseDTO{
    
    private String nombre_servicio;
    private String descripcion_servicio;
    private float precio_servicio;
    
}

//
//CREATE TABLE servicio (
//  id_servicio INT PRIMARY KEY AUTO_INCREMENT,
//  nombre_servicio VARCHAR(255) NOT NULL,
//  descripcion_servicio TEXT,
//  precio_servicio DECIMAL(10,2) NOT NULL
//);
