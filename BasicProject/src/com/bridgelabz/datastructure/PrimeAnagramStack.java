/**
 * Purpose finding numbers that are prime and anagram using Stack
 * @author Ganesh
 * @since 10 March 2018
 */
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Stack;
import com.bridgelabz.utility.Utility;

public class PrimeAnagramStack 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter the range=");
		int range=utility.nextInt();
		Stack<Integer> stack=new Stack<Integer>(range);
		for(int i=0;i<range-1;i++)
		{
			for(int j=i+1;j<range;j++)
			{
				if(i!=j)
				{
					if(Utility.primeNumber(i) && Utility.primeNumber(j))
					{
						if(Utility.findingAnagram(""+i,""+j))
						{
							stack.push(i);
							stack.push(j);
						}
					}
				}
			}
		}
		stack.order();
		stack.reverseStack();
		System.out.println(stack.toString());
	}
}