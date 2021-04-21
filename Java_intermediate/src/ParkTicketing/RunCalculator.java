package ParkTicketing;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class RunCalculator {
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	
	public int ageCal(String idnInput) { 
		// receives identification number from the user as input through console
		// calculates and returns age in integer
		int birthYear = Integer.parseInt(idnInput.substring(0, 2));
		int current = Integer.parseInt(sdf.format(cal.getTime()).substring(0, 4));
		int centuryDiv = Integer.parseInt(idnInput.substring(6, 7));
		int age = 0;
		
		if (centuryDiv == 1 || centuryDiv == 2) {
			age = current - (birthYear + 1900) + 1; // if born before the year 2000
		} else if (centuryDiv == 3 || centuryDiv == 4){
			age = current - (birthYear + 2000) + 1; // if born in the year 2000 or afterwards
		}
		return age;
	}
	
	public int feeCal(int ticketType, int age) throws IOException { 
		// receives ticket type and age data from the user as input through console
		// returns ticket price before getting preferential discount
		int ageType = type_AgeCohort(age);
		int fee = 0;
		switch (ticketType) {
			case 1:
				if (ageType == ConstValueClass.type_ELDERLY) {
					fee = ConstValueClass.dpElderly;
				} else if (ageType == ConstValueClass.type_ADULT) {
					fee = ConstValueClass.dpAdult;
				} else if (ageType == ConstValueClass.type_TEEN) {
					fee = ConstValueClass.dpTeen;
				} else if (ageType == ConstValueClass.type_CHILD) {
					fee = ConstValueClass.dpChild;
				} else if (ageType == ConstValueClass.type_INFANT){
					fee = 0;
				} break;
			case 2:
				if (ageType == ConstValueClass.type_ELDERLY) {
					fee = ConstValueClass.npElderly;
				} else if (ageType == ConstValueClass.type_ADULT) {
					fee = ConstValueClass.npAdult;
				} else if (ageType == ConstValueClass.type_TEEN) {
					fee = ConstValueClass.npTeen;
				} else if (ageType == ConstValueClass.type_CHILD) {
					fee = ConstValueClass.npChild;
				} else if (ageType == ConstValueClass.type_INFANT){
					fee = 0;
				} break;
		}
		return fee;
	}
	
	public int prefCal(int fee, int option) { 
		// receives fee and preferential discount option data and returns discounted ticket price in integer
		int dcFee = fee;
		switch (option) {
			case 1: break;
			case 2: dcFee = (int)((fee * (1 - ConstValueClass.prefDisabled)) / 10 * 10); break;
			case 3: dcFee = (int)((fee * (1 - ConstValueClass.prefNatMerit)) / 10 * 10); break;
			case 4: dcFee = (int)((fee * (1 - ConstValueClass.prefManyKids)) / 10 * 10); break;
			case 5: dcFee = (int)((fee * (1 - ConstValueClass.prefPregnant)) / 10 * 10); break;
		}
		return dcFee;
	}

	public int type_AgeCohort(int age) { 
		// receives age data and returns age cohort type the customer belongs in integer
		if (age < ConstValueClass.MIN_CHILD) {
			return ConstValueClass.type_INFANT;
		} else if ((age >= ConstValueClass.MIN_CHILD) && (age <= ConstValueClass.MAX_CHILD)) {
			return ConstValueClass.type_CHILD;
		} else if ((age >= ConstValueClass.MIN_TEEN) && (age <= ConstValueClass.MAX_TEEN)) {
			return ConstValueClass.type_TEEN;
		} else if ((age >= ConstValueClass.MIN_ADULT) && (age <= ConstValueClass.MAX_ADULT)) {
			return ConstValueClass.type_ADULT;
		} else if (age > ConstValueClass.MAX_ADULT) {
			return ConstValueClass.type_ELDERLY;
		} else {
			return 0;
		}
	}
	
	public void savingFormat(int ticketType, int age, int numTickets, int fee, int prefType, 
			ArrayList<Customer> csInfoArr) { 
		// feeds data to the created data structure that will be exported into a csv file
		int agetype = 0;
		agetype = type_AgeCohort(age);
		
		Customer csInfo = new Customer();
		csInfo.setDate(sdf.format(cal.getTime()));
		csInfo.setTicketType(ticketType);
		csInfo.setAgeCohortType(agetype);
		csInfo.setNumTickets(numTickets);
		csInfo.setTicketPrice(fee);
		csInfo.setPrefType(prefType);
		
		switch (ticketType) {
			case 1:
				csInfo.setTicketName(ConstValueClass.DAYPASS);
			case 2:
				csInfo.setTicketName(ConstValueClass.NIGHTPASS);
			default:
				break;
		}
		switch (prefType) {
			case 1:
				csInfo.setPrefOption(ConstValueClass.pref_NONE);
			case 2:
				csInfo.setPrefOption(ConstValueClass.pref_DISABLED);
			case 3:
				csInfo.setPrefOption(ConstValueClass.pref_NatMERIT);
			case 4:
				csInfo.setPrefOption(ConstValueClass.pref_ManyKIDS);
			case 5:
				csInfo.setPrefOption(ConstValueClass.pref_PREGNANT);
			default:
				break;
		}
		csInfoArr.add(csInfo);
		
		DatabaseOutputClass dbOut = new DatabaseOutputClass();
		dbOut.addToDatabase(csInfo);
		
	}
	
}
