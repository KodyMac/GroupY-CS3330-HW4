package hw4;

import java.time.LocalDate;

public class Truck extends Vehicle{
	public Truck(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType, double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		
		super();
		this.brand = brand;
		this.make = make;
		this.modelYear = modelYear;
		this.price = price;
		this.color = color;
		this.fuelType = fuelType;
		this.mileage = mileage;
		this.mass = mass;
		this.cylinders = cylinders;
		this.gasTankCapacity = gasTankCapacity;
		this.startType = startType;
	}
	
	//copy constructor
	public Truck(Truck truck) { 
		super();
		this.brand = truck.brand;
		this.make = truck.make;
		this.modelYear = truck.modelYear;
		this.price = truck.price;
		this.color = truck.color;
		this.fuelType = truck.fuelType;
		this.mileage = truck.mileage;
		this.mass = truck.mass;
		this.cylinders = truck.cylinders;
		this.gasTankCapacity = truck.gasTankCapacity;
		this.startType = truck.startType;
	}

	@Override
	public double calculateMaintenaceCost(double distance) {
		double maintCost;
		double maintNum = 0.002;
		LocalDate date = LocalDate.now();
		int thisYear = date.getYear();
		maintCost = distance * this.mass * (thisYear - this.modelYear) * this.cylinders * maintNum;

		return maintCost;
	}
//	maintenanceCost=distance * mass
//			* (currentYear-modelYear) *
//			cylinders * 0.002

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		double fuelNum = 0.1;
		double fuelEff = this.cylinders * this.gasTankCapacity * (fuelPrice / distance) * fuelNum;
		return fuelEff;
	}
//	fuelEfficiency = cylinders *
//			gasTankCapacity * fuelPrice /
//			distance * 0.1

	@Override
	public void startEngine() {
		// TODO Auto-generated method stub
		
	}
	//KEYSTART
}