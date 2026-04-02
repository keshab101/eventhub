package com.eventhub.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eventhub.entity.Role;
import com.eventhub.entity.User;
import com.eventhub.repository.UserRepository;
import com.eventhub.util.AuthRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    public String register(AuthRequest req) {
        User user = User.builder()
                .username(req.getUsername())
                .password(encoder.encode(req.getPassword()))
                .role(Role.ROLE_USER)
                .build();

        repo.save(user);
        return "User registered";
    }

    public String login(AuthRequest req) {
        User user = repo.findByUsername(req.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtService.generateToken(user.getUsername());
    }
    
}
