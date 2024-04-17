package com.kuskakuy.demo.restcontroller.seguridad;

import com.kuskakuy.demo.dto.seguridad.JwtAuthenticationDTOResponse;
import com.kuskakuy.demo.dto.seguridad.SigninDTORequest;
import com.kuskakuy.demo.service.seguridad.AuthenticationService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    
    private final AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationDTOResponse> signin(@RequestBody SigninDTORequest request) {
        log.info("signin ...");
        return ResponseEntity.ok(authenticationService.signin(request));
    }

    @PostMapping("/signin-header")
    public ResponseEntity<JwtAuthenticationDTOResponse> signinHeader(HttpServletResponse response,
            @RequestBody SigninDTORequest request) {
        log.info("signin ...");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization", "Bearer " + authenticationService.signin(request).getToken());

        return ResponseEntity.ok().headers(responseHeaders).build();
    }
}
