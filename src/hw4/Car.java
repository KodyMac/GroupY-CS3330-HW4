package hw4;

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
			
			
			
			
			
			
			
		
