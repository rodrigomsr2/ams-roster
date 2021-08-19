package br.com.mesttra.roster.controller;

import br.com.mesttra.roster.entity.Player;
import br.com.mesttra.roster.service.PlayerService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
    
    @PatchMapping("/{id}/unavailable")
    public Player desabilitar(@PathVariable("id") Long playerId) {
    	return this.playerService.makePlayerUnavailable(playerId);
    }
    
    @GetMapping
    public List<Player> list() {
    	return this.playerService.list();
    }
    
    @GetMapping("/{id}")
    public Player searchSpecific(@PathVariable("id") Long playerId) {
    	return this.playerService.searchSpecific(playerId);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> fire(@PathVariable("id") Long playerId) {
    	this.playerService.fire(playerId);
    	return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public Player update(@PathVariable("id") Long playerId, @RequestBody Player updatedPlayer) {
//    	return this.playerService.update(playerId, updatedPlayer);
    	return null;
    }


}
