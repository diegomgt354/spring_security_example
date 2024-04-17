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

@SuperBuilder
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "TerapeutaEntity")
@Table(name = "terapeuta")
public class TerapeutaEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "nombre_terapeuta", length = 60, nullable = false)
    private String nombre_terapeuta;

    @Column(name = "apellido_terapeuta", length = 60, nullable = false)
    private String apellido_terapeuta;
    
    @Column(name = "especialidad_terapeuta", length = 60, nullable = false)
    private String especialidad_terapeuta;
    
    @Column(name = "direccion_terapeuta", length = 60, nullable = false)
    private String direccion_terapeuta;
    
    @Column(name = "telefono_terapeuta", length = 60, nullable = false)
    private String telefono_terapeuta;
    
    @Column(name = "nacionalidad_terapeuta", length = 60, nullable = false)
    private String nacionalidad_terapeuta;
    
    
}
