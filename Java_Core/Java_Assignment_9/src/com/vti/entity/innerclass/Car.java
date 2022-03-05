package com.vti.entity.innerclass;

public class Car {
	private String name;
	private String type;
	private Engine engine;

	public Car(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public class Engine {
		private String engineType;

		public String getEngineType() {
			return engineType;
		}

		public void setEngineType(String engineType) {
			this.engineType = engineType;
		}

	}
}
