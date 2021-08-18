package br.com.mesttra.roster.dto;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.mesttra.roster.enums.ExpenseType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DespesaDTO {

    @Enumerated(EnumType.STRING)
    private ExpenseType expenseType;

    private Double amount;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dueDate;
	
}
