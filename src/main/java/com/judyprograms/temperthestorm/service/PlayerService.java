package com.judyprograms.temperthestorm.service;

import com.judyprograms.temperthestorm.exception.RecordNotFoundException;
import com.judyprograms.temperthestorm.model.Player;
import com.judyprograms.temperthestorm.model.User;
import com.judyprograms.temperthestorm.repository.PlayerRepository;
import com.judyprograms.temperthestorm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private UserRepository userRepository;

    public Iterable<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayer(Long id) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isPresent()) {
            return playerRepository.findById(id);
        } else {
            throw new RecordNotFoundException();
        }
    }

    public Long createPlayer(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            Player player = new Player();
            player.setId(id);
            player.setTotalPoints(0L);
//            player.setLevel(newPlayer.getLevel());
//            player.setAvatar(newPlayer.getAvatar());
//            player.setCurrentSlices(newPlayer.getCurrentSlices());
//            player.setCompletedSlices(newPlayer.getCompletedSlices());
            Player newPlayer = playerRepository.save(player);
            return newPlayer.getId();
        } else {
         throw new RecordNotFoundException();
        }
    }

    public void updatePlayer(Long id, Player newPlayer) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isPresent()) {
            Player player = optionalPlayer.get();
            player.setTotalPoints(newPlayer.getTotalPoints());
//            player.setLevel(newPlayer.getLevel());
//            player.setAvatar(newPlayer.getAvatar());
//            player.setCurrentSlices(newPlayer.getCurrentSlices());
//            player.setCompletedSlices(newPlayer.getCompletedSlices());
            playerRepository.save(player);
        } else {
            throw new RecordNotFoundException();
        }
    }
}
