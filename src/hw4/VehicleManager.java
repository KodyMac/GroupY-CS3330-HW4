package hw4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hw3.CDRecordProduct;
import hw3.Genre;
import hw3.MediaProduct;
import hw3.TapeRecordProduct;
import hw3.VinylRecordProduct;

public class VehicleManager {
	private final static String vehicleFilePath="files/vehicleList.csv";
	private List<Vehicle> vehicleList = new ArrayList<>();
	//to-do
	public boolean readFromFile(String fileName) {
		try {
			List < List <String> > data = new ArrayList<>();
			BufferedReader br = new BufferedReader(new FileReader(/*fileName*/vehicleFilePath));
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
				if (type.equals("Truck")) {
						vehicle = new Truck(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
				} else if (type.equals("Car")) {
				
					
					/*	product = new VinylRecordProduct(title, price, year, genre);
				} else if (type.equals("SUV")) {
					product = new TapeRecordProduct(title, price, year, genre);
				} else if (type.equals("MotorBike")) {
					product = new recordproduct(title,price,year,genre);
				} else {
					System.out.println("Invalid type");
				}
				
				if (product != null) {
					productList.add(product);
				}
				//System.out.println(product); test
			}
			
			br.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
			
			*/
			
			
			
	}
	public void VehicleManager(String fileName);
	public void displayAllCarInformation();
	public void displayAllTruckInformation();
	public void displayAllSUVInformation();
	public void displayAllMotorBikeInformation();
	public void displayVehicleInformation(Vehicle v);
	public void displayAllVehicleInformation();
	public boolean removeVehicle(Vehicle vehicle);
	public boolean addVehicle(Vehicle vehicle);
	public boolean saveVehicleList();
	private boolean isVehicleType(Vehicle v, Class clazz);
	public int getNumberOfVehiclesByType(Class clazz);
	public Vehicle getVehicleWIthHighestMaintenanceCost(double distance);
	public Vehicle getVehicleWithLowestMaintenanceCost(double distance);
	public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice);
	public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice);
	public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice);
}
