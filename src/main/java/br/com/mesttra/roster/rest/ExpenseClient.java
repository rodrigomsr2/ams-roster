package br.com.mesttra.roster.rest;

import br.com.mesttra.roster.dto.DespesaDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "montlyExpense", url="http://localhost:8083/")
public interface ExpenseClient {

	@RequestMapping("/montlyExpense")
    DespesaDTO sendMail(@RequestBody DespesaDTO despesaDTO);

}
