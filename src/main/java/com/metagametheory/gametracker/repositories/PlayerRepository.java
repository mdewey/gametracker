package com.metagametheory.gametracker.repositories;

import com.metagametheory.gametracker.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
