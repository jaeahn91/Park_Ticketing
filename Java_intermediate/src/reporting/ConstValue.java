package reporting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ConstValue {
	public static final String[] option = {"0","1","2","3","4","5","6"}; //권종,우대사항을 숫자로 바꾸기 위해 설정
	public static final String[] type_Ticket = {null,"주간권","야간권"};
	public static final String[] type_Person = {"대인","청소년","소인","경로","유아"};
	public static String[] applied_Priority = {null,"우대적용 없음", "장애인 우대적용", "국가유공자 우대적용", "다자녀 우대적용", "임산부 우대적용"};
	
	public static int total_Price = 0; //구매할 때 총 합계금액
	
	public static int day_count = 0; //주간권 판매 수
	public static int night_count = 0;	//야간권 판매 수
	
	public static int[] type_Day_Count = {0,0,0,0,0};	//주간 나이별 판매 수
	public static int[] type_Night_Count = {0,0,0,0,0};	//주간 나이별 판매 수
	public static int[] priority_Count = {0,0,0,0,0,0};	//우대권별 판매 수
	
	public static int day_Total_Price = 0;		//주간권 수익
	public static int night_Total_Price = 0;	//야간권 수익
	
	public static int total_Count = 0; //총 매수
	
	public static String report = "C:\\Users\\kopo\\Desktop\\recordSells.csv";
	public static String daily = "C:\\Users\\kopo\\Desktop\\daily_profit.csv";
	public static String type_Count = "C:\\Users\\kopo\\Desktop\\sale_count.csv";
	
	


}