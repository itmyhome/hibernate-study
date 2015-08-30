package com.itmyhome.redis;

import org.springframework.beans.factory.annotation.Autowired;

import com.itmyhome.redis.sendMessage.SendMessage;

public class TestController {
	@Autowired
	SendMessage sendMessage;

	public void redis() {
		for (int i = 0; i < 1000; i++) {
			sendMessage.sendMessage("java", i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}