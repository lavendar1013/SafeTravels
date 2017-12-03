import java.util.*;
import java.io.*;
public class DestinationsProcessor {

	public static ArrayList<String> getAirport(String s)
	{
			ArrayList<String> results=new ArrayList<String>();
			switch(s)
			{
		
			case "Puerto Rico" :results.add("BQN");results.add("PSE");results.add("SJU");break;
			case "Antigua and Barbuda" :results.add("ANU");break;
			case "Aruba" : results.add("AUA");break;
			case "Bermuda" : results.add("BDA");break;
			case "Barbados" : results.add("BGI");break;
			case "Cuba" : results.add("CMW");results.add("SNU");results.add("HAV");results.add("HOG");break;
			case "Curaco" : results.add("CUR");break;
			case "British Virgin Islands" :results.add("GCM");break;
			case "Grenada" :results.add("GND");break;
			case "Jamaica" :results.add("KIN");results.add("MBJ");break;
			case "Dominican Republic" :results.add("LRM");results.add("POP");results.add("PUJ");results.add("STI");results.add("SDQ");break;
			case "Bahamas" : results.add("NAS");break;
			case "Haiti" : results.add("PAP");break;
			case "Trinidad & Tobago" :results.add("POS");break;
			case "Turks & Caicos Islands" :results.add("PLS");break;
			case "St. Lucia" :results.add("UVF");break;
			case "St. Maarten" :results.add("SXM");break;
			case "Virgin Islands(USA)" :results.add("STT");break;
			case "Colombia": results.add("BOG");results.add("CTG");results.add("MDE");break;
			case "Peru" : results.add("LIM");break;
			case "Ecuador" :results.add("UIO");break;
			case "Mexico" :results.add("CUN");results.add("MEX");break;
			case "Costa Rica" :results.add("LIR");results.add("SJO");break;
			default: ;
			}
			return results;
	}
	public static ArrayList<Destination> getTrips(String origin, String destination, DestinationList dL)
	{
		ArrayList<Destination> trips=new ArrayList<Destination>();
		for(int i=0;i<dL.size();i++)
		{
			if(dL.get(i).getOriginAirport().equals(origin)&&dL.get(i).getDestinationAirport().equals(destination))
			{
				trips.add(dL.get(i));
			}
			
		}
		return trips;
	}
	public static Destination findTrip(String origin, String destination, DestinationList dL)
	{
		for(int i=0;i<dL.size();i++)
		{
			if(dL.get(i).getOriginAirport().equals(origin)&&dL.get(i).getDestinationAirport().equals(destination))
			{
				return dL.get(i);
			}
			
		}
		return null;
	}
	public static Destination convertToDestination(String data)
	{
	
	String[] subs=data.split(",");	
	String origin=subs[1];
	String dest=subs[2];
	
	String travelType;
	if(subs[11].equals("0"))
			travelType="domestic";
	else
		 travelType="international";
	double score=Double.parseDouble(subs[6]);
	Destination one=new Destination(travelType,origin, dest, score);
	return one;
	}
	public static DestinationList loadDestinationData()
	{
		try {
			File f=new File("deals.csv");
			Scanner s=new Scanner(f);
			DestinationList destinations =new DestinationList();
			while(s.hasNextLine())
			{
				destinations.addDestination(convertToDestination(s.nextLine()));
			}
			return destinations;
		}
		catch(IOException ioe)
		{
			return null;
		}
	}
	public static void main(String[] args)
	{
		DestinationList finish=loadDestinationData();
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the airport that you plan to depart from ");
		String origin=input.nextLine();
		System.out.print("Enter the coutry you want to travel to ");
		String destination =input.nextLine();
		ArrayList<String> possibles=getAirport(destination);
		System.out.println("The higher the deal score, the better the deal.");
		System.out.println("These are the possibilities");
		System.out.println();
		for(int i=0;i<possibles.size();i++)
		{
			ArrayList<Destination> options=getTrips(origin, possibles.get(i),finish);
			for(int j=0;j<options.size();j++)
			{
			options.get(j).printStatement();
			System.out.println();
			}
		}
	}
}
