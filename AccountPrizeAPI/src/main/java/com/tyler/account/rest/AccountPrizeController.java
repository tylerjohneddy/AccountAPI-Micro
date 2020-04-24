package com.tyler.account.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyler.account.data.domain.Prize;
import com.tyler.account.service.AccountPrizeService;

@RestController
@RequestMapping("/account")
public class AccountPrizeController {
	private AccountPrizeService service;

	public AccountPrizeController(AccountPrizeService service) {
		super();
		this.service = service;
	}

	@GetMapping("/prize/{accountNumber}")
	public Prize create(@PathVariable String accountNumber) {
		return this.service.decidePrize(accountNumber);
	}

}
