package br.com.mesttra.roster.service;

import br.com.mesttra.roster.entity.Player;
import br.com.mesttra.roster.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PlayerService {

    PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Transactional
    public void makePlayerUnavailable(Long playerId) {

        Player player = playerRepository.getById(playerId);
        player.setAvailable(false);
        playerRepository.save(player);

    }
}
