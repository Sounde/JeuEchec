package fr.yncrea.cir3.jeuEchec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping({ "/add", "edit/{id}" })
    public String add(@PathVariable(required = false) Long id, Model model) {
		UserForm form = new UserForm();
        model.addAttribute("contact", form);
        model.addAttribute("friends", friends.findAll());

        if (id != null) {
            List<User> f = new ArrayList<>();
            form.setUsername(friends.findByUsername(f.get(0)));

            if (f.getFriends() != null) {
                form.setFriends(f.getFriends().getId());
            }
        }

        return "friend-add";
    }

	@PostMapping("/add")
	public String addForm(@ModelAttribute UserForm form) {
		User f = new User();
		f.setUsername(form.getUsername());
		friends.save(f);
		return "redirect:friend/list";
	}
}
