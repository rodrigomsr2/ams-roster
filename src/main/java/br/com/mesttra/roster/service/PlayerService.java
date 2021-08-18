package br.com.mesttra.roster.service;

import br.com.mesttra.roster.dto.DespesaDTO;
import br.com.mesttra.roster.entity.Player;
import br.com.mesttra.roster.enums.ExpenseType;
import br.com.mesttra.roster.repository.PlayerRepository;
import br.com.mesttra.roster.rest.ExpenseClient;
import br.com.mesttra.roster.rest.MailSenderClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
    
}
