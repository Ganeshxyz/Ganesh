package com.bridgelabz.utility;

public interface Computer
{
	String getDetails();
}

class Pc implements Computer
{
	private String details;

	public Pc(String details)
	{
		this.details=details;
	}
	@Override
	public String getDetails() 
	{
		return details;
	}
	@Override
	public String toString() 
	{
		return "This is object of Pc";
	}
}

class Server implements Computer
{
	private String details;
	
	public Server(String details)
	{
		this.details=details;
	}
	@Override
	public String getDetails() 
	{
		return details;
	}
	@Override
	public String toString() 
	{
		return "This is object of Server";
	}
}

class Laptop implements Computer
{
	private String details;

	public Laptop(String details)
	{
		this.details=details;
	}
	@Override
	public String getDetails() 
	{
		return details;
	}
	@Override
	public String toString() 
	{
		return "This is object of Laptop";
	}
}