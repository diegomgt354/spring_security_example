package com.kuskakuy.demo.dto.seguridad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationDTORequest {
    
    private String userName;
    private String password;
    private String name;
    private String[] roles;
}
