package com.vti.entity.innerclass;

public class CPU {
	private float price;
	private Processor processor;
	private Ram ram;

	public CPU(float price) {
		super();
		this.price = price;
	}

	public Processor getProcessor() {
		return processor;
	}

	public void setProcessor(Processor processor) {
		this.processor = processor;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public class Processor {
		private int coreAmount;
		private String manufacturer;

		public Processor(int coreAmount, String manufacturer) {
			super();
			this.coreAmount = coreAmount;
			this.manufacturer = manufacturer;
		}

		public float getCache() {
			return 4.3f;
		}
	}

	public class Ram {
		private int memory;
		private String manufacturer;

		public Ram(int memory, String manufacturer) {
			super();
			this.memory = memory;
			this.manufacturer = manufacturer;
		}

		public float getClockSpeed() {
			return 5.5f;
		}
	}
}
