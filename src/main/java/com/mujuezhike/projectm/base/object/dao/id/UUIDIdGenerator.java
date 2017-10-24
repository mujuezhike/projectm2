package com.mujuezhike.projectm.base.object.dao.id;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class UUIDIdGenerator implements IdGenerator{

	private static final String key = "id";
	
	@Override
	public String generator() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	@Override
	public String key() {
		return key;
	}

}
