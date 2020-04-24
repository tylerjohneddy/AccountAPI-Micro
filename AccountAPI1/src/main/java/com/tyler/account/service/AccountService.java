package com.tyler.account.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tyler.account.data.domain.Account;
import com.tyler.account.data.domain.Prize;
import com.tyler.account.data.repo.AccountRepo;

@Service
public class AccountService {

	private AccountRepo repo;

	private RestTemplate rest;

	private LogService log;

	public AccountService(AccountRepo repo, RestTemplateBuilder rtb, LogService log) {
		super();
		this.repo = repo;
		this.log = log;
		this.rest = rtb.build();
	}

	public Account create(Account account) {

		log.log("first name:" + account.getFirstName() + " lastname:" + account.getLastName());

		account.setAccountNumber(rest.getForObject("http://localhost:8081/account/generateNumber", String.class));
		account.setPrize(
				rest.getForObject("http://localhost:8082/account/prize/" + account.getAccountNumber(), Prize.class));
		return this.repo.save(account);
	}

}
