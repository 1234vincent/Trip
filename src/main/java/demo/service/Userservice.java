package demo.service;

import demo.dto.UserDTO;
import demo.model.User;
import demo.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
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

    public void registerUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("邮箱已被注册");
        }
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);
        System.out.println("注册成功");
    }

    public void loginUser(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("用户不存在"));

        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("密码错误");
        }
        else {
            System.out.println("登录成功");
        }

        // 登录成功...
    }




}
