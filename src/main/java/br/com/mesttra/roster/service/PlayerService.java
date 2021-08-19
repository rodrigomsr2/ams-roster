package br.com.mesttra.roster.service;

import br.com.mesttra.roster.dto.DespesaDTO;
import br.com.mesttra.roster.entity.Player;
import br.com.mesttra.roster.enums.ExpenseType;
import br.com.mesttra.roster.exception.ResourceNotFoundException;
import br.com.mesttra.roster.repository.PlayerRepository;
import br.com.mesttra.roster.rest.ExpenseClient;
import br.com.mesttra.roster.rest.MailSenderClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PlayerService {

    PlayerRepository playerRepository;
    
    MailSenderClient mailSenderClient;
    
    ExpenseClient expenseClient;

    public Player addPlayer(Player player) {
    	expenseClient.sendMail(new DespesaDTO(ExpenseType.SALARY, player.getSalary(), LocalDate.now().plusYears(2)));
    	
        return playerRepository.save(player);
    }

    @Transactional
    public Player makePlayerUnavailable(Long playerId) {
        Player player = playerRepository.getById(playerId);
        player.setAvailable(false);
        return playerRepository.save(player);
    }
    
    public List<Player> list() {
    	List<Player> players = this.playerRepository.findAll();
    	
    	if( players.isEmpty() ) {
    		throw new ResourceNotFoundException();
    	}
    	
    	return players;
    }
    
    public Player searchSpecific(Long id) {
    	return this.playerRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
    
    public void fire(Long id) {
    	Player player = this.searchSpecific(id);
    	this.playerRepository.delete(player);
    }
    
}
