package ParkTicketing;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RunCalculator {
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

	
	public int ageCal(String ssnInput) {
		int birthYear = Integer.parseInt(ssnInput.substring(0, 2));
		int current = Integer.parseInt(sdf.format(cal.getTime()));
		int centuryDiv = Integer.parseInt(ssnInput.substring(6, 7));
		int age = 0;
		
		if (centuryDiv == 1 || centuryDiv == 2) {
			age = current - (birthYear + 1900) + 1; // 21세기 이전 출생자 나이계산
		} else if (centuryDiv == 3 || centuryDiv == 4){
			age = current - (birthYear + 2000) + 1; // 21세기 출생자 나이계산
		}
		return age;
	}
	
	public int feeCal(int type, int age) {
		int fee = 0;
		switch (type) {
			case 1:
				if (age >= 65) {
					fee = ConstValueClass.dpElderly;
				} else if (age < 65 && age >= 19) {
					fee = ConstValueClass.dpAdult;
				} else if (age < 19 && age >= 13) {
					fee = ConstValueClass.dpTeen;
				} else if (age < 13 && age >= 3) {
					fee = ConstValueClass.dpKid;
				} else {
					fee = 0;
				} break;
			case 2:
				if (age >= 65) {
					fee = ConstValueClass.npElderly;
				} else if (age < 65 && age >= 19) {
					fee = ConstValueClass.npAdult;
				} else if (age < 19 && age >= 13) {
					fee = ConstValueClass.npTeen;
				} else if (age < 13 && age >= 3) {
					fee = ConstValueClass.npKid;
				} else {
					fee = 0;
				} break;
		}
		return fee;
	}
	
	public int prefCal(int fee, int option) {
		int dcFee = fee;
		switch (option) {
			case 1: break;
			case 2: dcFee = (int)((fee * (1 - ConstValueClass.prefDisabled)) / 10 * 10); break;
			case 3: dcFee = (int)((fee * (1 - ConstValueClass.prefMerit)) / 10 * 10); break;
			case 4: dcFee = (int)((fee * (1 - ConstValueClass.prefManyKids)) / 10 * 10); break;
			case 5: dcFee = (int)((fee * (1 - ConstValueClass.prefPregnant)) / 10 * 10); break;
		}
		return dcFee;
	}

	
}
