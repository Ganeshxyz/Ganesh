/*
 * purpose: Finding Prime factors of given positive number
 * @author Ganesh
 * @since 28 Feb 2018
*/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class PrimeFactors
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		int number;
		do
		{
			System.out.println("Enter Positive Number=");
			number=utility.nextInt();
		}
		while(number<=0);
		Utility.primeFactors(number);		
	}
}