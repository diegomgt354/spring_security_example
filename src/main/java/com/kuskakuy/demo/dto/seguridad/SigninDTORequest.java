package com.kuskakuy.demo.dto.seguridad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SigninDTORequest {
    
    private String userName;
    private String password;
    
}
