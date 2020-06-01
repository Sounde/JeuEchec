package fr.yncrea.cir3.jeuEchec.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="\"board\"")
public class Pawn {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column
	private String pawn_name;
	
	@Column
	private String side;
	
	@Column 
	private int x;
	
	@Column 
	private int y;
	
	@ManyToOne
	private Board board;
}
