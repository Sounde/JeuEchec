package fr.yncrea.cir3.jeuEchec.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="\"board\"")
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column
	private int nb_pawn_alive;
	
	@Column
	private int nb_pawn_white_alive;
	
	@Column
	private int nb_pawn_black_alive;
	
	@Column
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pawn> pawns = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNb_pawn_alive() {
		return nb_pawn_alive;
	}

	public void setNb_pawn_alive(int nb_pawn_alive) {
		this.nb_pawn_alive = nb_pawn_alive;
	}

	public int getNb_pawn_white_alive() {
		return nb_pawn_white_alive;
	}

	public void setNb_pawn_white_alive(int nb_pawn_white_alive) {
		this.nb_pawn_white_alive = nb_pawn_white_alive;
	}

	public int getNb_pawn_black_alive() {
		return nb_pawn_black_alive;
	}

	public void setNb_pawn_black_alive(int nb_pawn_black_alive) {
		this.nb_pawn_black_alive = nb_pawn_black_alive;
	}

	public List<Pawn> getPawns() {
		return pawns;
	}

	public void setPawns(List<Pawn> pawns) {
		this.pawns = pawns;
	}
}
