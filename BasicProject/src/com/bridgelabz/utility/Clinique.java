package com.bridgelabz.utility;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@SuppressWarnings("unchecked")
public class Clinique 
{
	String mDoctorPath="/home/bridgeit/Ganesh/BasicProject/Files/Doctor.json";
	String mPatientPath="/home/bridgeit/Ganesh/BasicProject/Files/Patient.json";
	String mAppointmentsPath="/home/bridgeit/Ganesh/BasicProject/Files/Appointments.json";
	
	public boolean addDoctor(String name,long id,String specialization,
							String availability,long noOfPatients)
	{
		boolean flag=false;
		JSONArray jsonArray=Utility.readJsonArrayFile(mDoctorPath);
		JSONObject jsonObject=null;
		for(int i=0;i<jsonArray.size();i++)
		{
			jsonObject=(JSONObject)jsonArray.get(i);
			if((long)jsonObject.get("Id")==id)
			{
				flag=true;
				break;
			}
		}
		if(flag==false)
		{
			jsonObject=new JSONObject();
			jsonObject.put("DoctorName", name);
			jsonObject.put("Id", id);
			jsonObject.put("Specialization", specialization);
			jsonObject.put("Availability", availability);
			jsonObject.put("NoOfPatients", noOfPatients);
			jsonArray.add(jsonObject);
			Utility.writeJsonArrayFile(mDoctorPath, jsonArray);
			return true;
		}
		return false;
	}
	
	public boolean addPatient(String name,long id,long age,long mobile)
	{
		boolean flag=false;
		JSONArray jsonArray=Utility.readJsonArrayFile(mPatientPath);
		JSONObject jsonObject=null;
		for(int i=0;i<jsonArray.size();i++)
		{
			jsonObject=(JSONObject)jsonArray.get(i);
			if((long)jsonObject.get("Id")==id)
			{
				flag=true;
				break;
			}
		}
		if(flag==false)
		{
			jsonObject=new JSONObject();
			jsonObject.put("PatientName", name);
			jsonObject.put("Id", id);
			jsonObject.put("Age", age);
			jsonObject.put("MobileNumber", mobile);
			jsonArray.add(jsonObject);
			Utility.writeJsonArrayFile(mPatientPath, jsonArray);
			return true;
		}
		return false;
	}
	
	public void displayDoctor()
	{
		JSONArray jsonArray=Utility.readJsonArrayFile(mDoctorPath);
		Iterator<JSONObject> iterator=jsonArray.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
	
	public void displayPatient()
	{
		JSONArray jsonArray=Utility.readJsonArrayFile(mPatientPath);
		Iterator<JSONObject> iterator=jsonArray.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
	
	public void displayAppointments()
	{
		JSONArray jsonArray=Utility.readJsonArrayFile(mAppointmentsPath);
		Iterator<JSONObject> iterator=jsonArray.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
	
	public JSONObject searchPatientById(long id)
	{
		boolean flag=false;int i;
		JSONArray jsonArray=Utility.readJsonArrayFile(mPatientPath);
		JSONObject jsonObject=new JSONObject();
		for(i=0;i<jsonArray.size();i++)
		{
			jsonObject=(JSONObject)jsonArray.get(i);
			if((long)jsonObject.get("Id")==id)
			{
				flag=true;
				break;
			}
		}
		if(flag==false)
		{
			return null;
		}
		else
		{
			return (JSONObject)jsonArray.get(i);
		}
	}
	
	public JSONObject searchDoctorById(long id)
	{
		boolean flag=false;int i;
		JSONArray jsonArray=Utility.readJsonArrayFile(mDoctorPath);
		JSONObject jsonObject=null;
		for(i=0;i<jsonArray.size();i++)
		{
			jsonObject=(JSONObject)jsonArray.get(i);
			if((long)jsonObject.get("Id")==id)
			{
				flag=true;
				break;
			}
		}
		if(flag==false)
		{
			return null;
		}
		else
		{
			return (JSONObject)jsonArray.get(i);
		}
	}
	
	public JSONArray searchDoctorBySpecialization(String specialization)
	{
		JSONArray jsonArray=Utility.readJsonArrayFile(mDoctorPath);
		JSONArray specializationJsonArray=new JSONArray();
		JSONObject jsonObject=null;
		for(int i=0;i<jsonArray.size();i++)
		{
			jsonObject=(JSONObject)jsonArray.get(i);
			if(jsonObject.get("Specialization").equals(specialization))
			{
				specializationJsonArray.add(jsonObject);
			}
		}
		return specializationJsonArray;
	}
	
	public JSONArray searchPatientByAge(Long age)
	{
		JSONArray jsonArray=Utility.readJsonArrayFile(mPatientPath);
		JSONArray ageJsonArray=new JSONArray();
		JSONObject jsonObject=null;
		for(int i=0;i<jsonArray.size();i++)
		{
			jsonObject=(JSONObject)jsonArray.get(i);
			if(jsonObject.get("Age").equals(age))
			{
				ageJsonArray.add(jsonObject);
			}
		}
		return ageJsonArray;
	}

	public JSONArray searchDoctorByAvailability(String availability)
	{
		JSONArray jsonArray=Utility.readJsonArrayFile(mDoctorPath);
		JSONArray availabilityJsonArray=new JSONArray();
		JSONObject jsonObject=null;
		for(int i=0;i<jsonArray.size();i++)
		{
			jsonObject=(JSONObject)jsonArray.get(i);
			if(jsonObject.get("Availability").equals(availability))
			{
				availabilityJsonArray.add(jsonObject);
			}
		}
		return availabilityJsonArray;
	}
	
	public JSONArray availableDoctors(JSONArray jsonArray)
	{
		JSONArray availableDoctors=new JSONArray();
		JSONObject jsonObject=null;
		for(int i=0;i<jsonArray.size();i++)
		{
			jsonObject=(JSONObject)jsonArray.get(i);
			if((Long)jsonObject.get("NoOfPatients")<5)
			{
				availableDoctors.add(jsonObject);
			}
		}
		return availableDoctors;
	}
	
	public boolean checkDoctorId(long doctorId)
	{
		JSONArray jsonArray=Utility.readJsonArrayFile(mDoctorPath);
		JSONObject jsonObject=null;
		for(int i=0;i<jsonArray.size();i++)
		{
			jsonObject=(JSONObject)jsonArray.get(i);
			if((long)jsonObject.get("Id")==doctorId)
			{
				if((long)jsonObject.get("NoOfPatients")<5)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		return false;
	}
	
	public JSONObject takeAppointmentById(long doctorId,long patientId)
	{
		JSONArray jsonArray=Utility.readJsonArrayFile(mDoctorPath);
		JSONObject jsonObject=null;
		for(int i=0;i<jsonArray.size();i++)
		{
			jsonObject=(JSONObject)jsonArray.get(i);
			if((long)jsonObject.get("Id")==doctorId)
			{
				jsonArray.remove(i);
				jsonObject.put("NoOfPatients", (long)jsonObject.get("NoOfPatients")+1);
				break;
			}
		}
		jsonArray.add(jsonObject);
		String specialization=(String)jsonObject.get("Specialization");
		long noOfPatients=(long)jsonObject.get("NoOfPatients");
		Utility.writeJsonArrayFile(mDoctorPath, jsonArray);
		writeAppointment(doctorId, patientId, noOfPatients,specialization);
		return jsonObject;
	}
	
	public void writeAppointment(long doctorId,long patientId,long noOfPatients,String specialization)
	{
		JSONArray appointmentArray=Utility.readJsonArrayFile(mAppointmentsPath);
		JSONObject jsonObject=null,patientIdJson=null,doctor=null;
		JSONArray patientArray=null;
		boolean flag=false;
		for(int i=0;i<appointmentArray.size();i++)
		{
			jsonObject=(JSONObject)appointmentArray.get(i);
			if((long)jsonObject.get("DoctorId")==doctorId)
			{
				patientArray=(JSONArray)jsonObject.get("Patients");
				appointmentArray.remove(i);
				patientIdJson=new JSONObject();
				patientIdJson.put("PatientId", patientId);
				patientArray.add(patientIdJson);
				jsonObject.put("Patients", patientArray);
				jsonObject.put("specialization", specialization);
				appointmentArray.add(jsonObject);
				Utility.writeJsonArrayFile(mAppointmentsPath, appointmentArray);
				flag=true;
				break;
			}
		}
		if(flag==false)
		{
			patientArray=new JSONArray();
			patientIdJson=new JSONObject();
			doctor=new JSONObject();
			patientIdJson.put("PatientId", patientId);
			patientArray.add(patientIdJson);
			doctor.put("Patients", patientArray);
			doctor.put("DoctorId", doctorId);
			doctor.put("specialization", specialization);
			appointmentArray.add(doctor);
			Utility.writeJsonArrayFile(mAppointmentsPath, appointmentArray);
		}
	}
	
}