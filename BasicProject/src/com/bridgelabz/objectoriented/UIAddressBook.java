/**
 * Purpose maintaining Address book using json
 * @author Ganesh
 * @since 15 March 2018
 */
package com.bridgelabz.objectoriented;

import com.bridgelabz.utility.AddressBook;
import com.bridgelabz.utility.Utility;

public class UIAddressBook 
{
	public static void main(String[] args) 
	{
		int choice=0;
		Utility utility=new Utility();
		AddressBook addressBook=new AddressBook();
		String firstName,lastName,address,city,state;
		long zip,mobile;
		boolean flag=false;
		do
		{
			System.out.println("1. Add");
			System.out.println("2. Edit");
			System.out.println("3. Delete");
			System.out.println("4. Sort by Name");
			System.out.println("5. Sort by Zip code");
			System.out.println("6. Display Address Book");
			System.out.println("7. Display Sorted Address Book");
			System.out.println("8. Exit");
			System.out.println("Enter your choice=");
			choice=utility.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter Firstname=");
				firstName=utility.next();
				System.out.println("Enter Lastname=");
				lastName=utility.next();
				System.out.println("Enter Address=");
				address=utility.next();
				System.out.println("Enter City=");
				city=utility.next();
				System.out.println("Enter State=");
				state=utility.next();
				System.out.println("Enter Zip=");
				zip=utility.nextLong();
				System.out.println("Enter Mobile Number=");
				mobile=utility.nextLong();
				flag=addressBook.addPerson(firstName, lastName, zip, mobile, address, city, state);
				if(flag==true)
				{
					System.out.println("New Entry was Added.");
				}
				else
				{
					System.out.println("Entry is already present.");
				}
				break;
				
			case 2:
				System.out.println("Enter Firstname=");
				firstName=utility.next();
				System.out.println("Enter Lastname=");
				lastName=utility.next();
				System.out.println("Enter Address=");
				address=utility.next();
				System.out.println("Enter City=");
				city=utility.next();
				System.out.println("Enter State=");
				state=utility.next();
				System.out.println("Enter Zip=");
				zip=utility.nextLong();
				System.out.println("Enter Mobile Number=");
				mobile=utility.nextLong();
				flag=addressBook.editPerson(firstName, lastName, zip, mobile, address, city, state);
				if(flag==true)
				{
					System.out.println("Entry has been changed.");
				}
				else
				{
					System.out.println("Entry is not present.");
				}
				break;
				
			case 3:
				System.out.println("Enter Firstname=");
				firstName=utility.next();
				flag=addressBook.deletePerson(firstName);
				if(flag==true)
				{
					System.out.println("Entry of Name "+firstName+" has been Deleted.");
				}
				else
				{
					System.out.println("Entry is not present.");
				}
				break;
				
			case 4:
				addressBook.sortByName();
				System.out.println("Address Book has been sorted by Name.");
				break;
				
			case 5:
				addressBook.sortByZip();
				System.out.println("Address Book has been sorted by Zip Code.");
				break;
			
			case 6:
				addressBook.display();
				break;
			
			case 7:
				addressBook.displaySortedAddressBook();
				break;
				
			default:
				System.out.println("Invalid Input");
				System.out.println("1. Add");
				System.out.println("2. Edit");
				System.out.println("3. Delete");
				System.out.println("4. Sort by Name");
				System.out.println("5. Sort by Zip code");
				System.out.println("6. Display Address Book");
				System.out.println("7. Display Sorted Address Book");
				System.out.println("8. Exit");
				System.out.println("Enter your choice=");
				choice=utility.nextInt();
				
			}
		}
		while(choice!=8);
	}
}