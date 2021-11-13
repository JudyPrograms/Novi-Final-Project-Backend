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

    public Optional<Player> getPlayer(long id) {
        return playerRepository.findById(id);
    }

//    public String createPlayer(long userId) {
//        Player player = new Player();
//        player.setId(userId);
//        Player savedPlayer = playerRepository.save(player);
//        return "created:" + savedPlayer.getId();
////        return (savedPlayer.getAvatar().getName());
//    }

//    Een user met 'lege' player die al aan elkaar gekoppeld zijn (?) of anders
//    eerst gekoppeld moet worden, van die user de player waardes initiëren:
    public String updateNewPlayer(long id, Player newPlayer) {
        Optional<Player> playerOptional = getPlayer(id);
        Player player = playerOptional.get();
        player.setTotalPoints(0);
        player.setSubtaskCount(0);
//        player.setLevel;
//        player.setAvatar;
        playerRepository.save(player);
        return "player updated";
    }

    public void updatePlayer(long userId, Player newPlayer) {
        Optional<Player> playerOptional = playerRepository.findById(userId);
        if (playerOptional.isEmpty()) {
//            throw new PlayerNotFoundException(userId);
        } else {
            Player player = playerOptional.get();
            player.setTotalPoints(newPlayer.getTotalPoints());
//            player.setLevel(newPlayer.getLevel());
//            player.setAvatar(newPlayer.getAvatar());
//            player.setCurrentSlices(newPlayer.getCurrentSlices());
//            player.setCompletedSlices(newPlayer.getCompletedSlices());
            player.setSubtaskCount(newPlayer.getSubtaskCount());
            playerRepository.save(player);
        }
    }
}
