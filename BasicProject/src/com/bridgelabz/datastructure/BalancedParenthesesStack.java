/**
 * Purpose Finding if the expression is balanced using Stack
 * @author Ganesh
 * @since 3 March 2018
 */
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Stack;
import com.bridgelabz.utility.Utility;

public class BalancedParenthesesStack
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter the arithematic expression=");
		String expression=utility.next();
		Stack<String> stack=new Stack<String>(expression.length());
		char chararray[]=expression.toCharArray();
		for(int i=0;i<chararray.length;i++)
		{
			if(chararray[i]=='(')
			{
				stack.push("(");
			}
			else if(chararray[i]==')')
			{
				stack.pop();
			}
		}
		boolean flag=stack.isEmpty();
		if(flag==true)
		{
			System.out.println("Arithematic Expression is Balanced.");
		}
		else
		{
			System.out.println("Arithematic Expression is not Balanced.");
		}
	}
}