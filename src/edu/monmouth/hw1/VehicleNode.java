package edu.monmouth.hw1;
import edu.monmouth.vehicle.Vehicle;

public class VehicleNode 
{
	private Vehicle vehicle;
	private VehicleNode next;
	
	public VehicleNode(Vehicle v)
	{
		setVehicle(v);
		setNext(null);
	}

	public Vehicle getVehicle() 
	{
		return vehicle;
	}
	public void setVehicle(Vehicle v) 
	{
		vehicle = v;
	}
	public VehicleNode getNext() 
	{
		return next;
	}
	public void setNext(VehicleNode n) 
	{
		next = n;
	}
	@Override
	public String toString()
	{
		if(vehicle == null) 
		{
			return "No vehicle";
		}
		return vehicle.toString();
	}
	
}
