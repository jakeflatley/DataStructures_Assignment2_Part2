package edu.monmouth.vehicle;

public class Car implements Vehicle
{
	private int engineSize;
	private PowerTypes powerSource;
	
	public Car(PowerTypes p, int es) throws CarException
	{
		setEngineSize(es);
		setPowerSource(p);
	}
	
	public int getEngineSize()
	{
		return engineSize;
	}
	public void setEngineSize(int es) throws CarException
	{
		if(es < VehicleConstants.MINENGINESIZE || es > VehicleConstants.MAXENGINESIZE)
		{
			throw new CarException("Invalid car length " + es + ": Must be between " + VehicleConstants.MINENGINESIZE + " - " + VehicleConstants.MAXENGINESIZE);

		}
		engineSize = es;
	}
	public void setPowerSource(PowerTypes p)
	{
		powerSource = p;
	}
	public PowerTypes getPowerSource()
	{
		return powerSource;
	}
	@Override
	public void go()
	{
		System.out.println("The car is going");
	}
	@Override
	public void stop()
	{
		System.out.println("The car is stopping");
	}
	@Override
	public PowerTypes powerBy()
	{
		return powerSource;
	}
	@Override
	public String toString()
	{
		return "Car | Engine Size: " + engineSize + " | Power Source: " + powerSource;
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
		Car other = (Car) o;
		return engineSize == other.engineSize && powerSource == other.powerSource;		
	}
}
