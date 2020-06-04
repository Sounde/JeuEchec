package fr.yncrea.cir3.jeuEchec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.yncrea.cir3.jeuEchec.domain.User;
import fr.yncrea.cir3.jeuEchec.form.UserForm;
import fr.yncrea.cir3.jeuEchec.repository.FriendRepository;

@Controller
@RequestMapping("/friend")
public class FriendController {
	@Autowired
	private FriendRepository friends;

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("friends", friends.findAll());
		return "friend";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("friend", new UserForm());
		return "friend-add";
	}

	@PostMapping("/add")
	public String addForm(@ModelAttribute UserForm form) {
		User f = new User();
		f.setLast_name(form.getLast_name());
		f.setFirst_name(form.getFirst_name());
		friends.save(f);
		return "redirect:friend/list";
	}
}
