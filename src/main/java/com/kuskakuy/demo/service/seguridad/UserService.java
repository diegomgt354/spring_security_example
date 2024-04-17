
package com.kuskakuy.demo.service.seguridad;

import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService {
    
    UserDetailsService userDetailsService();
    
}
