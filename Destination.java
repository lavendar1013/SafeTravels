import java.io.*;
import java.util.*;
public class Destination {

	private String travelType;
	private String originAirport;
	private String destinationAirport;

	private double score;
	private int lgbtqScore;
	private String[] travelAlerts=new String[3];
	
	public Destination(String travelType, String originAirport, String destinationAirport, double score)
	{
		this.travelType=travelType;
		this.originAirport=originAirport;
		this.destinationAirport=destinationAirport;
		this.score=score;
		
		
	}
	
	public String getTravelType()
	{
		return travelType;
	}
	public String getOriginAirport()
	{
		return originAirport;
	}
	public String getDestinationAirport()
	{
		return destinationAirport;
	}
	public double getScore()
	{
		return score;
	}
	
	public void setTravelAlerts()
	{
		try
		{
			File f=new File("travelAlerts.txt");
			Scanner s= new Scanner(f);
			while(s.hasNextLine())
			{
				
				String[] lines=s.nextLine().split("/");
				String location=getLocation(destinationAirport);
				if (lines[0].equals(location))
				{
					travelAlerts[0]=lines[0];
					travelAlerts[1]=lines[1];
					travelAlerts[2]=lines[2];
				}
				
			}
		}
		catch(IOException ioe)
		{
			
		}
	}
	
	private String getLocation(String s)
	{
		String result;
		
		switch(s)
		{
		case "ALB" : 
		case "ABQ" :
		case "ANC" : 
		case "ATL" :
		case "AUS" :
		case "BWI" :
		case "BOS" :
		case "BUF" :
		case "BUR" :
		case "BTV" :
		case "CHS" :
		case "CLT" :
		case "ORD" :
		case "CLE" :
		case "DFW" :
		case "DAB" :
		case "DEN" :
		case "DTW" :
		case "FLL" :
		case "RSW" :
		case "BDL" :
		case "HOU" :
		case "HYA" :
		case "JAX" :
		case "LAS" :
		case "LAX" :
		case "LGB" :
		case "MVY" :
		case "MSP" :
		case "ACK" :
		case "BNA" :
		case "MSY" :
		case "JFK" :
		case "LGA" :
		case "EWR" :
		case "SWF" :
		case "OAK" :
		case "MCO" :
		case "PSP" :
		case "PHL" :
		case "PHX" :
		case "PIT" :
		case "PDX" :
		case "PWM" :
		case "PVD" :
		case "RDU" :
		case "RNO" :
		case "RIC" :
		case "ROC" :
		case "SMF" :
		case "SLC" :
		case "SAN" :
		case "SFO" :
		case "SJC" :
		case "SRQ" :
		case "SAV" :
		case "SEA" :
		case "SYR" :
		case "TPA" :
		case "DCA" :
		case "IAD" :
		case "PBI" :
		case "HPN" :
		case "STX" :
		case "ORH" :result="USA"; break;
		case "BQN" :result="Puerto Rico";break;
		case "ANU" :result="Antigua and Barbuda"; break;
		case "AUA" :result="Aruba";break;
		case "BDA" :result="Bermuda";break;
		case "BGI" :result="Barbados";break;
		case "CMW" :result="Cuba";break;
		case "CUR" :result="Curacao";break;
		case "GCM" :result="British Virgin Islands";break;
		case "GND" :result="Grenada";break;
		case "HAV" :result="Cuba";break;
		case "HOG" :result="Cuba";break;
		case "KIN" :result="Jamaica";break;
		case "LRM" :result="Domincan Republic";break;
		case "MBJ" :result="Jamaica";break;
		case "NAS" :result="Bahamas";break;
		case "PSE" :result="Puerto Rico";break;
		case "PAP" :result="Haiti";break;
		case "POS" :result="Trinidad & Tobago";break;
		case "PLS" :result="Turks & Caicos Islands";break;
		case "POP" :result="Dominican Republic";break;
		case "PUJ" :result="Dominican Republic";break;
		case "UVF" :result="St. Lucia";break;
		case "SXM" :result="St. Maarten";break;
		case "STT" :result="Virgin Islands(USA)";break;
		case "SJU" :result="Puerto Rico";break;
		case "SNU" :result="Cuba";break;
		case "STI" :result="Dominican Republic";break;
		case "SDQ" :result="Dominican Republic";break;
		case "BOG" :result="Colombia";break;
		case "CTG" :result="Colombia";break;
		case "LIM" :result="Peru";break;
		case "MDE" :result="Colombia";break;
		case "UIO" :result="Ecuador";break;
		case "CUN" :result="Mexico";break;
		case "LIR" :result="Costa Rica";break;
		case "MEX" :result="Mexico";break;
		case "SJO" :result="Costa Rica";break;
		default: result=null;
		}
		return result;
	}
	public void setlgbtqScore()
	{
		try
		{
			File f=new File("lgbtqScores.txt");
			Scanner s= new Scanner(f);
			while(s.hasNextLine())
			{
				String line=s.nextLine();
				String[] lines=line.split("!");
				
				String location=getLocation(destinationAirport);
				if (lines[1].equals(location))
				{
					lgbtqScore= Integer.parseInt(lines[2]);
				}
				
			}
		}
		catch(IOException ioe)
		{
			System.out.print("FAIL");
		}
		
	}
	public void printStatement()
	{
		setTravelAlerts();
		setlgbtqScore();
		System.out.println("Origin Airport: "+originAirport);
		System.out.println("Destination Airport: " + destinationAirport);

		System.out.println("Deal Score: " +score);
		System.out.println("LGBTQ Score: " + lgbtqScore);
		System.out.println("Travel Alerts: " + travelAlerts[1]);
		System.out.println("Vaccinations: " + travelAlerts[2]);
	}
	
}
