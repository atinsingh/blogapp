package com.example.bloggingapp.controller;

import com.example.bloggingapp.entity.Blog;
import com.example.bloggingapp.entity.User;
import com.example.bloggingapp.repo.BlogRepo;
import com.example.bloggingapp.repo.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserRepo userRepo;
    private final BlogRepo blogRepo;

    public UserController(UserRepo userRepo, BlogRepo blogRepo) {
        this.userRepo = userRepo;
        this.blogRepo = blogRepo;
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
        model.addAttribute("href", "user/"+user.getId());
        return "user";
    }

    @GetMapping("/user/{id}")
    public String blogForUser(@PathVariable("id") Long userId, Model model){
        model.addAttribute("blogs", blogRepo.findAllByUserId(userId));
        model.addAttribute("userId", userId);
        return "blog";
    }

}
