package reporting;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Output {
	static FileWrite fw = new FileWrite();

	// report파일 읽어오고 console출력
	public void total_Report() {
		BufferedReader reader;
		try {
	//		BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream (ConstValue.address, true),"MS949"));
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(ConstValue.report), "MS949"));
			List<List<String>> List = new ArrayList<List<String>>();
			List<String> OneLine = new ArrayList<String>();
			String line = "";
			while ((line = reader.readLine()) != null) {
				String[] array = line.split(",");
				OneLine = Arrays.asList(array);
				List.add(OneLine);
			}
			System.out.println("==================== report.csv =========================");
			System.out.println("날짜        권종  연령구분 수량    가격   우대사항");
			for (int i = 0; i < List.size(); i++) {
				for (int j = 0; j < ConstValue.type_Ticket.length; j++) {
					if (List.get(i).get(1).equals(ConstValue.type_Ticket[j])) {
						List.get(i).set(1, ConstValue.option[j]);
					}
				}
				for (int j = 0; j < ConstValue.applied_Priority.length; j++) {
					if (List.get(i).get(5).equals(ConstValue.applied_Priority[j])) {
						List.get(i).set(5, ConstValue.option[j]);
					}
				}
			}
			for (int i = 0; i < List.size(); i++) {
				for (int j = 0; j < List.get(i).size(); j++) {
					System.out.print(List.get(i).get(j) + "     ");
				}
				System.out.println();
			}
			System.out.println("---------------------------------------------------------\n\n");

			cal_Type_Count(List);
			type_Count(List);
			cal_Day_Profit(List);
			priority_Count(List);

		} catch (
		Exception e) {
			e.printStackTrace();
		}
	}

	// 권종 별 판매현황 계산 메소드
	public static void cal_Type_Count(List<List<String>> List) {
		System.out.println("=================== 권종 별 판매현황 ========================");
		for (int i = 0; i < List.size(); i++) {
			if (List.get(i).get(1).equals(ConstValue.option[1])) {
				ConstValue.day_count = ConstValue.day_count + Integer.parseInt(List.get(i).get(3));
				ConstValue.day_Total_Price = ConstValue.day_Total_Price + Integer.parseInt(List.get(i).get(4));
				for (int j = 0; j < ConstValue.type_Day_Count.length; j++) {
					if (ConstValue.type_Person[j].equals(List.get(i).get(2))) {
						ConstValue.type_Day_Count[j] = ConstValue.type_Day_Count[j]
								+ Integer.parseInt(List.get(i).get(3));
					}
				}
			} else {
				ConstValue.night_count = ConstValue.night_count + Integer.parseInt(List.get(i).get(3));
				ConstValue.night_Total_Price = ConstValue.night_Total_Price + Integer.parseInt(List.get(i).get(4));
				for (int j = 0; j < ConstValue.type_Night_Count.length; j++) {
					if (ConstValue.type_Person[j].equals(List.get(i).get(2))) {
						ConstValue.type_Night_Count[j] = ConstValue.type_Night_Count[j]
								+ Integer.parseInt(List.get(i).get(3));
					}
				}
			}
		}
	}

	// 권종 별 판매현황
	public static void type_Count(List<List<String>> List) {
		System.out.println(ConstValue.type_Ticket[1] + " 총 " + ConstValue.day_count + "매");
		for (int i = 0; i < ConstValue.type_Person.length; i++) {
			System.out.print(ConstValue.type_Person[i] + " : " + ConstValue.type_Day_Count[i] + "매  ");
		}
		System.out.println("\n" + ConstValue.type_Ticket[1] + " 매출 : " + ConstValue.day_Total_Price + "원\n");

		System.out.println(ConstValue.type_Ticket[2] + " 총 " + ConstValue.night_count + "매");
		for (int i = 0; i < ConstValue.type_Person.length; i++) {
			System.out.print(ConstValue.type_Person[i] + " : " + ConstValue.type_Night_Count[i] + "매  ");
		}
		System.out.println("\n" + ConstValue.type_Ticket[2] + " 매출 : " + ConstValue.night_Total_Price + "원\n");
		System.out.println("-------------------------------------------------------------\n\n");
	}

	// 일자별 매출 현황
	public static void cal_Day_Profit(List<List<String>> List) {
		System.out.println("=================== 일자별 매출 현황 ========================");
		HashSet<String> date = new HashSet<String>();
		for (int i = 0; i < List.size(); i++) {
			date.add(List.get(i).get(0));
		}
		ArrayList<String> date_Data = new ArrayList<String>(date);
		Collections.sort(date_Data);
		int[] date_Price = new int[date.size()];

		for (int i = 0; i < date.size(); i++) {
			for (int j = 0; j < List.size(); j++) {
				if (List.get(j).get(0).equals(date_Data.get(i))) {
					date_Price[i] = date_Price[i] + Integer.parseInt(List.get(j).get(4));
				}
			}
			System.out.println(date_Data.get(i) + " : 총 매출  " + date_Price[i] + "원");
		}
		fw.day_Profit(date_Data, date_Price);
	}

	// 우대권 판매 현황
	public static void priority_Count(List<List<String>> List) {
		System.out.println("-------------------------------------------------------------\n\n");
		System.out.println("=================== 우대권 판매 현황 ========================");
		for (int i = 0; i < List.size(); i++) {
			ConstValue.total_Count = ConstValue.total_Count + Integer.parseInt(List.get(i).get(3));
			for (int j = 1; j < ConstValue.applied_Priority.length; j++) {
				if (List.get(i).get(5).equals(ConstValue.option[j])) {
					ConstValue.priority_Count[j] = ConstValue.priority_Count[j] + Integer.parseInt(List.get(i).get(3));
				}
			}
		}
		System.out.println("총 판매 티켓수   :   " + ConstValue.total_Count + "매");
		for (int i = 1; i < ConstValue.priority_Count.length; i++) {
			System.out.println(ConstValue.applied_Priority[i] + "   :   " + ConstValue.priority_Count[i] + "매");
		}
		System.out.println("-------------------------------------------------------------");
	}
}