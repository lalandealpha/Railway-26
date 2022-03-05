package com.vti.backend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Ford;
import com.vti.entity.Sedan;
import com.vti.entity.Truck;
import com.vti.entity.Vehicle;

public class MyOwnAutoShop {

	public void Question() {
		List<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(new Sedan(250, 46632.65, "Black", 15.39));
		vehicles.add(new Ford(220, 22043.35, "Red", 2015, 1000));
		vehicles.add(new Ford(320, 156043.35, "Blue", 2020, 1400));
		vehicles.add(new Truck(120, 5982.24, "Brown", 3000));

		for (Vehicle v : vehicles) {
			if (v instanceof Sedan) {
				System.out.println(v.toString());
				System.out.println("Saled price of Sedan: " + v.getSalePrice());
			} else if (v instanceof Ford) {
				System.out.println(v.toString());
				System.out.println("Saled price of Ford: " + v.getSalePrice());
			} else if (v instanceof Truck) {
				System.out.println(v.toString());
				System.out.println("Saled price of Truck: " + v.getSalePrice());
			}
		}
	}
}
