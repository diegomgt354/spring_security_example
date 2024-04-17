package com.kuskakuy.demo.model.proceso;

import com.kuskakuy.demo.model.base.BaseEntity;
import com.kuskakuy.demo.model.gestion.PacienteEntity;
import com.kuskakuy.demo.model.gestion.ServicioEntity;
import com.kuskakuy.demo.model.gestion.TerapeutaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

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
@EqualsAndHashCode (callSuper = false)
@Entity(name = "RegistroCitaEntity")
@Table(name = "registro_cita")

public class RegistroCitaEntity extends BaseEntity implements Serializable {
    
	private static final long serialVersionUID = 1L;  
    
    @Column(name = "fecha_registro", nullable = false, columnDefinition = "DATE")
    private Date fecha_registro;
    
    @Column(name = "costo",  nullable = false)
    private float costo;
    
    @Column(name = "faltante", nullable = false)
    private float faltante;
    
    @Column(name = "pago", nullable = false)
    private float pago;
    
     @Column(name = "comentario", length = 255, nullable = false)
    private String comentario;    
    
    @ManyToOne
    @JoinColumn(name = "paciente", nullable = false)
    private PacienteEntity paciente;
    
    @ManyToOne
    @JoinColumn(name = "terapeuta", nullable = false)
    private TerapeutaEntity terapeuta;
    
    @ManyToOne
    @JoinColumn(name = "servicio", nullable = false)
    private ServicioEntity servicio;
    
    @Column(name = "fecha_cita", nullable = false, columnDefinition = "DATE")
    private Date fecha_cita;
    
    @Column(name = "hora_inicio_cita", nullable = false)
    @Min(7)
    @Max(18)
    private int hora_inicio_cita;
    
    @Column(name = "hora_fin_cita", nullable = false)
    @Min(8)
    @Max(19)
    private int hora_fin_cita;

}
