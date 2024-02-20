package hw4;

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
		// TODO Auto-generated method stub
		return 0;
	}
//	maintenanceCost=distance * mass
//			* (currentYear-modelYear) *
//			cylinders * 0.001

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		// TODO Auto-generated method stub
		return 0;
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
