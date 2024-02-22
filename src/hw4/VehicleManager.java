package hw4;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileWriter;



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
		System.out.println(v.toString());
	}
	
	public void displayAllVehicleInformation() {
		for(Vehicle vehicle : vehicleList) {
				System.out.println(vehicle.toString() + "Maintenance Cost: " + vehicle.calculateMaintenaceCost(distance) + "Fuel Efficiency: " + vehicle.calculateFuelEfficiency(distance, fuelPrice) );
			}
	}
	
	public boolean removeVehicle(Vehicle vehicle) {
		return vehicleList.remove(vehicle);
	}
	
	public boolean addVehicle(Vehicle vehicle) {
		return vehicleList.add(vehicle);
	}
	
	//used last week's homework as an example, not sure if this is right
	public boolean saveVehicleList() {
		try (FileWriter writer = new FileWriter(vehicleFilePath)) {
            String[] headers = { "Type", "Model", "Make", "ModelYear", "Price", "Color", "FuelType", "Mileage", "Mass", "Cylinders", "GasTankCapacity", "StartType"};
            for (int i = 0; i < headers.length; i++) {
                writer.append(headers[i]);
                if (i < headers.length - 1) {
                    writer.append(", ");
                }
            }
            writer.append(System.getProperty("line.separator"));

            for (Vehicle vehicle : vehicleList) {
                if (vehicle instanceof Car) {
                    writer.write("Car, " + vehicle.getModel() + "," + vehicle.getMake() + "," + vehicle.getModelYear()
                            + "," + vehicle.getPrice() + "," + vehicle.getColor() + "," + vehicle.getFuelType + "," + vehicle.getMileage() +
                            "," + vehicle.getMass() + "," + vehicle.getCylinders() + "," + vehicle.getGasTankCapacity() + "," + vehicle.getStartType() + System.getProperty("line.separator"));
                } else if (vehicle instanceof Truck) {
                	writer.write("Truck, " + vehicle.getModel() + "," + vehicle.getMake() + "," + vehicle.getModelYear()
                    + "," + vehicle.getPrice() + "," + vehicle.getColor() + "," + vehicle.getFuelType + "," + vehicle.getMileage() +
                    "," + vehicle.getMass() + "," + vehicle.getCylinders() + "," + vehicle.getGasTankCapacity() + "," + vehicle.getStartType() + System.getProperty("line.separator"));
                } else if (vehicle instanceof MotorBike){
                	writer.write("MotorBike, " + vehicle.getModel() + "," + vehicle.getMake() + "," + vehicle.getModelYear()
                    + "," + vehicle.getPrice() + "," + vehicle.getColor() + "," + vehicle.getFuelType + "," + vehicle.getMileage() +
                    "," + vehicle.getMass() + "," + vehicle.getCylinders() + "," + vehicle.getGasTankCapacity() + "," + vehicle.getStartType() + System.getProperty("line.separator"));
                } else {
                	writer.write("SUV, " + vehicle.getModel() + "," + vehicle.getMake() + "," + vehicle.getModelYear()
                    + "," + vehicle.getPrice() + "," + vehicle.getColor() + "," + vehicle.getFuelType + "," + vehicle.getMileage() +
                    "," + vehicle.getMass() + "," + vehicle.getCylinders() + "," + vehicle.getGasTankCapacity() + "," + vehicle.getStartType() + System.getProperty("line.separator"));
                }
            }
            return true;
        } catch (IOException e) {
            System.out.println("File not saved");
            e.printStackTrace();
            return false;
        }
    }
	}
	
	private boolean isVehicleType(Vehicle v, Class clazz) {
		return v.getClass().equals(clazz);
	}
	
	public int getNumberOfVehiclesByType(Class clazz) {
		int num = 0;
		for(Vehicle v : vehicleList) {
			if(isVehicleType(v,clazz)) {
				num++;
			}
		}
		return num;
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

