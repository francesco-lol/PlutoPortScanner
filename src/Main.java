import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import java.net.UnknownHostException; //for hostname/ip validation
import java.net.*;

public class Main 
{
	static final int N_WELL_KNOWN_PORTS = 1023; 

	public static void main(String[] args) 
	{
		if(areYouConnected() != true) //check if you are connected to the internet
		{
			System.out.println("ERROR: YOU ARE NOT CONNECTED TO THE INTERNET, PLEAS CONNECT AND TRY AGAIN!");
			System.exit(-1); //-1 = not connected to internet
		}
		
		InetAddress host = inputValidHost(); //input ip or hostname
				
		for(int i = 0;i < N_WELL_KNOWN_PORTS;i++) //cycle that prints the known open doors
		{
			if(isPortOpen(host,i))
			{
				System.out.println(i+" open");
			} 
		}
	}   
	
	public static Object keyboardIN() //input method
	{
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader keyboard = new BufferedReader(input);
		
		do
		{
			try
			{
				return keyboard.readLine();
			} 
			
			catch(IOException e)
			{
				System.out.println("ERROR: INPUT NOT VALID, REPEAT INPUT!");
			}
		}while(true); 
	}
	
	public static InetAddress inputValidHost() //method for inputting ip or hostname with validity check
	{
		do
		{
			try
			{
				System.out.print("enter ip or hostname:");
				String hostNotValidated = (String) keyboardIN();
				
				InetAddress host = InetAddress.getByName(hostNotValidated); //check if ip/hostname is valid
				
				return host;
			}
			
			catch(UnknownHostException e)
			{
				System.out.println("ERROR: ip or hostname is not valid!, repeat");
			}
		}while(true);
	}
	
	public static boolean isPortOpen(InetAddress host,int port) //method that returns true if the door is open
	{
		try
		{
			Socket socket = new Socket();
			socket.connect(new InetSocketAddress(host,port), 300); //Try connecting to the server with a 300ms timeout.
			socket.close();
			return true; //port is open
		}
		
		catch(Exception e)
		{
			return false; //port is close
		}
	}
	
	public static boolean areYouConnected() //method that checks if you are connected to quad9
	{
		try
		{
			Socket socket = new Socket("9.9.9.9", 53);
			socket.close();
			return true; //connected
		}
		
		catch(Exception e)
		{
			return false; //not connected
		}
	}
}
