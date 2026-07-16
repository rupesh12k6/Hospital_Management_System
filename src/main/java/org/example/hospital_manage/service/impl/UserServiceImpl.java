package org.example.hospital_manage.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.hospital_manage.repository.UserRepository;
import org.example.hospital_manage.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

}
