package fr.yncrea.cir3.jeuEchec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.yncrea.cir3.jeuEchec.domain.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
