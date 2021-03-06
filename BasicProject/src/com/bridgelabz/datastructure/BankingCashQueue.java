/**
 * Purpose maintaining cash in bank while people deposit and withdraw
 * @author Ganesh
 *@since 3 March 2018
 */
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Queue;
import com.bridgelabz.utility.Utility;

public class BankingCashQueue 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter the size of Queue=");
		int size=utility.nextInt();
		int person=1,choice=0;
		long amount =100000000;
		long inputamount=0;
		Queue<Integer> queue=new Queue<Integer>(size);
		for(int i=1;i<=size;i++)
		{
			queue.enQueue(i);
		}
		do
		{
			size--;
			System.out.println("Person="+person);
			System.out.println("Amount="+amount);
			System.out.println("1: Deposit");
			System.out.println("2: withdraw");
			System.out.println("Enter your choice=");
			choice=utility.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter Amount=");
				inputamount=utility.nextLong();
				amount=amount+inputamount;
				System.out.println("Bye person "+person);
				queue.deQueue();
				person++;
				break;
			case 2:
				System.out.println("Enter Amount=");
				inputamount=utility.nextLong();
				if(amount>inputamount)
				{
					amount=amount-inputamount;
					System.out.println("Bye person "+person);
					queue.deQueue();
				}
				else
				{
					System.out.println("Not enough money come back tommorow.");
					queue.deQueue();
				}
				person++;
				break;
			default:
				System.out.println("Person="+person);
				System.out.println("Amount="+amount);
				System.out.println("1: Deposit");
				System.out.println("2: withdraw");
				System.out.println("Enter your choice=");
				choice=utility.nextInt();
			}
		}
		while(size!=0);
		System.out.println("Queue is Empty.");
		System.out.println("Amount="+amount);
	}
}