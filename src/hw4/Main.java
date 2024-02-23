package hw4;

public class Main {

	public static void main(String[] args) {
		// Instantiate vehicleManager, perform operations based on the requirements.
		VehicleManager vehicleManager = new VehicleManager();
		
		// Read vehicle data from the vehcileList.csv file and initialize objects.
		vehicleManager.initializeStock();
		
		// Display all vehicle information.
		System.out.println("All Vehicle Information:");
		System.out.println("------------------------");
		vehicleManager.displayAllVehicleInformation();
		System.out.println();
		
		// Display all car information.
		System.out.println("All Car Information:");
		System.out.println("------------------------");
		vehicleManager.displayAllCarInformation();
		System.out.println();
		
		// Display all motorbike information.
		System.out.println("All MotorBike Information:");
		System.out.println("------------------------");
		vehicleManager.displayAllMotorBikeInformation();
		System.out.println();
		
		//test to see if highest/lowest maintenance is working
		System.out.println("------------------------");
		Vehicle highMaintVehicle = vehicleManager.getVehicleWithHighestMaintenanceCost(300);
		System.out.println("Vehicle with Highest Maintenance Cost:" + highMaintVehicle);
		
		Vehicle lowMaintVehicle = vehicleManager.getVehicleWithLowestMaintenanceCost(300);
		System.out.println("Vehicle with Lowest Maintenance Cost:" + lowMaintVehicle);
		}

	}
