package com.vti.entity.generic;

public class Phone<K, V> extends MyMap {
	
	public Phone(Object key, Object value) {
		super(key, value);
	}

	public V getPhone() {
		return (V) getValue();
	}


}
