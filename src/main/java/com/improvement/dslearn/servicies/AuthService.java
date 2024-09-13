package com.improvement.dslearn.servicies;


import com.improvement.dslearn.dto.UserLoggedDTO;
import com.improvement.dslearn.entities.User;
import com.improvement.dslearn.repositories.UserRepository;
import com.improvement.dslearn.servicies.exceptions.ForbiddenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public User authenticated() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
            String username = jwtPrincipal.getClaim("username");
            return userRepository.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));

        } catch (Exception e) {
            logger.error("Authentication error: {}", e.getMessage());
            throw new UsernameNotFoundException("User not found");
        }
    }

    @Transactional
    public void validateSelfOrAdmin(Long userId) {
        User user = authenticated();
        if (!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")) {
            throw new ForbiddenException("You do not have permission to access this resource");
        }

    }

    @Transactional(readOnly = true)
    public UserLoggedDTO getMe() {
        User user = authenticated();
        return new UserLoggedDTO(user);
    }



}
