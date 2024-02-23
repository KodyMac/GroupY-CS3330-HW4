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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public long getModelYear() {
		return modelYear;
	}

	public void setModelYear(long modelYear) {
		this.modelYear = modelYear;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public VehicleColor getColor() {
		return color;
	}

	public void setColor(VehicleColor color) {
		this.color = color;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public int getCylinders() {
		return cylinders;
	}

	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}

	public double getGasTankCapacity() {
		return gasTankCapacity;
	}

	public void setGasTankCapacity(double gasTankCapacity) {
		this.gasTankCapacity = gasTankCapacity;
	}

	public StartMechanism getStartType() {
		return startType;
	}

	public void setStartType(StartMechanism startType) {
		this.startType = startType;
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
		System.out.println(this.startType);
	}
	//PUSHSTART

	@Override
	public String toString() {
		return "SUV [brand=" + brand + ", make=" + make + ", modelYear=" + modelYear + ", price=" + price + ", color="
				+ color + ", fuelType=" + fuelType + ", mileage=" + mileage + ", mass=" + mass + ", cylinders="
				+ cylinders + ", gasTankCapacity=" + gasTankCapacity + ", startType=" + startType + "]";
	}
}

