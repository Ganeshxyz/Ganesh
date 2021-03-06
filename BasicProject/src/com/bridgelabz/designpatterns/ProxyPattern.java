package com.bridgelabz.designpatterns;

import com.bridgelabz.utility.CommandExecutorProxy;

public class ProxyPattern 
{
	public static void main(String[] args)
	{
		CommandExecutorProxy executor = new CommandExecutorProxy("Ganesh", "itspassword");
		try 
		{
			executor.runCommand("ls -ltr");
			executor.runCommand(" rm -rf abc.pdf");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
	}
}