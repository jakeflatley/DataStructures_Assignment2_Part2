package edu.monmouth.vehicle;

public class Plane implements Vehicle
{
	private int numSeats;
	private PowerTypes powerSource;
	
	public Plane(PowerTypes p, int ns)
	{
		setNumSeats(ns);
		setPowerSource(p);
	}
	
	public int getNumSeats()
	{
		return numSeats;
	}
	public void setNumSeats(int es)
	{
		numSeats = es;
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
		System.out.println("The plane is going");
	}
	@Override
	public void stop()
	{
		System.out.println("The plane is stopping");
	}
	@Override
	public PowerTypes powerBy()
	{
		return powerSource;
	}
	@Override
	public String toString()
	{
		return "Plane | Number of Seats: " + numSeats + " | Power Source: " + powerSource;
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
		Plane other = (Plane) o;
		return numSeats == other.numSeats && powerSource == other.powerSource;		
	}
}
