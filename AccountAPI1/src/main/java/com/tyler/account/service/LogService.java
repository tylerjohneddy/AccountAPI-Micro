package com.tyler.account.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class LogService {

	private JmsTemplate jms;

	public LogService(JmsTemplate jms) {
		super();
		this.jms =jms;
	}

	public void log(String msg) {
		jms.convertAndSend(msg);
	}

}
