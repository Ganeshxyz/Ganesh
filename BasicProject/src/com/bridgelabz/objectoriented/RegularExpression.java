package com.bridgelabz.objectoriented;

import com.bridgelabz.utility.Utility;

public class RegularExpression 
{
	public static void main(String[] args) 
	{
		String string="Hello <<name>>,We have your full name as <<full name>> in our system."+
					  " your contact number is 91­xxxxxxxxxx."+ 
					  "Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016.";
		Utility utility=new Utility();
		System.out.println(string);
		string=Utility.regularExpression(string);
		System.out.println(string);
	}
}