/*
 * purpose: Finding roots of given equation
 * @author Ganesh
 * @since 28 Feb 2018
*/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class Quadratic
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter three numbers to find roots");
		double a=utility.nextDouble();
		double b=utility.nextDouble();
		double c=utility.nextDouble();
		double rootarray[]=Utility.quadratic(a, b, c);
		if(rootarray==null)
		{
			System.out.println("Imaginary Number");
		}
		else
		{
			for(int i=0;i<rootarray.length;i++)
			{
				System.out.println("Root"+i+" of x is "+rootarray[i]);
			}
		}
	}
}