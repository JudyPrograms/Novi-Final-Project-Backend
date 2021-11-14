package com.judyprograms.temperthestorm.service;

import com.judyprograms.temperthestorm.model.Player;
import com.judyprograms.temperthestorm.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;


    public Optional<Player> getPlayer(Long id) {
        return playerRepository.findById(id);
    }

    public String updatePlayer(Long id, Player newPlayer) {
        Optional<Player> playerOptional = playerRepository.findById(id);
        if (playerOptional.isEmpty()) {
//            throw new PlayerNotFoundException(userId);
            return "player not fond";
        } else {
            Player player = playerOptional.get();
            player.setTotalPoints(newPlayer.getTotalPoints());
            player.setLevelNumber(newPlayer.getLevelNumber());
            player.setAvatarName(newPlayer.getAvatarName());
//            player.setCurrentSlices(newPlayer.getCurrentSlices());
//            player.setCompletedSlices(newPlayer.getCompletedSlices());
            player.setSubtaskCount(newPlayer.getSubtaskCount());
            playerRepository.save(player);
            return "player updated";
        }
    }
}
