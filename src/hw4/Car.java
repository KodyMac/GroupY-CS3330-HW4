package hw4;

import java.time.LocalDate;

public class Car extends Vehicle{
		public Car(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType, double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		
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
		public Car(Car car) { 
			super();
			this.brand = car.brand;
			this.make = car.make;
			this.modelYear = car.modelYear;
			this.price = car.price;
			this.color = car.color;
			this.fuelType = car.fuelType;
			this.mileage = car.mileage;
			this.mass = car.mass;
			this.cylinders = car.cylinders;
			this.gasTankCapacity = car.gasTankCapacity;
			this.startType = car.startType;
		}

		@Override
		public double calculateMaintenaceCost(double distance) {
			double maintCost;
			double maintNum = 0.0005;
			LocalDate date = LocalDate.now();
			int thisYear = date.getYear();
			maintCost = distance * this.mass * (thisYear - this.modelYear) * this.cylinders * maintNum;

			return maintCost;
		}
//		maintenanceCost=distance * mass
//				* (currentYear-modelYear) *
//				cylinders * 0.0005

		@Override
		public double calculateFuelEfficiency(double distance, double fuelPrice) {
			double fuelNum = 0.003;
			double fuelEff = this.cylinders * this.gasTankCapacity * (fuelPrice / distance) * fuelNum;
			return fuelEff;
		}
		//fuelEfficiency = cylinders *
		//gasTankCapacity * fuelPrice /
		//distance * 0.003

		@Override
		public void startEngine() {
			
		}
}
		//PUSHSTART
			
			
			
			
			
			
			
		
