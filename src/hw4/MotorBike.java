package hw4;

import java.time.LocalDate;

public class MotorBike extends Vehicle{
	public MotorBike(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType, double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		
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
	public MotorBike(MotorBike motorBike) { 
		super();
		this.brand = motorBike.brand;
		this.make = motorBike.make;
		this.modelYear = motorBike.modelYear;
		this.price = motorBike.price;
		this.color = motorBike.color;
		this.fuelType = motorBike.fuelType;
		this.mileage = motorBike.mileage;
		this.mass = motorBike.mass;
		this.cylinders = motorBike.cylinders;
		this.gasTankCapacity = motorBike.gasTankCapacity;
		this.startType = motorBike.startType;
	}

	@Override
	public double calculateMaintenaceCost(double distance) {
		double maintCost;
		double maintNum = 0.0002;
		LocalDate date = LocalDate.now();
		int thisYear = date.getYear();
		maintCost = distance * this.mass * (thisYear - this.modelYear) * this.cylinders * maintNum;

		return maintCost;
	}
//	maintenanceCost=distance * mass
//			* (currentYear-modelYear) *
//			cylinders * 0.0002

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		double fuelNum = 0.001;
		double fuelEff = this.cylinders * this.gasTankCapacity * (fuelPrice / distance) * fuelNum;
		return fuelEff;
	}
//	fuelEfficiency = cylinders *
//			gasTankCapacity * fuelPrice /
//			distance * 0.001

	@Override
	public void startEngine() {
		// TODO Auto-generated method stub
		
	}
	//KICKSTART
}
