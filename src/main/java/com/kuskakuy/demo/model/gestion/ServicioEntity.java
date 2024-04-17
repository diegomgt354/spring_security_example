package com.kuskakuy.demo.model.gestion;

import com.kuskakuy.demo.model.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@ SuperBuilder
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "ServicioEntity")
@Table(name = "servicio")

public class ServicioEntity extends BaseEntity implements Serializable{
    
    private static final long serialVersionUID =1L;
    
    @ Column(name="nombre_servicio", length = 80, nullable = false)
    private String nombre_servicio;
    
    @ Column(name="descripcion_servicio", length = 255, nullable = false)
    private String descripcion_servicio;
    
    @ Column(name="precio_servicio", nullable = false)
    private float precio_servicio;
    
    
}
