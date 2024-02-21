package hw4;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class VehicleManager {
	private static VehicleManager instance = null;  //instance
	private final static String vehicleFilePath="files/vehicleList.csv";   //filepath
	private final static double distance = 300;
	private final static double fuelPrice = 3.25;
	private List<Vehicle> vehicleList = new ArrayList<>();    //vehicle list
	
	//to-do
	public boolean initializeStock() {
		try {
			List < List <String> > data = new ArrayList<>();
			BufferedReader br = new BufferedReader(new FileReader(vehicleFilePath));
			br.readLine();
			String line = br.readLine();
			while (line != null) {
				List<String> lineData = Arrays.asList(line.split(","));
				data.add(lineData);
				line = br.readLine();
			} 
			for(List<String> list : data) {
				String type = list.get(0);
				String brand = list.get(1);
				String make = list.get(2);
				long modelYear = Long.parseLong(list.get(3));
				double price = Double.parseDouble(list.get(4));
				VehicleColor color = VehicleColor.valueOf(list.get(5));
				FuelType fuelType = FuelType.valueOf(list.get(6));
				double mileage = Double.parseDouble(list.get(7));
				double mass = Double.parseDouble(list.get(8));
				int cylinders = Integer.parseInt(list.get(9));
				double gasTankCapacity = Double.parseDouble(list.get(10));
				StartMechanism startType = StartMechanism.valueOf(list.get(11));
				
				Vehicle vehicle = null;
				switch(type)
				{
				case "Truck":
				{
					Truck truck = new Truck(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
					vehicleList.add(truck);
					break;
				}
				case "Car":
				{
					Car car = new Car(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
					vehicleList.add(car);
					break;
				}
				case "SUV":
				{
					SUV suv = new SUV(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
					vehicleList.add(suv);
					break;
				}
				case "MotorBike":
				{
					MotorBike motorBike = new MotorBike(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
					vehicleList.add(motorBike);
					break;
				}
				default:
				{
					System.out.println("Invalid Vehicle Type");
					break;
				}
			}
		}
	}		
	catch(FileNotFoundException e) {
		e.printStackTrace();
		return false;
	}
		return true;
}

	public void displayAllCarInformation() {
		int num=0;
		for(Vehicle vehicle : vehicleList) {
			if(vehicle instanceof Car) {
				System.out.println(vehicle.toString() + "Maintenance Cost: " + vehicle.calculateMaintenaceCost(distance) + "Fuel Efficiency: " + vehicle.calculateFuelEfficiency(distance, fuelPrice) );
				num++;
			}
		}
		if(num==0) {
			System.out.println("There are no Cars");
		}
	}
	
	public void displayAllTruckInformation() {
		int num=0;
		for(Vehicle vehicle : vehicleList) {
			if(vehicle instanceof Truck) {
				System.out.println(vehicle.toString() + "Maintenance Cost: " + vehicle.calculateMaintenaceCost(distance) + "Fuel Efficiency: " + vehicle.calculateFuelEfficiency(distance, fuelPrice) );
				num++;
			}
		}
		if(num==0) {
			System.out.println("There are no Trucks");
		}
	}
	
	public void displayAllSUVInformation() {
		int num=0;
		for(Vehicle vehicle : vehicleList) {
			if(vehicle instanceof SUV) {
				System.out.println(vehicle.toString() + "Maintenance Cost: " + vehicle.calculateMaintenaceCost(distance) + "Fuel Efficiency: " + vehicle.calculateFuelEfficiency(distance, fuelPrice) );
				num++;
			}
		}
		if(num==0) {
			System.out.println("There are no SUVs");
		}
	}
	
	public void displayAllMotorBikeInformation() {
		int num=0;
		for(Vehicle vehicle : vehicleList) {
			if(vehicle instanceof MotorBike) {
				System.out.println(vehicle.toString() + "Maintenance Cost: " + vehicle.calculateMaintenaceCost(distance) + "Fuel Efficiency: " + vehicle.calculateFuelEfficiency(distance, fuelPrice) );
				num++;
			}
		}
		if(num==0) {
			System.out.println("There are no Motor Bikes");
		}
	}
	
	public void displayVehicleInformation(Vehicle v) {
		
	}
	
	public void displayAllVehicleInformation() {
		
	}
	
	public boolean removeVehicle(Vehicle vehicle) {
		
	}
	
	public boolean addVehicle(Vehicle vehicle) {
		
	}
	
	public boolean saveVehicleList() {
		
	}
	
	private boolean isVehicleType(Vehicle v, Class clazz) {
		
	}
	
	public int getNumberOfVehiclesByType(Class clazz) {
		
	}
	
	public Vehicle getVehicleWIthHighestMaintenanceCost(double distance) {
		
	}
	
	public Vehicle getVehicleWithLowestMaintenanceCost(double distance) {
		
	}
	
	public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice) {
		
	}
	
	public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice) {
		
	}
	
	public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice) {
		
	}
}
	
	
	//public void VehicleManager();

