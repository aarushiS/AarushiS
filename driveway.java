package Stacks;
import java.util.Scanner;
import java.util.Stack;

public class Driveway 
{
	Stack<Integer> drive = new Stack<Integer>();
	Stack<Integer> drive2 = new Stack<Integer>();
	Stack<Integer> street = new Stack<Integer>();
	Stack<Integer> street2 = new Stack<Integer>();
	public Driveway()
	{
		
	}
	
	public void access(int x)
	{
		if(x>0)
		{
			drive.push(x);
			show();
		}
		else if(x<0)
		{
			remove(-x);
			show();
		}
		else if(x==0)
		{
			System.out.println("Simulation closed");
		}
	}
	
	public void remove(int x)
	{
		int c = drive.search(x);
		if(c==1)
		{
			drive.pop();
			if(drive2.size()!=0)
			drive2.pop();
		}
		else
		{
			for(int i = 1; i<= c;i++)
			{
				if(i==c)
				{
					drive.pop();
					if(drive2.size()!=0)
					drive2.pop();
				}
				else
				{
					street.push(drive.pop());
					if(street2.size()!=0)
					street2.push(drive2.pop());
					System.out.println("Moving cars to street to remove the selected car");
					show();
					System.out.println("moving finished");
					System.out.println();
				}
			}
		}
		
		while(street.size()>0)
		{
			drive.push(street.pop());
		}
		
		while(street2.size()>0)
		{
			drive2.push(street2.pop());
		}
		
	}
	
	public void show()
	{
		
		System.out.println("The cars in the drive are: ");
		copyD();
		System.out.println();
		System.out.println("The cars in the street are: ");
		copyS();
		System.out.println();
		
	}
	
	public void copyD()
	{
		while(drive.size()>0)
		{

			drive2.push(drive.pop());
		}
		while(drive2.size()>0)
		{
			System.out.println(drive2.peek());
			drive.push(drive2.pop());
		}
	}
	
	public void copyS()
	{
		while(street.size()>0)
		{

			street2.push(street.pop());
		}
		while(street2.size()>0)
		{
			System.out.println(street2.peek());
			street.push(street2.pop());
		}
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Driveway d = new Driveway();
		int x = 1;
		while(x!=0)
		{
		
			System.out.println("Enter the car you want to add or remove: ");
			x = sc.nextInt();
		
		
			d.access(x);
		}

	}

}

