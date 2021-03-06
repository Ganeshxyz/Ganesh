/**
 * Purpose Creating calendar using 2D array
 * @author Ganesh
 *@since 4 March 2018
 */
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class Calendar 
{
	public static void main(String[] args) 
	{
		int month=Integer.parseInt(args[0]);
		int year=Integer.parseInt(args[1]);
		System.out.println("Year="+year+"  month="+month);
		String calender[][]=Utility.calender(year, month);
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<7;j++)
			{
				System.out.print(calender[i][j]+"  ");
			}
			System.out.println();
		}
	}
}