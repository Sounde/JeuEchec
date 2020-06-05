package fr.yncrea.cir3.jeuEchec.service;





import org.springframework.stereotype.Service;

import fr.yncrea.cir3.jeuEchec.domain.User;
import fr.yncrea.cir3.jeuEchec.form.UserForm;


@Service
public class UserService {


	public UserForm createForm(User user) {
		UserForm form = new UserForm();
		if (user == null) {
			return form;
		}

		form.setId(user.getId());
		form.setUsername(user.getUsername());
		form.setEmail(user.getEmail());
		form.setPassword(user.getPassword());


		return form;
	}

	public User update(User user, UserForm form) {
		if (user == null) {
			user = new User();
		}

		user.setUsername(form.getUsername());
		user.setEmail(form.getEmail());
		user.setPassword(form.getPassword());

		return user;
	}
	/*
	@Transactional
	public void remove(Long id) {
		Optional<User> userOpt = users.findById(id);
		if (userOpt.isPresent()) {
			User user = userOpt.get();
			games.deleteByBlackOrWhite(user, user);
			users.delete(user);
		}
	}
	*/
}
