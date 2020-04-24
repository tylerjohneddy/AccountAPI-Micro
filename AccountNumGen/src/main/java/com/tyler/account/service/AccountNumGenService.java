package com.tyler.account.service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class AccountNumGenService {

	public AccountNumGenService() {
		super();
	}

	public String getRandomAccount() {
		String accountNumber = IntStream.rangeClosed(1, (int) ((Math.random() * 2) + 3) * 2)
				.map(num -> (int) ((Math.random() * 9))).boxed().map(num -> num.toString())
				.collect(Collectors.joining(""));
		accountNumber = Character.toString((char) (97 + (int) ((Math.random() * 2)))) + accountNumber.substring(1);

		return accountNumber;
	}
}
