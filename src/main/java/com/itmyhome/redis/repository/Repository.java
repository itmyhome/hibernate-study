package com.itmyhome.redis.repository;

import java.util.List;

import com.itmyhome.redis.model.DomainObject;

public interface Repository<V extends DomainObject> {

	void put(V obj);

	V get(V key);

	void delete(V key);

	List<V> getObjects();
}