package com.itmyhome.redis.sendMessage;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.itmyhome.redis.model.User;

public class SendMessage {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	public void sendMessage(String channel, Serializable message) {
		redisTemplate.convertAndSend(channel, message);
	}
}