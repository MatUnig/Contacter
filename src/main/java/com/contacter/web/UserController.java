package com.contacter.web;

import com.contacter.entity.User;
import com.contacter.repository.UserRepository;
import com.contacter.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
/**
 * Kontroler pozwalający na operacje związane z logowaniem i rejestracją użytkowników.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/add")
    public String showForm(Model model, User user) {
        model.addAttribute("user", user);
        return "userForm";
    }
    @PostMapping("/add")
    public String performForm(@ModelAttribute @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "userForm";
        }
        userService.saveUser(user);
        return "redirect:/";
    }
}
