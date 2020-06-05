package fr.yncrea.cir3.jeuEchec.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="\"game\"")
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column
	private int etat;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date game_time;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user_turn;
	
	@Column
	@ManyToMany(mappedBy = "games")
	private List<User> players = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name = "board_id")
	private Board board;
	
	@Column
	private Long user_win_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getGame_time() {
		return game_time;
	}

	public void setGame_time(Date game_time) {
		this.game_time = game_time;
	}

	public User getUser_turn() {
		return user_turn;
	}

	public void setUser_turn(User user_turn) {
		this.user_turn = user_turn;
	}

	public List<User> getPlayers() {
		return players;
	}

	public void setPlayers(List<User> players) {
		this.players = players;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Long getUser_win_id() {
		return user_win_id;
	}

	public void setUser_win_id(Long user_win_id) {
		this.user_win_id = user_win_id;
	}
	
}
