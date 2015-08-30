package com.itmyhome.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itmyhome.redis.model.User;
import com.itmyhome.redis.repository.UserRepository;
import com.itmyhome.redis.sendMessage.SendMessage;

public class HelloWorld {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring-config.xml");
//		UserRepository userRepository = (UserRepository) applicationContext
//				.getBean("userRepository");
		SendMessage sendMessage = (SendMessage) applicationContext
				.getBean("sendMessage");
		for (int i = 0; i <1000; i++) {
			sendMessage.sendMessage("java",i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		User user1 = new User("1", "user 1");
//		User user2 = new User("2", "user 2");
//		userRepository.put(user1);
//		System.out.println(" Step 1 output : " + userRepository.getObjects());
//		userRepository.put(user2);
//		System.out.println(" Step 2 output : " + userRepository.getObjects());
//		userRepository.delete(user1);
//		System.out.println(" Step 3 output : " + userRepository.getObjects());
	}
}