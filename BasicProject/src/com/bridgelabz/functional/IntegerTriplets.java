/*
 * purpose: Read in N integers and counts the number of triples that sum to exactly 0 
 * @author Ganesh
 * @since 28 Feb 2018
*/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class IntegerTriplets
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		int arraySize;
		System.out.println("Enter Size of array=");
		arraySize=utility.nextInt();
		int array[]=new int[arraySize];
		System.out.println("Enter "+arraySize+" numbers=");
		for(int i=0;i<arraySize;i++)
		{
			array[i]=utility.nextInt();
		}
		Utility.integerTriplet(array);
	}
}