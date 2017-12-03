import java.util.*;
public class DestinationList {

	private ArrayList<Destination> destinations;
	
	public DestinationList()
	{
		destinations= new ArrayList<Destination>();
	}
	public void addDestination(Destination d)
	{
		destinations.add(d);
	}
	public void add(int index, Destination d)
	{
		if(index>0&&index<=destinations.size())
		{
			destinations.add(index, d);
		}
		else
			destinations.add(d);
	}
	public int size()
	{
		return destinations.size();
	}
	public Destination get(int index)
	{
		if(index<0|| index>destinations.size())
		{
			return null;
		}
		else
		return destinations.get(index);
	}
	public void printList(int i)
	{
		get(i).printStatement();
		System.out.println();
	}
	
}
