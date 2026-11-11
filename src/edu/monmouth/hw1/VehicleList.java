package edu.monmouth.hw1;
import edu.monmouth.vehicle.Vehicle;

public class VehicleList 
{
	private VehicleNode head;
	
	public VehicleList()
	{
		setHead(null);
	}

	public VehicleNode getHead() 
	{
		return head;
	}
	public void setHead(VehicleNode h) 
	{
		head = h;
	}
	public VehicleNode insert(Vehicle v)
	{
		VehicleNode node = new VehicleNode(v);
		node.setNext(head);
		head = node;
		return node;
	}
	public VehicleNode insertEnd(Vehicle v)
	{
	    VehicleNode node = new VehicleNode(v);
	    if(head == null)
	    {
	        head = node;
	        return node;
	    }
	    VehicleNode temp = head;
	    while(temp.getNext() != null)
	    {
	        temp = temp.getNext();
	    }
	    temp.setNext(node);
	    return node;
	}
	public VehicleNode first()
	{
		return head;
	}
	public VehicleNode last()
	{
		VehicleNode last = head;
		if(last == null)
		{
			return null;
		}
		while(last.getNext() != null)
		{
			last = last.getNext();
		}
		return last;
	}
	public VehicleNode removeFirst()
	{
		if(head == null)
		{
			return null;
		}
		VehicleNode node = head;
		head = head.getNext();
		return node;
	}
	public boolean isEmpty()
	{
		if(head == null)
		{
			return true;
		}
		return false;
	}
	public int size()
	{
		int size = 0;
		VehicleNode node = head;
		while(node != null)
		{
			size++;
			node = node.getNext();
		}
		return size;
	}
	@Override
	public String toString()
	{
		if(isEmpty())
		{
			return "Vehicle List is empty";
		}
		StringBuilder s = new StringBuilder();
		s.append("Vehicle List: \n");
		VehicleNode node = head;
		while(node != null)
		{
			s.append(node + "\n");
			node = node.getNext();
		}
		return s.toString();
	}	
}
