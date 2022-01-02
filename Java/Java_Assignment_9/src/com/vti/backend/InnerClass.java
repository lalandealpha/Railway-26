package com.vti.backend;

import com.vti.entity.innerclass.CPU;
import com.vti.entity.innerclass.CPU.Processor;
import com.vti.entity.innerclass.CPU.Ram;
import com.vti.entity.innerclass.Car;
import com.vti.entity.innerclass.Car.Engine;

public class InnerClass {
	public void Question1() {
		System.out.println("-------Question 1-------");
		CPU cpu = new CPU(1305f);
		Processor processor = cpu.new Processor(8, "Intel");
		System.out.println(processor.getCache());
		Ram ram = cpu.new Ram(8, "Intel");
		System.out.println(ram.getClockSpeed());
	}

	public void Question2() {
		System.out.println("-------Question 2-------");
		Car car = new Car("Mazda", "8WD");
		Engine engine = car.new Engine();
		engine.setEngineType("Crysler");
		System.out.println(engine.getEngineType());

	}

	public void Question3() {
		System.out.println("-------Question 3-------");
		System.out.println("Đây là inner class");
		System.out.println("Đây là inner class");
	}

	public void Question4() {
		System.out.println("-------Question 4-------");
		System.out.println("Ngày: 31/10/2017");
		System.out.println("Giờ: 10:15:30");
	}
}
