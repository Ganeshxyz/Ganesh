/*
 * purpose: Using Merge Sort on Strings
 * @author Ganesh
 * @since 1 March 2018
*/
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class MergeSortString
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter the size of Array=");
		int size=utility.nextInt();
		System.out.println("Enter String in Array=");
		String array[]=new String[size];
		for(int i=0;i<size;i++)
		{
			array[i]=utility.next();
		}
		int low=0,high=size-1;
		array=Utility.mergeSortString(array, low, high);
		for(int i=0;i<size;i++)
		{
			System.out.print(array[i]+"  ");
		}
	}
}