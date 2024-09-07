package com.improvement.dslearn.servicies;

import com.improvement.dslearn.dto.UserDTO;
import com.improvement.dslearn.entities.User;
import com.improvement.dslearn.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDTO::new).toList();
    }


    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        User user = getId(id);
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO insert(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        userRepository.save(user);
        return new UserDTO(user);
    }


    public User getId(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("id not found: " + id));
    }

}
