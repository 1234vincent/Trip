package demo.controller;
import java.util.List;

import demo.dto.LoginRequest;
import demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import demo.dto.UserDTO;
import demo.service.Userservice;
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private Userservice userService;
    // 注册模块
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return new ResponseEntity<>("register successful", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("register failed: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        try {
            userService.loginUser(username, password);
            return new ResponseEntity<>("login successful", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("login failed: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/all_user")
    public List<UserDTO> getAllUser() {
        return userService.getAllUser();
    }
}
