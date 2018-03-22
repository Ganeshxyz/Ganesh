package com.bridgelabz.utility;

public class Volt 
{
	private int volt;

	public Volt(int volt) 
	{
		this.volt = volt;
	}

	public int getVolt() 
	{
		return volt;
	}

	public void setVolt(int volt) 
	{
		this.volt = volt;
	}
}

class Socket
{
	public Volt getVolt()
	{
		return new Volt(120);
	}
}