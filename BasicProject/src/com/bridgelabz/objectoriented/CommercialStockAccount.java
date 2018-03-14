package com.bridgelabz.objectoriented;

import com.bridgelabz.utility.Customer;
import com.bridgelabz.utility.StockAccount;
import com.bridgelabz.utility.Utility;

public class CommercialStockAccount 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		Customer customer=null;
		StockAccount account=null;
		StockAccount stockAccount=new StockAccount();
		String name=null,symbol=null;;
		long money=0,noOfShares=0;
		long total_share=0;
		int choice=0;
		do
		{
			System.out.println("1. Create Account");
			System.out.println("2. Buy Shares");
			System.out.println("3. Sell Shares");
			System.out.println("4. Display Report");
			System.out.println("5. Exit");
			System.out.println("Enter your choice=");
			choice=utility.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter your Name=");
				name=utility.next();
				System.out.println("Enter Initial Money=");
				money=utility.nextLong();
				customer=new Customer(name, money, total_share);
				account=new StockAccount(customer);
				break;
			case 2:
				System.out.println("Enter your Name=");
				name=utility.next();
				System.out.println("Enter the Symbol of company to buy Shares=");
				symbol=utility.next();
				System.out.println("Enter no of Shares=");
				noOfShares=utility.nextLong();
				stockAccount.buy(symbol, noOfShares, name);
				break;
			case 3:
				System.out.println("Enter your Name=");
				name=utility.next();
				System.out.println("Enter the Symbol of company to buy Shares=");
				symbol=utility.next();
				System.out.println("Enter no of Shares=");
				noOfShares=utility.nextLong();
				stockAccount.sell(symbol, noOfShares, name);
				break;
			case 4:
				break;
			}
		}
		while(choice!=5);
	}
}