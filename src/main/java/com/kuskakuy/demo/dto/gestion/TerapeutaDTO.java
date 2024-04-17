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
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({"codigo","nombre_terapeuta", "apellido_terapeuta","especialidad_terapeuta", 
    "direccion_terapeuta", "telefono_terapeuta","nacionalidad_terapeuta","estado"})
public class TerapeutaDTO extends BaseDTO {

    private String nombre_terapeuta;
    private String apellido_terapeuta;
    private String especialidad_terapeuta;
    private String direccion_terapeuta;
    private String telefono_terapeuta;
    private String nacionalidad_terapeuta;

}

//CREATE TABLE terapeuta (
//  id_terapeuta INT PRIMARY KEY AUTO_INCREMENT,
//  nombre_terapeuta VARCHAR(255) NOT NULL,
//  especialidad_terapeuta VARCHAR(255) NOT NULL,
//  id_servicio INT,
//  FOREIGN KEY (id_servicio) REFERENCES servicio (id_servicio)
//);
