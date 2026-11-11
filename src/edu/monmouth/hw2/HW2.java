package edu.monmouth.hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import edu.monmouth.vehicle.*;

public class HW2 
{
	public static void main(String[] args)
	{
		if(args.length != HW2Constants.ARGS) 
		{
			System.err.println("Give the names of an output file, a string file and a vehicle file");
			System.exit(HW2Constants.BADARGS);
		}
		
		initialize(args[HW2Constants.OUTPUTINDEX]);
		
		List<String> sList = new ArrayList<String>();
		makeString(args[HW2Constants.STRINGINDEX], sList);
		
		List<Vehicle> vList = new ArrayList<Vehicle>();
		makeVehicle(args[HW2Constants.VEHICLEINDEX], vList);
		
		testStringList(sList);
		testVehicleList(vList);
	}
	private static void initialize(String fileName)
	{
		try 
		{
			PrintStream redirectStream = new PrintStream(fileName);
			System.setOut(redirectStream);
			System.setErr(redirectStream);
		} 
		catch(FileNotFoundException ioe) 
		{
			System.err.println("Cannot redirect stderr and stdout " + ioe.getMessage());
			ioe.printStackTrace();
			System.exit(HW2Constants.BADREDIRECT);
		}
	}
	private static void makeString(String fileName, List<String> sList)
	{
		try 
		{
			Scanner scanner = new Scanner(new File(fileName));
			while(scanner.hasNextLine()) 
			{
				String line = scanner.nextLine();
				sList.add(line);
			}
			scanner.close();
		} 
		catch(FileNotFoundException fnfe) 
		{
			System.err.println("Cannot open " + fileName + " " + fnfe.getMessage());
			System.exit(HW2Constants.BADFILE);
		}
	}
	private static void makeVehicle(String fileName, List<Vehicle> vList)
	{
		try 
		{
			Scanner scanner = new Scanner(new File(fileName));
			while(scanner.hasNextLine()) 
			{
				String line = scanner.nextLine();
				String[] fields = line.split(HW2Constants.SEPARATOR, -1);
				if(fields.length != HW2Constants.VEHICLEFIELDS) 
				{
					System.err.println("Wrong number of fields, line discarded: " + line);
				} 
				else 
				{
					try 
					{
						String type = fields[HW2Constants.TYPEFIELD];
						PowerTypes power = PowerTypes.valueOf(fields[HW2Constants.POWERFIELD]);
						int size = Integer.parseInt(fields[HW2Constants.SIZEFIELD]);
					 
						if(type.equalsIgnoreCase(HW2Constants.BOAT)) 
						{
							vList.add(new Boat(power, size));
						} 
						else if(type.equalsIgnoreCase(HW2Constants.CAR)) 
						{
							vList.add(new Car(power, size));
						} 
						else if(type.equalsIgnoreCase(HW2Constants.PLANE)) 
						{
							vList.add(new Plane(power, size));
						} 
						else 
						{
							throw new IllegalArgumentException("Unknown vehicle type " + type);
						}
					}
					catch(BoatException be) 
					{
						System.err.println(be.getMessage() + ", line discarded: " + line);
					} 
					catch(CarException ce) 
					{
						System.err.println(ce.getMessage() + ", line discarded: " + line);
					} 
					catch(IllegalArgumentException iae) 
					{
						System.err.println(iae.getMessage() + ", line discarded: " + line);
					}
				} 
			}
			scanner.close();
		} 
		catch(FileNotFoundException fnfe) 
		{
			System.err.println("Cannot open " + fileName + " " + fnfe.getMessage());
			System.exit(HW2Constants.BADFILE);
		}
	}
	private static void testStringList(List<String> stringList) 
	{
		System.out.println("--- String list ---");
		
		System.out.println("isEmpty: " + stringList.isEmpty());
		
		if(!stringList.isEmpty()) 
		{
			String removed = stringList.remove(0);
			System.out.println("Removed index 0: " + removed);
		}
		
		System.out.println("List after remove:");
		printStrings(stringList);
		
		stringList.add("Willow Hall");
		System.out.println("Added a String");
		
		System.out.println("Iterating through the list:");
		printStrings(stringList);
		
		System.out.println("--- String list Part 2---");
		System.out.println("Number of elements: " + stringList.size());
		
		System.out.println("Iterating through the list:");
		printStrings(stringList);
		
		System.out.println("Iterating through the list backwards:");
		ListIterator<String> iterator = stringList.listIterator(stringList.size());
		while(iterator.hasPrevious()) 
		{
			System.out.println(iterator.previous());
		}
		System.out.println();
	}
	private static void testVehicleList(List<Vehicle> vehicleList) 
	{
		System.out.println("--- Vehicle list ---");

		Vehicle addedCar=null, sameCar=null, otherBoat=null;
		try 
		{
			addedCar = new Car(PowerTypes.GASOLINE, 10);
			sameCar = new Car(PowerTypes.GASOLINE, 10);
			otherBoat = new Boat(PowerTypes.ELECTRICITY, 123);
		} 
		catch(CarException ce) 
		{
			System.out.println(ce.getMessage());
			ce.printStackTrace();
		} 
		catch(BoatException be) 
		{
			System.out.println(be.getMessage());
			be.printStackTrace();
		}

		System.out.println("isEmpty: " + vehicleList.isEmpty());

		if(!vehicleList.isEmpty()) 
		{
			Vehicle removed = vehicleList.remove(0);
			System.out.println("Removed index 0: " + removed);
		}
		System.out.println("List after remove:");
		printVehicles(vehicleList);

		vehicleList.add(addedCar);
		System.out.println("Added: " + addedCar);

		System.out.println("Iterating through the list:");
		printVehicles(vehicleList);

		System.out.println("List contains " + sameCar + ": " + vehicleList.contains(sameCar));
		System.out.println("List contains " + otherBoat + ": " + vehicleList.contains(otherBoat));
		
		System.out.println("\n--- Vehicle list Part 2---");
		System.out.println("Number of elements: " + vehicleList.size());
		
		System.out.println("Iterating through the list:");
		printVehicles(vehicleList);
		
		System.out.println("Iterating through the list backwards:");
		ListIterator<Vehicle> iterator = vehicleList.listIterator(vehicleList.size());
		while(iterator.hasPrevious()) 
		{
			System.out.println(iterator.previous());
		}
		System.out.println();
		
		try
		{
			Vehicle v = new Boat(PowerTypes.ELECTRICITY ,300); 
			vehicleList.remove(v);
			System.out.println("Iterating through the list after remove:");
			printVehicles(vehicleList);
		} 
		catch (BoatException be)
		{
			System.err.println(be.getMessage());
		}
	}
	private static void printStrings(List<String> stringList) 
	{
		ListIterator<String> iterator = stringList.listIterator();
		while(iterator.hasNext()) 
		{
			System.out.println(iterator.next());
		}
		System.out.println();
	}
	private static void printVehicles(List<Vehicle> vehicleList) 
	{
		ListIterator<Vehicle> iterator = vehicleList.listIterator();
		while(iterator.hasNext()) 
		{
			System.out.println(iterator.next());
		}
		System.out.println();
	}
}