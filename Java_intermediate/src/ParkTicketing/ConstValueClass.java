package ParkTicketing;

import java.util.ArrayList;

public class ConstValueClass {
	
	public static final int dpAdult = 56000; // 19~64세
	public static final int dpTeen = 47000; // 13~18세
	public static final int dpChild = 44000; // 3~12세
	public static final int dpElderly = 44000; // 65세 이상
	
	public static final int npAdult = 46000; // 19~64세
	public static final int npTeen = 40000; // 13~18세
	public static final int npChild = 37000; // 3~12세
	public static final int npElderly = 37000; // 65세 이상
	
	public static final int type_NoPref = 1;
	public static final int type_Disabled = 2;
	public static final int type_NatMerit = 3;
	public static final int type_ManyKids = 4;
	public static final int type_Pregnant = 5;
	
	public static final double prefDisabled = 0.4;
	public static final double prefNatMerit = 0.5;
	public static final double prefManyKids = 0.2;
	public static final double prefPregnant = 0.15;
	
	public static final int MIN_BABY = 1;
	public static final int MIN_CHILD = 3;
	public static final int MIN_TEEN = 13;
	public static final int MIN_ADULT = 19;
	
	public static final int MAX_CHILD = 13;
	public static final int MAX_TEEN = 18;
	public static final int MAX_ADULT = 64;
	
	public static final int MAX_COUNT = 10;
	public static final int MIN_COUNT = 1;
	
	public static final int MAX_ID_DIGITS = 7;
	public static final int MIN_ID_DIGITS = 1;
	
	
	public static final String DAYPASS = "주간권"; 
	public static final String NIGHTPASS = "야간권";
	
	public static final String cohort_INFANT = "유아";
	public static final String cohort_CHILD = "어린이";
	public static final String cohort_TEEN = "청소년";
	public static final String cohort_ADULT = "어른";
	public static final String cohort_ELDERLY = "노인";

	public static final String pref_NONE = "없음";
	public static final String pref_DISABLED = "장애인";
	public static final String pref_NatMERIT = "국가유공자";
	public static final String pref_ManyKIDS = "다자녀";
	public static final String pref_PREGNANT = "임산부";
	
	public static final int type_INFANT = 1;
	public static final int type_CHILD = 2;
	public static final int type_TEEN = 3;
	public static final int type_ADULT = 4;
	public static final int type_ELDERLY = 5;
	
	public static final String savePATH = "C:\\Users\\kopo\\Desktop\\recordSells.csv";
	public static final String savePATH1 = "C:\\Users\\kopo\\Desktop\\Report.csv";

	public static ArrayList<Customer> csInfoArr = new ArrayList<Customer>();
}
