package com.judyprograms.temperthestorm.repository;

import com.judyprograms.temperthestorm.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
