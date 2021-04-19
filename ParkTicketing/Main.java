package ParkTicketing;

import java.io.IOException;
import java.util.Scanner;



public class Main {

	public static int type, numTickets, prefType, age, type_ageCohort, fee, fee_ActuallyPaid;
	public static int totalfee, nextRound, exitproceed;
	public static String idNumber, ageCohort, transaction;
	public static void main(String[] args) throws IOException {
		
		InputClass inputclass = new InputClass();
		RunCalculator run = new RunCalculator();
		OutputClass outclass = new OutputClass();
		
//		ReadCSV read = new ReadCSV(); // 이후 매출분석에 활용할 클래스. 매출분석기능 아직 미구현
		
		int sellbyType [][]; // 권종별 판매내역 저장, 이후 매출분석에 활용
		
		while(true) {
			type = inputclass.ticketType(); // 주/야간권 선택 입력받기
			idNumber = inputclass.numID(); // 주민번호 7자리 입력받기 
			numTickets = inputclass.numTickets(); // 발권 희망 티켓 장수 입력받기
			prefType = inputclass.prefOptions(); // 우대사항 입력받기
			
			age = run.ageCal(idNumber); // 입력받은 주민번호로 나이를 계산해 age에 저장
			type_ageCohort = run.type_AgeCohort(age); // 계산된 나이를 이용해 연령층 구분
			fee = run.feeCal(type, age); // 권종과 나이를 이용해 요금 계산
			fee_ActuallyPaid = run.prefCal(fee, prefType); // 우대여부 확인해 할인적용 금액 산정
			fee_ActuallyPaid = numTickets * fee_ActuallyPaid; // 할인적용 금액에 발권 장수를 곱해 총지불금액 계산			
			ageCohort = outclass.printAgeCohort(age); // 연령구분 출력결과를 스트링변수에 저장
			
			outclass.printPrice(fee_ActuallyPaid); // 총지불금액 안내 메시지 콘솔에 출력
			
			totalfee += fee_ActuallyPaid; // 총지불금액을 int변수에 저장, 발권이 여러차례 이뤄지는 경우에도 계속
			// 저장하도록 처리			
			run.savingFormat(type, age, numTickets, fee_ActuallyPaid, prefType, ConstValueClass.csInfoArr);
			// 파일 저장 메소드에서 설정한 자료구조에 맞도록 입력 변수들 지정
			// 파일저장경로는 ConstValueClass에 savePATH로 저장, OutputClass의 saveFile 메소드에서 호출
			transaction += outclass.receipt(type,  ageCohort, numTickets, fee_ActuallyPaid, prefType);			
			// 콘솔에 영수증 거래내역 출력 메소드 형식에 맞게 입력 변수들 지정, 스트링변수에 내용 저장
			// 콘솔에 영수증 출력해보면 첫번째 거래내역 type(권종) 앞에 null붙어 출력되는 문제. 아직 수정 안됨 
			
			nextRound = inputclass.nextRound(); // 재차 발권할지 여부 확인하는 메소드(1: 티켓발권 2: 종료)
			
			if (nextRound == 2) { // 2를 입력받은 경우(계속 발권 안함)
				outclass.startofReceipt(); // 영수증 첫 줄 출력 메소드
				System.out.println(transaction); // 거래내역 출력		
				outclass.receiptTotal(totalfee); // 입장료 총액은 _원 입니다
				outclass.endofReceipt(); // 영수증 마지막줄 출력
				exitproceed = inputclass.exitorProceed(); // 영수증까지 콘솔에 출력된 후 다음 작업 확인하는 메소드
				// 1(새로운 주문) 2(프로그램 종료)
				transaction = ""; // 이전 영수증은 출력됐으니 다시 거래내역 초기화
				totalfee = 0; // 입장료 총액 초기화
				if (exitproceed == 2) { // 프로그램 종료를 선택했다면
					outclass.saveFile(ConstValueClass.csInfoArr); // 파일에 판매내역 저장
					break; // while문을 빠져나감으로써 프로그램 종료
				}
			}
			
		}
	}
}
