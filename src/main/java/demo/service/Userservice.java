package demo.service;

import demo.dto.UserDTO;
import demo.model.User;
import demo.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Userservice {

    @Autowired
    private Userrepository userRepository;

    public List<UserDTO> getAllUser() {
        return userRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        return dto;
    }
}
