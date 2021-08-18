package br.com.mesttra.roster.controller;

import br.com.mesttra.roster.entity.Player;
import br.com.mesttra.roster.service.PlayerService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {

    PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
    	System.out.println(player);
        return playerService.addPlayer(player);
    }
    
    @PutMapping("/{id}/indisponibilizar")
    public Player desabilitar(@PathVariable("id") Long playerId) {
    	return this.playerService.makePlayerUnavailable(playerId);
    }


}
