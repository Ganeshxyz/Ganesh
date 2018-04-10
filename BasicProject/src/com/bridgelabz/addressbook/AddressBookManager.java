package com.bridgelabz.addressbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.bridgelabz.utility.Utility;

public class AddressBookManager 
{
	List<Person> personList;
	Utility utility=new Utility();
	Iterator<Person> iterator=null;
	AddressBook addressBook;
	ObjectMapper objectMapper=new ObjectMapper();
	File file;
	
	void saveAddressBook(AddressBook addressBook,String filePath)
	{
		file=new File(filePath);
		try
		{
			objectMapper.writeValue(file, addressBook.getPersonList());
		}
		catch(JsonMappingException e)
		{
			e.printStackTrace();
		} 
		catch (JsonGenerationException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	AddressBook openAddressBook(String filePath)
	{
		file=new File(filePath);
		try 
		{
			personList=new ArrayList<Person>(Arrays.asList(objectMapper.readValue(file, Person[].class)));
			addressBook=new AddressBook(personList);
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return addressBook;
	}
	
	AddressBook newAddressBook(String filePath)
	{
		file=new File(filePath);
		try 
		{
			file.createNewFile();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		personList=new ArrayList<Person>();
		addressBook=new AddressBook(personList);
		return addressBook;
	}	
	void printAddressBook(AddressBook addressBook)
	{
		iterator=addressBook.getPersonList().iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
	void showAllFiles(String folderPath)
	{
		file=new File(folderPath);
		File [] files =file.listFiles();
		int index=1;
		for(int i=0;i<files.length;i++)
		{
			System.out.println(index+++"  "+files[i].getName());
		}
	}
}