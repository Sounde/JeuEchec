package fr.yncrea.cir3.jeuEchec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		model.addAttribute("friend", new FriendForm());
		return "friend-add";
	}

	@PostMapping("/add")
	public String addForm(@modelAttribute FriendForm form) {
		Friend f = new Friend();
		f.setLast_name(form.getLast_Name());
		f.setFirst_name(form.getFirst_Name());
		friends.save(f);
		return "redirect:friend/list";
	}
}
