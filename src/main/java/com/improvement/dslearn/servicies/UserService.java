package com.improvement.dslearn.servicies;

import com.improvement.dslearn.dto.UserDTO;
import com.improvement.dslearn.dto.UserLoggedDTO;
import com.improvement.dslearn.entities.User;
import com.improvement.dslearn.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final AuthService authService;

    public UserService(UserRepository userRepository, AuthService authService) {
        this.userRepository = userRepository;
        this.authService = authService;
    }

    @PreAuthorize("isAuthenticated()")
    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        authService.validateSelfOrAdmin(id);
        User user = getId(id);
        return new UserDTO(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> byEmail = userRepository.findByEmail(username);
        if (byEmail.isEmpty()) {
            logger.error("User not found{}", username);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("User found {}", username);
        return byEmail.get();
    }


    public User getId(long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("User not found"));
    }



}
