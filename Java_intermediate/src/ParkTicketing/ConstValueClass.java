package ParkTicketing;

import java.util.ArrayList;

public class ConstValueClass {
	
	public static final int dpAdult = 56000; // 19~64��
	public static final int dpTeen = 47000; // 13~18��
	public static final int dpChild = 44000; // 3~12��
	public static final int dpElderly = 44000; // 65�� �̻�
	
	public static final int npAdult = 46000; // 19~64��
	public static final int npTeen = 40000; // 13~18��
	public static final int npChild = 37000; // 3~12��
	public static final int npElderly = 37000; // 65�� �̻�
	
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
	
	
	public static final String DAYPASS = "�ְ���"; 
	public static final String NIGHTPASS = "�߰���";
	
	public static final String cohort_INFANT = "����";
	public static final String cohort_CHILD = "���";
	public static final String cohort_TEEN = "û�ҳ�";
	public static final String cohort_ADULT = "�";
	public static final String cohort_ELDERLY = "����";

	public static final String pref_NONE = "����";
	public static final String pref_DISABLED = "�����";
	public static final String pref_NatMERIT = "����������";
	public static final String pref_ManyKIDS = "���ڳ�";
	public static final String pref_PREGNANT = "�ӻ��";
	
	public static final int type_INFANT = 1;
	public static final int type_CHILD = 2;
	public static final int type_TEEN = 3;
	public static final int type_ADULT = 4;
	public static final int type_ELDERLY = 5;
	
	public static final String savePATH = "C:\\Users\\kopo\\Desktop\\recordSells.csv";
	public static final String savePATH1 = "C:\\Users\\kopo\\Desktop\\Report.csv";

	public static ArrayList<Customer> csInfoArr = new ArrayList<Customer>();
}
