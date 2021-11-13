package com.judyprograms.temperthestorm.repository;

import com.judyprograms.temperthestorm.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
}
