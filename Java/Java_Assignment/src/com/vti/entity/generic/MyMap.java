package com.vti.entity.generic;

public class MyMap<K, V> {
	protected K key;
	protected V value;
	
	public MyMap(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public MyMap() {
		// TODO Auto-generated constructor stub
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
}
