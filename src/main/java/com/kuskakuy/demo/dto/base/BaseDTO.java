
package com.kuskakuy.demo.dto.base;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO {
    
    @Default
    private Long codigo = 0L;
    
    private boolean estado;
    
    public boolean getEstado() {
    	return this.estado;
    }
}
