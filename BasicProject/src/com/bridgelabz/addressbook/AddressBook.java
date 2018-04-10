package com.bridgelabz.addressbook;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import com.bridgelabz.utility.Utility;

public class AddressBook 
{
	String firstName;
	String lastName;
	long phoneNumber;
	String city;
	String state;
	long zip;
	Address address;
	Person person;
	Utility utility=new Utility();
	AddressBook addressBook;
	Iterator<Person> iterator;
	boolean flag;
	
	private List<Person> personList;	
	
	public AddressBook(List<Person> personList) 
	{
		this.personList = personList;
	}
	
	public AddressBook()
	{
		
	}

	public List<Person> getPersonList() 
	{
		return personList;
	}
	
	@Override
	public String toString() 
	{
		return "AddressBook [personList=" + personList + "]";
	}

	void addPerson()
	{
		System.out.println("Enter First Name=");
		firstName=utility.next();
		System.out.println("Enter Last Name=");
		lastName=utility.next();
		System.out.println("Enter Phone Number=");
		phoneNumber=utility.nextLong();
		System.out.println("Enter city=");
		city=utility.next();
		System.out.println("Enter State=");
		state=utility.next();
		System.out.println("Enter Zip Code=");
		zip=utility.nextLong();
		
		address=new Address(city, state, zip);
		person=new Person(firstName, lastName, phoneNumber, address);
		personList.add(person);
		System.out.println(person);
		System.out.println("Added Person");
	}
	
	Person deletePerson(long phoneNumber)
	{
		iterator=personList.iterator();
		while(iterator.hasNext())
		{
			person=iterator.next();
			if(person.getPhoneNumber()==phoneNumber)
			{
				flag=true;
				personList.remove(person);
				break;
			}
		}
		if(flag==true)
		{
			return person;
		}
		else
		{
			return null;
		}
	}
	
	Person editPerson(long phoneNumber)
	{
		iterator=personList.iterator();
		while(iterator.hasNext())
		{
			person=iterator.next();
			if(person.getPhoneNumber()==phoneNumber)
			{
				flag=true;
				System.out.println("Enter city=");
				city=utility.next();
				System.out.println("Enter State=");
				state=utility.next();
				System.out.println("Enter Zip Code=");
				zip=utility.nextLong();
				
				address=new Address(city, state, zip);
				person.setAddress(address);
				break;
			}
		}
		if(flag==true)
		{
			return person;
		}
		else
		{
			return null;
		}
	}
	
	AddressBook sortByName()
	{
		Collections.sort(personList, new SortByName());
		System.out.println("Address Book has been Sorted according to Names");
		addressBook=new AddressBook(personList);
		return addressBook;
	}
	
	AddressBook sortByZip()
	{
		System.out.println("Address Book has been Sorted according to Zip Code");
		Collections.sort(personList, new SortByZipCode());
		addressBook=new AddressBook(personList);
		return addressBook;
	}
}