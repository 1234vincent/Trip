package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.dto.UserDTO;
import demo.service.Userservice;
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Userservice userService;

    @GetMapping("/all_user")
    public List<UserDTO> getAllUser() {
        return userService.getAllUser();
    }
    
}
