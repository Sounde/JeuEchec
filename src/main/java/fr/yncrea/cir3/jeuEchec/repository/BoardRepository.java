package fr.yncrea.cir3.jeuEchec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.yncrea.cir3.jeuEchec.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

}
