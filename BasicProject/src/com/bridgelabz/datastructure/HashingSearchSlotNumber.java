/**
 * Purpose Searching number from array of linked list using hashing mechanism
 * @author Ganesh
 * @since 5 March 2018
 */
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.LinkedList;
import com.bridgelabz.utility.Utility;

public class HashingSearchSlotNumber 
{
	public static void main(String[] args) 
	{
		String path="/home/bridgeit/Ganesh/BasicProject/Files/HashingFunction";
		String [] stringarray=Utility.getFileContents(path);
		LinkedList<Integer> listarray[]=Utility.hashingSearchSlotNumber(stringarray);	
		int temp;
		String tostring="";
		LinkedList<Integer> list=new LinkedList<>();
		for(int i=0;i<11;i++)
		{
			for(int j=0;j<11;j++)
			{
				if(listarray[i].getFirstItem()!=null)
				{
					temp=listarray[i].getFirstItem();
					list.add(temp);
					listarray[i].remove(temp);
				}
			}
		}
		list.order();
		for(int i=0;i<11;i++)
		{
			tostring=list.toString();
		}
		byte bytearray[]=tostring.getBytes();
		Utility.bytesToFile(bytearray, path);
		stringarray=Utility.getFileContents(path);
		for(int i=0;i<stringarray.length;i++)
		{
			System.out.println(stringarray[i]);
		}
	}
}