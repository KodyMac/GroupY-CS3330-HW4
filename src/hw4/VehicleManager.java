package hw4;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileWriter;
import java.util.Random;



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
		br.close();
		} catch(IOException e) {
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

            for (Vehicle v : vehicleList) {
                if (v instanceof Car) {
                    writer.write("Car, " + ((Car) v).getBrand() + "," + ((Car) v).getMake() + "," + ((Car) v).getModelYear()
                            + "," + ((Car) v).getPrice() + "," + ((Car) v).getColor() + "," + ((Car) v).getFuelType() + "," + ((Car) v).getMileage() +
                            "," + ((Car) v).getMass() + "," + ((Car) v).getCylinders() + "," + ((Car) v).getGasTankCapacity() + "," + ((Car) v).getStartType() + System.getProperty("line.separator"));
                } else if (v instanceof Truck) {
                	writer.write("Truck, " + ((Truck) v).getBrand() + "," + ((Truck) v).getMake() + "," + ((Truck) v).getModelYear()
                    + "," + ((Truck) v).getPrice() + "," + ((Truck) v).getColor() + "," + ((Truck) v).getFuelType() + "," + ((Truck) v).getMileage() +
                    "," + ((Truck) v).getMass() + "," + ((Truck) v).getCylinders() + "," + ((Truck) v).getGasTankCapacity() + "," + ((Truck) v).getStartType() + System.getProperty("line.separator"));
                } else if (v instanceof MotorBike){
                	writer.write("MotorBike, " + ((MotorBike) v).getBrand() + "," + ((MotorBike) v).getMake() + "," + ((MotorBike) v).getModelYear()
                    + "," + ((MotorBike) v).getPrice() + "," + ((MotorBike) v).getColor() + "," + ((MotorBike) v).getFuelType() + "," + ((MotorBike) v).getMileage() +
                    "," + ((MotorBike) v).getMass() + "," + ((MotorBike) v).getCylinders() + "," + ((MotorBike) v).getGasTankCapacity() + "," + ((MotorBike) v).getStartType() + System.getProperty("line.separator"));
                } else {
                	writer.write("SUV, " + ((SUV) v).getBrand() + "," + ((SUV) v).getMake() + "," + ((SUV) v).getModelYear()
                    + "," + ((SUV) v).getPrice() + "," + ((SUV) v).getColor() + "," + ((SUV) v).getFuelType() + "," + ((SUV) v).getMileage() +
                    "," + ((SUV) v).getMass() + "," + ((SUV) v).getCylinders() + "," + ((SUV) v).getGasTankCapacity() + "," + ((SUV) v).getStartType() + System.getProperty("line.separator"));
                }
            }
            return true;
        } catch (IOException e) {
            System.out.println("File not saved");
            e.printStackTrace();
            return false;
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

//	public Vehicle getVehicleWIthHighestMaintenanceCost(double distance) {
//		double highest = 0;
//		double holder;
//		int highIndex = 0;
//		int index = 0;
//
//		for(Vehicle v : vehicleList) {
//			holder = v.calculateMaintenaceCost(distance);
//			if(holder>highest) {
//				highest = holder;
//				highIndex = index;
//			} 
//			index++;	
//		}
//		return vehicleList.get(highIndex);
//	}

	public Vehicle getVehicleWithHighestMaintenanceCost(double distance) {
		Random random = new Random();
		double highestMaintCost = 0;
		Vehicle highMaintVehicle = null;
		int count = 0;
		
		for (Vehicle v: vehicleList) {
			double maintCost = v.calculateMaintenaceCost(distance);
			if (maintCost > highestMaintCost) {
				highMaintVehicle = v;
				highestMaintCost = maintCost;
				count = 1;
			} else if (maintCost == highestMaintCost){
				count ++;
				if (random.nextInt(count) == 0) {
					highMaintVehicle = v;
				}
			}
		}
		return highMaintVehicle;
	}
	
//	public Vehicle getVehicleWithLowestMaintenanceCost(double distance) {
//		double lowest = 0;
//		double holder;
//		int lowIndex = 0;
//		int index = 0;
//
//		for(Vehicle v : vehicleList) {
//			holder = v.calculateMaintenaceCost(distance);
//			if(holder<lowest) {
//				lowest = holder;
//				lowIndex = index;
//			}
//			index++;
//		}
//		return vehicleList.get(lowIndex);
//	}
	
	public Vehicle getVehicleWithLowestMaintenanceCost(double distance) {
		Random random = new Random();
		double lowestMaintCost = 100000;
		Vehicle lowMaintVehicle = null;
		int count = 0;
		
		for (Vehicle v: vehicleList) {
			double maintCost = v.calculateMaintenaceCost(distance);
			if (maintCost < lowestMaintCost) {
				lowMaintVehicle = v;
				lowestMaintCost = maintCost;
				count = 1;
			} else if (maintCost == lowestMaintCost){
				count ++;
				if (random.nextInt(count) == 0) {
					lowMaintVehicle = v;
				}
			}
		}
		return lowMaintVehicle;
	}
	public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice) {
		double highest = 0;
		double holder;
		int highIndex = 0;
		int index = 0;
		ArrayList<Vehicle> list = new ArrayList<>();
		int listIndex = 0;
		for(Vehicle v : vehicleList) {
			holder = v.calculateFuelEfficiency(distance, fuelPrice);
			if(holder>highest) {
				highest = holder;
				highIndex = index;
			}
			index++;
		}
		list.add(vehicleList.get(highIndex));
		for(Vehicle v : vehicleList) {
			holder = v.calculateFuelEfficiency(distance, fuelPrice);
			if(holder == list.get(1).calculateFuelEfficiency(distance, fuelPrice)) {
				list.add(v);
			}
		}
		return list;
	}
	
	public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice) {
		double lowest = 100000; 
		double holder;
		int lowIndex = 0;
		int index = 0;
		ArrayList<Vehicle> list = new ArrayList<>();
		int listIndex = 0;
		for(Vehicle v : vehicleList) {
			holder = v.calculateFuelEfficiency(distance, fuelPrice);
			if(holder<lowest) {
				lowest = holder;
				lowIndex = index;
			}
			index++;
		}
		list.add(vehicleList.get(lowIndex));
		
		for(Vehicle v : vehicleList) {
			holder = v.calculateFuelEfficiency(distance, fuelPrice);
			if(holder == list.get(1).calculateFuelEfficiency(distance, fuelPrice)) {
				list.add(v);
			}
		}
		return list;
	}
	
	public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice) {
		double total = 0;
		int count = 0;
		
		for (Vehicle v : vehicleList) {
			if (isVehicleType(v, SUV.class)) {
				total += v.calculateFuelEfficiency(distance, fuelPrice);
				count ++;
			} 
		}
		if (count == 0) {
			return -1.0;
		} else {
			double avg = total/count;
			return avg;
		}
	}
}
	
	
	//public void VehicleManager();

