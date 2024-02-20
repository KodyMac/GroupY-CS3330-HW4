package hw4;

import java.time.LocalDate;

public class SUV extends Vehicle{
	public SUV(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType, double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		
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
	public SUV(SUV suv) { 
		super();
		this.brand = suv.brand;
		this.make = suv.make;
		this.modelYear = suv.modelYear;
		this.price = suv.price;
		this.color = suv.color;
		this.fuelType = suv.fuelType;
		this.mileage = suv.mileage;
		this.mass = suv.mass;
		this.cylinders = suv.cylinders;
		this.gasTankCapacity = suv.gasTankCapacity;
		this.startType = suv.startType;
	}

	@Override
	public double calculateMaintenaceCost(double distance) {
		double maintCost;
		double maintNum = 0.001;
		LocalDate date = LocalDate.now();
		int thisYear = date.getYear();
		maintCost = distance * this.mass * (thisYear - this.modelYear) * this.cylinders * maintNum;

		return maintCost;
	}
//	maintenanceCost=distance * mass
//			* (currentYear-modelYear) *
//			cylinders * 0.001

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		double fuelNum = 0.05;
		double fuelEff = this.cylinders * this.gasTankCapacity * (fuelPrice / distance) * fuelNum;
		return fuelEff;
	}
//	fuelEfficiency = cylinders *
//			gasTankCapacity * fuelPrice /
//			distance * 0.05

	@Override
	public void startEngine() {
		// TODO Auto-generated method stub
		
	}
	//PUSHSTART
}
