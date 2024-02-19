package hw4;

public class VehicleManager {
	
	//to-do
	public boolean readFromFile(String fileName);
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
