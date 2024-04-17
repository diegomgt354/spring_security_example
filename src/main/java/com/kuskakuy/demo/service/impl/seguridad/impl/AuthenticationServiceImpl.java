package com.kuskakuy.demo.service.impl.seguridad.impl;

import com.kuskakuy.demo.dto.seguridad.JwtAuthenticationDTOResponse;
import com.kuskakuy.demo.dto.seguridad.SigninDTORequest;
import com.kuskakuy.demo.service.seguridad.AuthenticationService;
import com.kuskakuy.demo.service.seguridad.JwtService;
import static java.util.Objects.isNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationDTOResponse signin(SigninDTORequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());
        if (isNull(userDetails)) {
            throw new IllegalArgumentException("Invalid user or password.");
        }

        String jwt = jwtService.generateToken(userDetails);

        return JwtAuthenticationDTOResponse.builder().token(jwt).build();
    }
}