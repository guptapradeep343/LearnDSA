package com.training.readservice;

import java.util.HashMap;
import java.util.Map;

public class CachedReadService implements ReadService {
	private final ReadService target;
	private final Map<Integer, String> cacheMemory = new HashMap<>();
	public CachedReadService(ReadService target) {
		this.target = target;
	}

	@Override
	public String read(int id) {
		if (cacheMemory.containsKey(id)) {
			return cacheMemory.get(id);
		} else if (target.read(id) != null) {
			String str = target.read(id);
			cacheMemory.put(id, str);
			return str;
		}
		return null;
	}

}
