/*
 * purpose: Gambler game. Bet and see how many times u lose or win
 * @author Ganesh
 * @since 28 Feb 2018
*/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class Gambler
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter your stakes=");
		int stake=utility.nextInt();
		System.out.println("Enter the goal=");
		int goal=utility.nextInt();
		System.out.println("Enter how many times=");
		int times=utility.nextInt();
		Utility.gambler(stake, goal, times);
	}
}