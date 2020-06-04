package fr.yncrea.cir3.jeuEchec.controller;


import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/Identify")
public class UserController {
	@Autowired
	private UserRepository user;

	/*
	@Autowired
	private PasswordEncoder encoder;
	*/

	@GetMapping("/login")
	public String login() {
		return "/Identify/login";
	}

	@PostMapping("/login")
	public String log(@ModelAttribute("user") UserForm form, BindingResult result, Model model)
	{
		User u = user.findByPassword(form.getPassword());
		if(form.getPassword() != null && form.getLast_name() != null)
		{
			if(user.findByPassword(form.getPassword()) != null )
			{
				return "redirect:/"+ u.getId();
			}


		}
		return "redirect:/Identify/login";
	}

	@GetMapping("/register")
	public String edit( Model model) {
		model.addAttribute("user", new UserForm());
		return "/Identify/register";
	}

	@PostMapping("/register")
	public String addForm(@ModelAttribute("user") UserForm form, BindingResult result, Model model) {
		User u = new User();
		if (result.hasErrors()) {
			model.addAttribute("user", form);
			return "/Identify/register";
		}
		if(user.findByPassword(form.getPassword()) == null)
		{
			u.setPassword(form.getPassword());
			u.setLast_name(form.getLast_name());
			u.setFirst_name(form.getFirst_name());
			u.setEmail(form.getEmail());
		}
		else
		{
			return "/Identify/register";
		}

		user.save(u);

		return "redirect:/Identify/login";
	}
}
