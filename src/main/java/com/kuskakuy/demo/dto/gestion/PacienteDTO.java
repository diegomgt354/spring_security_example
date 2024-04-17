package com.kuskakuy.demo.dto.gestion;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.kuskakuy.demo.dto.base.BaseDTO;
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
@EqualsAndHashCode (callSuper= false)
@JsonPropertyOrder({"codigo","nombre_paciente", "apellido_paciente", "genero_paciente",
    "telefono_paciente","correo_paciente", "fecha_registro","estado"})
public class PacienteDTO extends BaseDTO {
    
    private String nombre_paciente;
    private String apellido_paciente;
    private String genero_paciente;
    private String telefono_paciente;
    private String correo_paciente;
    private Date fecha_registro;
    
}
