package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class BinarySearchTree 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter Number of Test cases=");
		int testcases=utility.nextInt();
		int test=0;	
		double no_of_tree;
		for(int i=0;i<testcases;i++)
		{
			System.out.print("Enter the case= ");
			test=utility.nextInt();
			no_of_tree=Utility.binarySearchTreeTestCase(test);
			System.out.println("No of binary search tree for given test case = "+no_of_tree);
		}
	}
}