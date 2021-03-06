/**
 * Purpose Managing CLinique Patients can take appointment from doctors using json
 * @author Ganesh
 * @since 17 March 2018
 */
package com.bridgelabz.objectoriented;

import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.bridgelabz.utility.Clinique;
import com.bridgelabz.utility.Utility;

@SuppressWarnings("unchecked")
public class CliniqueManagement 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		Clinique clinique=new Clinique();
		JSONObject jsonObject=null;
		JSONArray jsonArray=null;
		Iterator<JSONObject> iterator=null;
		String name,specialization,availability;
		long id,mobile,age,doctorId=0;;
		boolean flag=false;
		int choice=0,appointment=0;
		do
		{
			System.out.println("1. Add Doctor");
			System.out.println("2. Add Patient");
			System.out.println("3. Display Doctors");
			System.out.println("4. Display Patients");
			System.out.println("5. Search patient by Id");
			System.out.println("6. Search Patient by Age");
			System.out.println("7. Search Doctor by Id");
			System.out.println("8. Search Doctor by Specialization");
			System.out.println("9. Search Doctor by Availability");
			System.out.println("10. Take Appointment by Specialization");
			System.out.println("11. Take Appointment by Id");
			System.out.println("12. Display Appointments");
			System.out.println("13. Exit");
			System.out.println("Enter your choice");
			choice=utility.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter Name");
				name=utility.next();
				System.out.println("Enter Id");
				id=utility.nextLong();
				System.out.println("Enter specialization");
				specialization=utility.next();
				System.out.println("Enter availability");
				availability=utility.next();
				flag=clinique.addDoctor(name, id, specialization, availability, 0);
				if(flag==true)
				{
					System.out.println("Doctor was Added.");
				}
				else
				{
					System.out.println("Cant add Doctor with same Id.");
				}
				break;
				
			case 2:
				System.out.println("Enter Name");
				name=utility.next();
				System.out.println("Enter Id");
				id=utility.nextLong();
				System.out.println("Enter Mobile Number");
				mobile=utility.nextLong();
				System.out.println("Enter Age");
				age=utility.nextLong();
				flag=clinique.addPatient(name, id, age, mobile);
				if(flag==true)
				{
					System.out.println("Patient was Added.");
				}
				else
				{
					System.out.println("Cant add Patient with same Id.");
				}
				break;
				
			case 3:
				clinique.displayDoctor();
				break;
				
			case 4:
				clinique.displayPatient();
				break;
				
			case 5:
				System.out.println("Enter Id to search Patient=");
				id=utility.nextLong();
				jsonObject=clinique.searchPatientById(id);
				if(jsonObject==null)
				{
					System.out.println("Patient with Id="+id+" was not found.");
				}
				else
				{
					System.out.println("Patient was found.");
					System.out.println(jsonObject);
				}
				
			case 6:
				System.out.println("Enter the Age=");
				age=utility.nextLong();
				jsonArray=clinique.searchPatientByAge(age);
				if(jsonArray.size()==0)
				{
					System.out.println("Patient with Age="+age+" was not found.");
				}
				else
				{
					iterator=jsonArray.iterator();
					while(iterator.hasNext())
					{
						System.out.println(iterator.next());
					}
				}
				break;
				
			case 7:
					System.out.println("Enter Id to search Doctor=");
					id=utility.nextLong();
					jsonObject=clinique.searchDoctorById(id);
					if(jsonObject==null)
					{
						System.out.println("Patient with Id="+id+" was not found.");
					}
					else
					{
						System.out.println(jsonObject);
					}
				break;
				
			case 8:
				System.out.println("Enter the Specialization=");
				specialization=utility.next();
				jsonArray=clinique.searchDoctorBySpecialization(specialization);
				if(jsonArray.size()==0)
				{
					System.out.println("Doctor with Specialization "+specialization+" was not found.");
				}
				else
				{
					iterator=jsonArray.iterator();
					while(iterator.hasNext())
					{
						System.out.println(iterator.next());
					}
				}
				break;
				
			case 9:
				System.out.println("Enter the Availability=");
				availability=utility.next();
				jsonArray=clinique.searchDoctorByAvailability(availability);
				if(jsonArray.size()==0)
				{
					System.out.println("Doctor with Availability "+availability+" was not found.");
				}
				else
				{
					iterator=jsonArray.iterator();
					while(iterator.hasNext())
					{
						System.out.println(iterator.next());
					}
				}
				break;
				
			case 10:
				System.out.println("Enter your Id");
				id=utility.nextLong();
				jsonObject=clinique.searchPatientById(id);
				if(jsonObject==null)
				{
					System.out.println("Patient Id not present .");
					break;
				}
				System.out.println("Enter the Specialization=");
				specialization=utility.next();
				jsonArray=clinique.searchDoctorBySpecialization(specialization);
				jsonArray=clinique.availableDoctors(jsonArray);
				if(jsonArray.size()==0)
				{
					System.out.println("Doctor with Specialization "+specialization+" was not found "
											+ "or not available.");
					break;
				}
				else
				{
					iterator=jsonArray.iterator();
					while(iterator.hasNext())
					{
						System.out.println(iterator.next());
					}
				}
				System.out.println("Press 1 to take appointment from any of the above Doctor");
				System.out.println("Press any other keys to exit");
				appointment=utility.nextInt();
				
				if(appointment==1)
				{
					jsonObject=(JSONObject)jsonArray.get(0);
					jsonObject=clinique.takeAppointmentById((long)jsonObject.get("Id"),id);
					System.out.println("Took appointment with Doctor "+jsonObject.get("DoctorName"));
				}
				else
				{
					System.out.println("Enter Id");
					doctorId=utility.nextInt();
					jsonObject=clinique.takeAppointmentById(doctorId, id);
					System.out.println("Took appointment with Doctor "+jsonObject.get("DoctorName"));
				}
					
				break;
			case 11:
				System.out.println("Enter your Id");
				id=utility.nextLong();
				System.out.println("Enter Doctor Id");
				doctorId=utility.nextLong();
				flag=clinique.checkDoctorId(doctorId);
				if(flag==true)
				{
					jsonObject=clinique.takeAppointmentById(doctorId, id);
					System.out.println("Took appointment with Doctor "+jsonObject.get("DoctorName"));
				}
				else
				{
					System.out.println("Doctor with Id="+doctorId+" is not available or not found");
				}
				break;
				
			case 12:
				clinique.displayAppointments();
				break;
			}
		}
		while(choice!=13);
	}
}