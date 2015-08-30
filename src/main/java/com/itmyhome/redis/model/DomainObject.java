package com.itmyhome.redis.model;

import java.io.Serializable;

public interface DomainObject extends Serializable {

	String getKey();

	String getObjectKey();
}