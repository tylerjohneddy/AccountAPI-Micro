package com.tyler.account.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyler.account.service.AccountNumGenService;

@RestController
@RequestMapping("/account")
public class AccountNumController {
	private AccountNumGenService service;

	public AccountNumController(AccountNumGenService service) {
		super();
		this.service = service;
	}

	@GetMapping("/generateNumber")
	public String Generate() {
		return this.service.getRandomAccount();
	}

}
