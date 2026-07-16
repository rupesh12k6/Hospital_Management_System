package org.example.hospital_manage.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.hospital_manage.dtos.internal.PatientRegistrationRequest;
import org.example.hospital_manage.entity.Patient;
import org.example.hospital_manage.entity.User;
import org.example.hospital_manage.enums.Role;
import org.example.hospital_manage.repository.PatientRepository;
import org.example.hospital_manage.repository.UserRepository;
import org.example.hospital_manage.service.CodeGenerator;
import org.example.hospital_manage.service.PatientService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Transactional
@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
   private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void patientRegistrationRequest(PatientRegistrationRequest request) {
        // Create User
        User user = new User();
        user.setRole(Role.ROLE_PATIENT);
        user.setEnabled(true);
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());

        // Temporary password (replace later with a random generator)
        String temporaryPassword = request.getLastName() + "@123";
        user.setPassword(passwordEncoder.encode(temporaryPassword));

        // Save first to generate User ID
        user = userRepository.save(user);

        // Generate username from User ID
        String patientCode = CodeGenerator.patientCode(user.getId());

        user.setUsername(patientCode);

        // Update user with generated username
        user = userRepository.save(user);

        // Create Patient Profile
        Patient patient = new Patient();

        patient.setUserCode(patientCode);   // Recommended field name
        patient.setUser(user);

        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setGender(request.getGender());
        patient.setDateOfBirth(request.getDateOfBirth());

        patientRepository.save(patient);
    }

}
