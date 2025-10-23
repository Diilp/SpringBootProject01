package com.dilipkumarayadav.practicalN012.controller;

import com.dilipkumarayadav.practicalN012.service.UserService;
import com.dilipkumarayadav.practicalN012.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<User> users = service.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("message", "");
        return "index"; // matches index.html
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam("name") String name, Model model) {
        String message = service.addUser(name);
        List<User> users = service.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("message", message);
        return "index";
    }
}
