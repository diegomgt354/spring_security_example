package com.kuskakuy.demo.service.impl.seguridad.impl;

import com.kuskakuy.demo.model.seguridad.UserDetailsCustom;
import com.kuskakuy.demo.model.seguridad.UserEntity;
import com.kuskakuy.demo.repository.seguridad.UserRepository;
import static java.util.Objects.isNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByUserName(username);

        if (isNull(userEntity)) {
            throw new UsernameNotFoundException("El usuario " + username + " no existe");
        }
        return new UserDetailsCustom(userEntity);
    }
}
