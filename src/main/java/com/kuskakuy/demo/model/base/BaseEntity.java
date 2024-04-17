package com.kuskakuy.demo.model.base;

import jakarta.persistence.MappedSuperclass;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {
    
    @Id
    @Column(name="codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    
    @Column(name ="estado",nullable = false)
    private boolean estado;
    
    public boolean getEstado(){
        return this.estado;
    }
    
    
}
