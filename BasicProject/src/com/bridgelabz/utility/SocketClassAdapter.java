package com.bridgelabz.utility;

public class SocketClassAdapter extends Socket implements SocketAdapter
{
	@Override
	public Volt get120Volt() 
	{
		return getVolt();
	}

	@Override
	public Volt get3Volt() 
	{
		Volt volt=getVolt();
		return convertVolt(volt,40);
	}
	
	private Volt convertVolt(Volt volt,int number)
	{
		return new Volt(volt.getVolt()/number);
	}
}
