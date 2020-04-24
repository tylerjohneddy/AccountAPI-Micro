package com.tyler.account.service;

import org.springframework.stereotype.Service;

import com.tyler.account.data.domain.Prize;

@Service
public class AccountPrizeService {

	private Prize prize;

	public AccountPrizeService() {
		super();
	}

	public Prize decidePrize(String accountNumber) {
		int accountNumberLength = accountNumber.length();
		if (accountNumber.startsWith("a")) {
			prize = new Prize(null, 0);
		}

		else if (accountNumberLength == 6) {

			if (accountNumber.startsWith("b")) {
				prize = new Prize(null, 50);
			} else if (accountNumber.startsWith("c")) {
				prize = new Prize(null, 100);
			}

		} else if (accountNumberLength == 8) {
			if (accountNumber.startsWith("b")) {
				prize = (new Prize(null, 500));
			} else if (accountNumber.startsWith("c")) {
				prize = (new Prize(null, 750));
			}

		} else if ((accountNumberLength == 10)) {
			if (accountNumber.startsWith("b")) {
				prize = (new Prize(null, 5000));
			} else if (accountNumber.startsWith("c")) {
				prize = (new Prize(null, 10000));
			}

		}
		return prize;

	}
}
