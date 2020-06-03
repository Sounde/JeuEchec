package fr.yncrea.cir3.jeuEchec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.yncrea.cir3.jeuEchec.repository.GameRepository;
import fr.yncrea.cir3.jeuEchec.repository.UserRepository;

@Controller
@RequestMapping("/chessgame")
public class ChessGameController {
	@Autowired
	private GameRepository games;
	
	@Autowired
	private UserRepository users;
	
	
	
	
}
