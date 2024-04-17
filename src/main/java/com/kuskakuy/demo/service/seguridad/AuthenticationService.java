
package com.kuskakuy.demo.service.seguridad;

import com.kuskakuy.demo.dto.seguridad.JwtAuthenticationDTOResponse;
import com.kuskakuy.demo.dto.seguridad.SigninDTORequest;

public interface AuthenticationService {
    
    JwtAuthenticationDTOResponse signin(SigninDTORequest request);
}
