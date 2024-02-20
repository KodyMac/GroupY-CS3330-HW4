package hw4;

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
		// TODO Auto-generated method stub
		return 0;
	}
//	maintenanceCost=distance * mass
//			* (currentYear-modelYear) *
//			cylinders * 0.0002

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		// TODO Auto-generated method stub
		return 0;
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
