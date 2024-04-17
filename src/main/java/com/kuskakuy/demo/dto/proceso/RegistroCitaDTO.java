package com.kuskakuy.demo.dto.proceso;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.kuskakuy.demo.dto.base.BaseDTO;
import com.kuskakuy.demo.dto.gestion.PacienteDTO;
import com.kuskakuy.demo.dto.gestion.ServicioDTO;
import com.kuskakuy.demo.dto.gestion.TerapeutaDTO;
import java.sql.Date;
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
@JsonPropertyOrder({"codigo","fecha_registro","costo","faltante","pago",
    "comentario","paciente","terapeuta","servicio","fecha_cita", 
    "hora_inicio_cita", "hora_fin_cita","estado"})
public class RegistroCitaDTO extends BaseDTO{

    private Date fecha_registro;
    private float costo;
    private float faltante;
    private float pago;
    private String comentario;
    private PacienteDTO paciente;
    private TerapeutaDTO terapeuta;
    private ServicioDTO servicio;
    private Date fecha_cita;
    private int hora_inicio_cita;
    private int hora_fin_cita;

}
