package com.kuskakuy.demo.model.gestion;

import com.kuskakuy.demo.model.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
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
@Entity(name = "PacienteEntity")
@Table(name = "paciente")

public class PacienteEntity extends BaseEntity implements Serializable {

    //La serialización es el proceso de convertir un objeto en una representación en bytes
    private static final long serialVersionUID = 1L; //garantizar la compatibilidad entre versiones.
    
    @Column(name = "nombre_paciente", length = 50, nullable = false)
    private String nombre_paciente;

    @Column(name = "apellido_paciente", length = 50, nullable = false)
    private String apellido_paciente;

    @Column(name = "genero_paciente", length = 10, nullable = false)
    private String genero_paciente;

    @Column(name = "telefono_paciente", length = 50, nullable = false)
    private String telefono_paciente;

    @Column(name = "correo_paciente", length =20, nullable = false)
    private String correo_paciente;

    @Column(name = "fecha_registro", nullable = false, columnDefinition = "DATE")
    private Date fecha_registro;

}
