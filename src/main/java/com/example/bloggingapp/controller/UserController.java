package com.example.bloggingapp.controller;

import com.example.bloggingapp.entity.User;
import com.example.bloggingapp.repo.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/")
    public String indexView(Model model) {
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @PostMapping("/user")
    public String greetingSubmit(@ModelAttribute User user, Model model) {
        userRepo.save(user);
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/user")
    public String getUserForm(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "user";
    }

}
