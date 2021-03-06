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
		boolean flag=false;
		int bigN=0;
		do
		{
			System.out.println("Enter number such that N=2^n=");
			bigN=utility.nextInt();
			for(int i=0;i<bigN;i++)
			{
				if(Math.pow(2, i)==bigN)
				{
					flag=true;
					break;
				}
			}
		}
		while(flag==false);
		int multiply=2;
		int i;
		if(bigN==1)
		{
			i=0;
		}
		else
		{
			for(i=1;i<bigN;i++)
			{
				if(multiply==bigN)
				{
					break;
				}
				multiply=multiply*2;
			}
		}
		int smalln=i;
		System.out.println("My number between 0 and "+bigN+"=");
		int mynumber=utility.nextInt();
		Utility.guessNumber(bigN, smalln, mynumber);
	}
}