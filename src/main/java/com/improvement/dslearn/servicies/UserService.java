package com.improvement.dslearn.servicies;

import com.improvement.dslearn.dto.RoleDTO;
import com.improvement.dslearn.dto.UserDTO;
import com.improvement.dslearn.dto.UserInsertDTO;
import com.improvement.dslearn.entities.Role;
import com.improvement.dslearn.entities.User;
import com.improvement.dslearn.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
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
    public UserDTO insert(UserInsertDTO insertDTO) {
        User entity = new User();
        structuringUser(entity, insertDTO);
        entity.setPassword(passwordEncoder.encode(insertDTO.getPassword()));
        userRepository.save(entity);
        return new UserDTO(entity);
    }


    public User getId(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("id not found: " + id));
    }

    @Transactional
    public void structuringUser(User entity, UserDTO userDTO) {
        entity.setName(userDTO.getName());
        entity.setEmail(userDTO.getEmail());

        entity.getRoles().clear();

        for (RoleDTO roleDto : userDTO.getRoles()) {
            Role role = roleRepository.getReferenceById(roleDto.getId());
            entity.getRoles().add(role);
        }

    }

}
