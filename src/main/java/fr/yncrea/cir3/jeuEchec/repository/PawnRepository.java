package fr.yncrea.cir3.jeuEchec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.yncrea.cir3.jeuEchec.domain.Pawn;

public interface PawnRepository extends JpaRepository<Pawn, Long>{

}
