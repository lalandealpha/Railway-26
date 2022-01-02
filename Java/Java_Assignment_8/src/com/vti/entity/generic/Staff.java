package com.vti.entity.generic;

public class Staff<K, V> extends MyMap {
	public Staff(Object key, Object value) {
		super(key, value);
	}

	public K getId() {
		return (K) getKey();
	}
	
	public V getName() {
		return (V) getValue();
	}
}
