package fr.yncrea.cir3.jeuEchec.classChessGame;


import java.util.ArrayList;
import java.util.List;

import fr.yncrea.cir3.jeuEchec.domain.Pawn;
import fr.yncrea.cir3.jeuEchec.domain.Board;


public class ChessGame {
	
	private List<Pawn> pawns;
	
	public List<Pawn> chessGameInit(Board board){
		pawns = new ArrayList<>();
		
		
		Pawn tour1_blanc = new Pawn();
		Pawn tour2_blanc = new Pawn();
		Pawn cavalier1_blanc = new Pawn();
		Pawn cavalier2_blanc = new Pawn();
		Pawn fou1_blanc = new Pawn();
		Pawn fou2_blanc = new Pawn();
		Pawn reine_blanc = new Pawn();
		Pawn roi_blanc = new Pawn();
		
		
		
		Pawn tour1_noir = new Pawn();
		Pawn tour2_noir = new Pawn();
		Pawn cavalier1_noir = new Pawn();
		Pawn cavalier2_noir = new Pawn();
		Pawn fou1_noir = new Pawn();
		Pawn fou2_noir = new Pawn();
		Pawn reine_noir = new Pawn();
		Pawn roi_noir = new Pawn();
		
		for(int i = 0; i<8;i++) {
			Pawn P_blanc = new Pawn();
			Pawn P_noir = new Pawn();
			
			P_blanc.setPawn_name("pion_blanc");
			P_noir.setPawn_name("pion_noir");
			
			P_blanc.setBoard(board);
			P_noir.setBoard(board);
			
			P_blanc.setEtat(0);
			P_noir.setEtat(0);
			
			P_blanc.setIs_king(0);
			P_noir.setIs_king(0);
			
			P_blanc.setSide("blanc");
			P_noir.setSide("noir");
			
			P_blanc.setX(i+1);
			P_blanc.setY(7);
			
			P_noir.setX(i+1);
			P_noir.setY(2);
			
			pawns.add(P_blanc);
			pawns.add(P_noir);
			
		}
		
		
		tour1_blanc.setPawn_name("tour_blanc");
		tour2_blanc.setPawn_name("tour_noir");
		
		tour1_blanc.setBoard(board);
		tour2_blanc.setBoard(board);
		
		tour1_blanc.setEtat(0);
		tour2_blanc.setEtat(0);
		
		tour1_blanc.setIs_king(0);
		tour2_blanc.setIs_king(0);
		
		tour1_blanc.setSide("blanc");
		tour2_blanc.setSide("blanc");
		
		tour1_blanc.setX(1);
		tour1_blanc.setY(8);
		
		tour2_blanc.setX(8);
		tour2_blanc.setY(8);
		
		pawns.add(tour1_blanc);
		pawns.add(tour2_blanc);
		
		tour1_noir.setPawn_name("tour_blanc");
		tour2_noir.setPawn_name("tour_noir");
		
		tour1_noir.setBoard(board);
		tour2_noir.setBoard(board);
		
		tour1_noir.setEtat(0);
		tour2_noir.setEtat(0);
		
		tour1_noir.setIs_king(0);
		tour2_noir.setIs_king(0);
		
		tour1_noir.setSide("noir");
		tour2_noir.setSide("noir");
		
		tour1_noir.setX(1);
		tour1_noir.setY(1);
		
		tour2_noir.setX(8);
		tour2_noir.setY(1);
		
		pawns.add(tour1_noir);
		pawns.add(tour2_noir);
		
		cavalier1_blanc.setPawn_name("cavalier_blanc");
		cavalier2_blanc.setPawn_name("cavalier_blanc");
		
		cavalier1_blanc.setBoard(board);
		cavalier2_blanc.setBoard(board);
		
		cavalier1_blanc.setEtat(0);
		cavalier2_blanc.setEtat(0);
		
		cavalier1_blanc.setIs_king(0);
		cavalier2_blanc.setIs_king(0);
		
		cavalier1_blanc.setSide("blanc");
		cavalier2_blanc.setSide("blanc");
		
		cavalier1_blanc.setX(2);
		cavalier1_blanc.setY(8);
		
		cavalier2_blanc.setX(7);
		cavalier2_blanc.setY(8);
		
		pawns.add(cavalier1_blanc);
		pawns.add(cavalier2_blanc);
		
		cavalier1_noir.setPawn_name("cavalier_noir");
		cavalier2_noir.setPawn_name("cavalier_noir");
		
		cavalier1_noir.setBoard(board);
		cavalier2_noir.setBoard(board);
		
		cavalier1_noir.setEtat(0);
		cavalier2_noir.setEtat(0);
		
		cavalier1_noir.setIs_king(0);
		cavalier2_noir.setIs_king(0);
		
		cavalier1_noir.setSide("noir");
		cavalier2_noir.setSide("noir");
		
		cavalier1_noir.setX(2);
		cavalier1_noir.setY(1);
		
		cavalier2_noir.setX(7);
		cavalier2_noir.setY(1);
		
		pawns.add(cavalier1_noir);
		pawns.add(cavalier2_noir);
		
		fou1_blanc.setPawn_name("fou_blanc");
		fou2_blanc.setPawn_name("fou_blanc");
		
		fou1_blanc.setBoard(board);
		fou2_blanc.setBoard(board);
		
		fou1_blanc.setEtat(0);
		fou2_blanc.setEtat(0);
		
		fou1_blanc.setIs_king(0);
		fou2_blanc.setIs_king(0);
		
		fou1_blanc.setSide("blanc");
		fou2_blanc.setSide("blanc");
		
		fou1_blanc.setX(3);
		fou1_blanc.setY(8);
		
		fou2_blanc.setX(6);
		fou2_blanc.setY(8);
		
		pawns.add(fou1_blanc);
		pawns.add(fou2_blanc);
		
		fou1_noir.setPawn_name("fou_noir");
		fou2_noir.setPawn_name("fou_noir");
		
		fou1_noir.setBoard(board);
		fou2_noir.setBoard(board);
		
		fou1_noir.setEtat(0);
		fou2_noir.setEtat(0);
		
		fou1_noir.setIs_king(0);
		fou2_noir.setIs_king(0);
		
		fou1_noir.setSide("noir");
		fou2_noir.setSide("noir");
		
		fou1_noir.setX(3);
		fou1_noir.setY(1);
		
		fou2_noir.setX(6);
		fou2_noir.setY(1);
		
		pawns.add(fou1_noir);
		pawns.add(fou2_noir);
		
		reine_blanc.setPawn_name("reine_blanc");
		roi_blanc.setPawn_name("roi_blanc");
		
		reine_blanc.setBoard(board);
		roi_blanc.setBoard(board);
		
		reine_blanc.setEtat(0);
		roi_blanc.setEtat(0);
		
		reine_blanc.setIs_king(0);
		roi_blanc.setIs_king(1);
		
		reine_blanc.setSide("blanc");
		roi_blanc.setSide("blanc");
		
		reine_blanc.setX(4);
		reine_blanc.setY(8);
		
		roi_blanc.setX(5);
		roi_blanc.setY(8);
		
		pawns.add(reine_blanc);
		pawns.add(roi_blanc);
		
		reine_noir.setPawn_name("reine_noir");
		roi_noir.setPawn_name("roi_noir");
		
		reine_noir.setBoard(board);
		roi_noir.setBoard(board);
		
		reine_noir.setEtat(0);
		roi_noir.setEtat(0);
		
		reine_noir.setIs_king(0);
		roi_noir.setIs_king(1);
		
		reine_noir.setSide("noir");
		roi_noir.setSide("noir");
		
		reine_noir.setX(4);
		reine_noir.setY(1);
		
		roi_noir.setX(5);
		roi_noir.setY(1);
		
		pawns.add(reine_noir);
		pawns.add(roi_noir);
		
		
		return pawns;
	}
	
	 
}
