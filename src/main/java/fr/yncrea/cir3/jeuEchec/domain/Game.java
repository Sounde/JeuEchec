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
	
	@Column
	@ManyToMany(mappedBy = "games")
	private List<User> players = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name = "board_id")
	private Board board;
	
}
