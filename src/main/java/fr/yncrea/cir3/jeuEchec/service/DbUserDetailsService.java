package fr.yncrea.cir3.jeuEchec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.yncrea.cir3.jeuEchec.repository.UserRepository;

@Service
public class DbUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository accounts;
	
	@Override
	public UserDetails loadUserByUsername(String login) {
		UserDetails user = accounts.findByUsername(login);
		if (user == null) {
			throw new UsernameNotFoundException(login);
		}
		
		return user;
	}
}
