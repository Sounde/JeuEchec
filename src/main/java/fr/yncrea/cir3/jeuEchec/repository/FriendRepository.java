package fr.yncrea.cir3.jeuEchec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.yncrea.cir3.jeuEchec.domain.User;

@Repository
public interface FriendRepository extends JpaRepository<User, Long> {

}
