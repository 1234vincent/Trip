package demo.service;

import demo.dto.UserDTO;
import demo.model.Travel;
import demo.model.User;
import demo.repository.Userrepository;
import demo.repository.Triprepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class Userservice {
    private static final Logger logger = LoggerFactory.getLogger(Userservice.class);

    @Autowired
    private Userrepository userRepository;
    @Autowired
    private Triprepository travelRepository;
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

    public void Save_Directions(String origin, String destination, int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Travel travel = new Travel();
        travel.setStartLocation(origin);
        travel.setEndLocation(destination);
        travel.setUser(user);

        travelRepository.save(travel);
        logger.info("保存成功: 用户ID: {}, 起点: {}, 终点: {}", userId, origin, destination);
    }

}
