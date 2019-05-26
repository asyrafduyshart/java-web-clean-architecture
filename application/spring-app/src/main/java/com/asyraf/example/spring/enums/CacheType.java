package com.asyraf.example.spring.enums;

/**
 * @author <a href="http://github.com/asyrafduyshart">Asyraf Duyshart</a>
 * @date 5/26/2019
 * @since JDK1.8
 */
public enum CacheType {
	REDIS,
	MAP;

	public boolean isRedis() {
		return name().equals(REDIS.name());
	}

	public boolean isMap() {
		return name().equals(MAP.name());
	}
}
