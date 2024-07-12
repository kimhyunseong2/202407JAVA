package java0712;

import java.util.Scanner;

public class project {

	public static void main(String[] args) {
		boolean run = true;
		boolean run2 = true;
		Scanner scan = new Scanner(System.in);
		
		
		while(run) {
			System.out.println("-------------------------------");
			System.out.println("1.로그인 : 2.회원가입 : 3.예금/출금 : 4.종료");
			System.out.println("-------------------------------");
			System.out.print("선택> ");
			int menuNum1 = Integer.parseInt(scan.nextLine());
			
			switch (menuNum1){
			case 1:
				System.out.println("로그인 처리");
				System.out.print("아이디: ");
				String id = scan.nextLine();
				System.out.print("패스워드: ");
				String strPassword = scan.nextLine();
				int password = Integer.parseInt(strPassword);
				if(id.equals("java")) {
					if(password == 12345) {
						System.out.println("로그인 성공");
					}else {
						System.out.println("로그인 실패:패스워드가 틀림");
					}
				}else {
					System.out.println("로그인 실패:아이디가 존재하지 않음");
				}
				break;
			case 2:
				System.out.println("회원 가입");
				System.out.println("[필수 정보 입력]");
				System.out.print("1. 이름: ");
				String name = scan.nextLine();
				System.out.print("2. 주민번호 앞 6자리: ");
				String num = scan.nextLine();
				System.out.print("3. 전화번호: ");
				String pnum = scan.nextLine();
				System.out.println();
				System.out.println("[입력된 내용]");
				System.out.println("이름: "+name);
				System.out.println("주민번호 앞 6자리: "+num);
				System.out.println("전화번호: "+pnum);
				
				break;
			case 3:
				int balance = 0;
				while(run2) {
					System.out.println("-------------------------------");
					System.out.println("1.예금 : 2.출금 : 3.잔고 : 4.종료");
					System.out.println("-------------------------------");
					System.out.print("선택> ");
					int menuNum3 = Integer.parseInt(scan.nextLine());
					switch (menuNum3) {
					case 1:
						System.out.print("예금액> ");
						balance += Integer.parseInt(scan.nextLine());
						break;
					case 2:
						System.out.print("출금액> ");
						balance -= Integer.parseInt(scan.nextLine());
						break;
					case 3:
						System.out.printf("잔고> %d\n",balance);
						break;
					case 4:
						run2 = false;
						break;	
					}
					System.out.println();
				}
				System.out.println("예금/출금 프로그램 종료");
				break;
			case 4:
				run = false;
				break;
							
			}
				
		}		
		
		System.out.println("프로그램 전체 종료");		
	}	
}

