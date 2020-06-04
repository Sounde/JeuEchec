package fr.yncrea.cir3.jeuEchec.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.yncrea.cir3.jeuEchec.classChessGame.ChessGame;
import fr.yncrea.cir3.jeuEchec.domain.Board;
import fr.yncrea.cir3.jeuEchec.domain.Game;
import fr.yncrea.cir3.jeuEchec.domain.Pawn;
import fr.yncrea.cir3.jeuEchec.domain.User;
import fr.yncrea.cir3.jeuEchec.form.ChessGameForm;
import fr.yncrea.cir3.jeuEchec.repository.BoardRepository;
import fr.yncrea.cir3.jeuEchec.repository.GameRepository;
import fr.yncrea.cir3.jeuEchec.repository.PawnRepository;
import fr.yncrea.cir3.jeuEchec.repository.UserRepository;

@Controller
@RequestMapping("/chessgame")
public class ChessGameController {
	@Autowired
	private GameRepository games;
	
	@Autowired
	private UserRepository users;
	
	@Autowired
	private BoardRepository boards;
	
	@Autowired
	private PawnRepository allpawns;
	
	@GetMapping("/board/{id_j1}/{id_j2}/{id_g}")
	public String board(Model model,@PathVariable("id_j1") Long id_j1,@PathVariable("id_j2") Long id_j2,@PathVariable("id_g") Long id_g) {
		Optional<User> j1OP = users.findById(id_j1);
		Optional<User> j2OP = users.findById(id_j2);
		Optional<Game> gOP = games.findById(id_g);
		
		User joueur1 = j1OP.get();
		User joueur2 = j2OP.get();
		Game game = gOP.get();
		
		User joueur_turn = game.getUser_turn();
		model.addAttribute("joueur1",joueur1);
		model.addAttribute("joueur2",joueur2);
		model.addAttribute("joueur2",joueur2);
		model.addAttribute("game",game);
		model.addAttribute("joueur_turn",joueur_turn);
		
		
		return "board"; 
	}
	
	@GetMapping("/create/{id_user}")
	public String create(Model model, @PathVariable("id_user") Long id_user) {
		Optional<User> j1OP = users.findById(id_user);
		User joueur1 = j1OP.get();
		model.addAttribute("chessGame", new ChessGameForm());
		model.addAttribute("joueur1", joueur1);
		List<User> friends = joueur1.getFriends();
		model.addAttribute("friends",friends);
		
		return "game-create";
	}
	
	@PostMapping("/create")
	public String createForm(@ModelAttribute ChessGameForm form) {
		Optional<User> j1OP = users.findById(form.getId_joueur1());
		Optional<User> j2OP = users.findById(form.getId_joueur2());
		
		List<Game> gamej1= new ArrayList<>();
		List<Game> gamej2= new ArrayList<>();
		
		
		User joueur1 = j1OP.get();
		User joueur2 = j2OP.get();
		List<User> joueurs = new ArrayList<>();
		joueurs.add(joueur1);
		joueurs.add(joueur2);
		
		
		
		
		
		Game g = new Game();
		Date actuelle = new Date();
		g.setDate(actuelle);
		g.setEtat(0);
		g.setUser_turn(joueur1);
		g.setPlayers(joueurs);
		
		Board b = new Board();
		b.setNb_pawn_alive(32);
		b.setNb_pawn_black_alive(16);
		b.setNb_pawn_white_alive(16);
		
		ChessGame chessgame = new ChessGame();
		List<Pawn> pawns = new ArrayList<>();
		pawns = chessgame.chessGameInit(b);
		b.setPawns(pawns);
		
		g.setBoard(b);
		
		gamej1 = joueur1.getGames();
		gamej2 = joueur2.getGames();
		
		gamej1.add(g);
		gamej2.add(g);
		
		joueur1.setGames(gamej1);
		joueur2.setGames(gamej2);
		
		games.save(g);
		boards.save(b);
		users.save(joueur1);
		users.save(joueur2);
		
		
		
		
		
		for(int i = 0; i<32; i++) {
			allpawns.save(pawns.get(i));
		}
		
		return "redirect:/chessgame/board/"+joueur1.getId()+"/"+joueur2.getId()+"/"+g.getId();
	}
	
	
}
