package com.bridgelabz.designpatterns;

import com.bridgelabz.utility.Employee;
import com.bridgelabz.utility.Utility;

public class PrototypePattern 
{
	public static void main(String[] args) 
	{
		int id;
		String name;
		long mobileNumber;
		int age;
		
		Utility utility=new Utility();
		
		System.out.println("Enter Id");
		id=utility.nextInt();
		System.out.println("Enter Name");
		name=utility.next();
		System.out.println("Enter Mobile Number");
		mobileNumber=utility.nextLong();
		System.out.println("Enter Age");
		age=utility.nextInt();
		
		Employee employee1=new Employee(id, name, mobileNumber, age);
		Employee employee2=(Employee)employee1.clone();
		Employee employee3=(Employee)employee1.clone();
		Employee employee4=(Employee)employee1.clone();
		
		System.out.println("Employee1="+employee1);
		System.out.println("Employee2="+employee2);
		System.out.println("Employee3="+employee3);
		System.out.println("Employee4="+employee4);
	}
}