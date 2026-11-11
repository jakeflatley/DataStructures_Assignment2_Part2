package edu.monmouth.vehicle;

public class Boat implements Vehicle
{
	private int boatLength;
	private PowerTypes powerSource;
	
	public Boat(PowerTypes p, int bl) throws BoatException
	{
		setBoatLength(bl);
		setPowerSource(p);
	}

	public int getBoatLength() 
	{
		return boatLength;
	}
	public void setBoatLength(int bl) throws BoatException
	{
		if(bl < VehicleConstants.MINBOATLENGTH || bl > VehicleConstants.MAXBOATLENGTH)
		{
			throw new BoatException("Invalid boat length " + bl + ": Must be between " + VehicleConstants.MINBOATLENGTH + " - " + VehicleConstants.MAXBOATLENGTH);
		}
		boatLength = bl;
	}
	public PowerTypes getPowerSource() 
	{
		return powerSource;
	}
	public void setPowerSource(PowerTypes p) 
	{
		powerSource = p;
	}
	@Override
	public void go()
	{
		System.out.println("The boat is moving");
	}
	@Override
	public void stop()
	{
		System.out.println("The boat is stopping");
	}
	@Override
	public PowerTypes powerBy()
	{
		return powerSource;
	}
	@Override
	public String toString()
	{
		return "Boat | Boat Length: " + boatLength + " | Power Source: " + powerSource;
	}
	@Override
	public boolean equals(Object o)
	{
		if(this == o)
		{
			return true;
		}
		if(o == null || this.getClass() != o.getClass())
		{
			return false;
		}
		Boat other = (Boat) o;
		return boatLength == other.boatLength && powerSource == other.powerSource;		
	}
}
