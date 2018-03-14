package com.bridgelabz.utility;

import org.json.simple.JSONObject;

public class StockAccount 
{
	String customerPath="/home/bridgeit/Ganesh/BasicProject/Files/StockCustomer.json";
	String stockPath="/home/bridgeit/Ganesh/BasicProject/Files/StockAccount.json";
	public StockAccount()
	{
		
	}
	public StockAccount(Customer customer)
	{
		JSONObject name=new JSONObject();
		JSONObject jsonObject=Utility.readJsonFile(customerPath);
		if(jsonObject==null)
		{
			jsonObject=new JSONObject();
		}
		name.put("Money", customer.getMoney());
		name.put("TotalShare", customer.getTotal_share());
		jsonObject.put(customer.getName(), name);
		Utility.writeJsonFile(customerPath, jsonObject);
	}
	public void buy(String symbol,long no_of_shares,String name)
	{
		JSONObject jsonStock=Utility.readJsonFile(stockPath);
		JSONObject stockSymbol=(JSONObject)jsonStock.get(symbol);
		long price=(long)stockSymbol.get("Price");
		stockSymbol.put("NumberOfShare", (long)stockSymbol.get("NumberOfShare")-no_of_shares);
		jsonStock.put(symbol, stockSymbol);
		Utility.writeJsonFile(stockPath, jsonStock);
		boolean flag=false;
		JSONObject jsonObject=Utility.readJsonFile(customerPath);
		JSONObject customer=(JSONObject)jsonObject.get(name);
		JSONObject share_value=null;
		if(customer.get("Shares")==null)
		{
			share_value=new JSONObject();
			flag=true;
		}
		else
		{
			share_value=(JSONObject)customer.get("Shares");
			flag=false;
		}
		if(flag==true)
		{
			share_value.put(symbol, no_of_shares);
		}
		else
		{
			if(share_value.get(symbol)==null)
			{
				share_value.put(symbol, no_of_shares);
			}
			else
			{
				share_value.put(symbol, (long)share_value.get(symbol)+no_of_shares);
			}
		}
		customer.put("Money", (long)customer.get("Money")-(no_of_shares*price));
		customer.put("TotalShare", (long)customer.get("TotalShare")+no_of_shares);
		customer.put("Shares", share_value);
		jsonObject.put(name, customer);
		Utility.writeJsonFile(customerPath, jsonObject);
		
	}
	public void sell(String symbol,long no_of_shares,String name)
	{
		JSONObject customerJson=Utility.readJsonFile(customerPath);
		JSONObject stockJson=Utility.readJsonFile(stockPath);
		
		JSONObject symbolJson=(JSONObject)stockJson.get(symbol);
		long price=(long)symbolJson.get("Price");
		symbolJson.put("NumberOfShare", (long)symbolJson.get("NumberOfShare")+no_of_shares);
		stockJson.put(symbol, symbolJson);
		Utility.writeJsonFile(stockPath, stockJson);
		
		JSONObject nameJson=(JSONObject)customerJson.get(name);
		nameJson.put("Money", (long)nameJson.get("Money")+(price*no_of_shares));
		customerJson.put(name, nameJson);
		
		nameJson.put("TotalShare", (long)nameJson.get("TotalShare")-no_of_shares);
		customerJson.put(name, nameJson);
		
		JSONObject share=(JSONObject)nameJson.get("Shares");
		share.put(symbol, (long)share.get(symbol)-no_of_shares);
		
		nameJson.put("Shares", share);
		customerJson.put(name, nameJson);
		
		Utility.writeJsonFile(customerPath, customerJson);
		
	}
}