package hw4;

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void startEngine() {
		// TODO Auto-generated method stub
		
	}
}