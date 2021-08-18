package br.com.mesttra.roster.service;

import br.com.mesttra.roster.entity.Player;
import br.com.mesttra.roster.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PlayerService {

    PlayerRepository playerRepository;

    public Player addPlayer(Player player) {
        // send to financial
        return playerRepository.save(player);
    }

    @Transactional
    public void makePlayerUnavailable(Long playerId) {

        Player player = playerRepository.getById(playerId);
        player.setAvailable(false);
        playerRepository.save(player);

    }
}
