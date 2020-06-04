package fr.yncrea.cir3.jeuEchec.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.yncrea.cir3.jeuEchec.domain.User;
import fr.yncrea.cir3.jeuEchec.form.UserForm;
import fr.yncrea.cir3.jeuEchec.repository.UserRepository;




@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository users;


    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "auth/register";
    }

    @PostMapping("/register")
    public String addForm(@Valid @ModelAttribute("user") UserForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", form);
            return "auth/register";
        }

        User object = new User();
        object.setPassword(encoder.encode(form.getPassword()));
        object.setUsername(form.getUsername());

        users.save(object);

        return "redirect:/login";
    }
}
