/*
 * purpose: Computer will guess the number from ana array
 * @author Ganesh
 * @since 1 March 2018
*/
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class GuessNumber
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter number such that N=2^n=");
		int bign=utility.nextInt();
		int mul=2;
		int i;
		if(bign==1)
		{
			i=0;
		}
		else
		{
			for(i=1;i<bign;i++)
			{
				if(mul==bign)
				{
					break;
				}
				mul=mul*2;
			}
		}
		int smalln=i;
		System.out.println("My number=");
		int mynumber=utility.nextInt();
		Utility.guessNumber(bign, smalln, mynumber);
	}
}