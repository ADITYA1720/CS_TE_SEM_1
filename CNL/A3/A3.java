import java.io.*;
import java.util.*;
public class A3{

	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	double range=0.0;	
	System.out.println("Enter the IP address");
	String ip = sc.nextLine();
	
	System.out.println("Enter no of bits");
	int no_bits = sc.nextInt();
	
	//Calculating Network Mask
	System.out.println("Enter number of subnets");
	int subnets = sc.nextInt();
	
	int bits = (int)Math.ceil(Math.log(subnets)/Math.log(2));;
	System.out.println("Address bits are : " + bits);

	
	int net_mask[] = new int[32];
	int subnet_mask[] = new int[32];
	for(int i=0; i< 32; i++ )
	{
		if(i < no_bits)
			net_mask[i] = 1;
		else
			net_mask[i] = 0;
		if(i < no_bits + bits)
			subnet_mask[i] = 1;
		else
			subnet_mask[i] = 0;
	}
	//Calculating Network Mask
	System.out.println("Network Mask is :" );
	for(int i=0; i<32 ; i++)
	{
	System.out.print(net_mask[i]);
	if(i % 8 ==7)
	System.out.print(".");
	}
	System.out.println(" " );
	
	//Calculating SubNet Mask
	System.out.println("SubNet Mask is :" );
	for(int i=0; i<32 ; i++)
	{
	System.out.print(subnet_mask[i]);
	if(i % 8 ==7)
	System.out.print(".");
	}
		
	int mask = 32 - (no_bits + bits);
	int hosts = (int)(Math.pow(2,mask));
	System.out.println(" ");
	System.out.println("No of hosts are : " + hosts);
	range = ((double)hosts/10);
	
	
	String[] str = ip.split("\\.");
	int k =Integer.valueOf(str[2]);
	
	double z = (double)k;
	
	double ping_range[] = new double[subnets+1];
	ping_range[0] = z; 
	System.out.println("The following are the hosts " );
	for(int i=0;i<subnets; i++)
		{
		double a= z+range;
		ping_range[i+1] = a;
		System.out.println( z + " - " + a);
		z = z+range;
		}
	
	System.out.println("Enter Sender id");
	double sender_id = sc.nextFloat();
	System.out.println("Enter Receiver id");
	double receiver_id = sc.nextFloat();
	int flag=0;
	
	for(int i=0; i<subnets ; i++)
	{
	if(sender_id > ping_range[i] && sender_id < ping_range[i+1] && receiver_id > ping_range[i] && receiver_id < ping_range[i+1])
	{
	flag = 1;
	System.out.println("Systems will ping");
	break;
	}
	}
	if(flag == 0)
	System.out.println("Systems will not ping");
	}
}
