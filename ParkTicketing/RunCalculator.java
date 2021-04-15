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
			age = current - (birthYear + 1900) + 1; // 21���� ���� ����� ���̰��
		} else if (centuryDiv == 3 || centuryDiv == 4){
			age = current - (birthYear + 2000) + 1; // 21���� ����� ���̰��
		}
		return age;
	}
	
	public int feeCal(int type, int age) {
		OutputClass outputclass = new OutputClass();
		String agetype = outputclass.ageType(age);
		int fee = 0;
		switch (type) {
			case 1:
				if (agetype.equals("���")) {
					fee = ConstValueClass.dpElderly;
				} else if (agetype.equals("����")) {
					fee = ConstValueClass.dpAdult;
				} else if (agetype.equals("û�ҳ�")) {
					fee = ConstValueClass.dpTeen;
				} else if (agetype.equals("����")) {
					fee = ConstValueClass.dpKid;
				} else if (agetype.equals("����(����)")){
					fee = 0;
				} break;
			case 2:
				if (agetype.equals("���")) {
					fee = ConstValueClass.npElderly;
				} else if (agetype.equals("����")) {
					fee = ConstValueClass.npAdult;
				} else if (agetype.equals("û�ҳ�")) {
					fee = ConstValueClass.npTeen;
				} else if (agetype.equals("����")) {
					fee = ConstValueClass.npKid;
				} else if (agetype.equals("����(����)")){
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
			case 3: dcFee = (int)((fee * (1 - ConstValueClass.prefNatMerit)) / 10 * 10); break;
			case 4: dcFee = (int)((fee * (1 - ConstValueClass.prefManyKids)) / 10 * 10); break;
			case 5: dcFee = (int)((fee * (1 - ConstValueClass.prefPregnant)) / 10 * 10); break;
		}
		return dcFee;
	}

	
}
