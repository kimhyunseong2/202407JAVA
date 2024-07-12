package project1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class project {

	public static void main(String[] args) {
//		Member[] list = null;
		Member[] list = new Member[10]; // 총 회원수 10명으로 제한
		int memCnt = 0; //회원수
		try (FileInputStream fis = new FileInputStream("c:\\temp\\members.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			Member[] list2 = (Member[]) ois.readObject();
			System.arraycopy(list2, 0, list, 0, list2.length);
			System.out.println("파일에서 객체를 가져왔습니다.");

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		for (Member member : list) {
			if(member != null) {
				System.out.println(member);
				++memCnt;
			}
			
		}
		System.out.println("총회원수:"+memCnt);
		
		Member member = null; //로그인 된 현재 사용자
		boolean run = true;
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
				int find = -1; // 찾기 전 또는 못찾았을 때 
				
				for (int i = 0; i < list.length; i++) {
					if (list[i].name.equals(id) && list[i].num.equals(strPassword)) {
						find = i;
						member = list[i];
						break;
					}
				}
				System.out.println("인덱스:"+find);
				System.out.println(member);
//				if(id.equals(member.name)) {
//					if(strPassword.equals(member.num)) {
//						System.out.println("로그인 성공");
//					}else {
//						System.out.println("로그인 실패:패스워드가 틀림");
//					}
//				}else {
//					System.out.println("로그인 실패:아이디가 존재하지 않음");
//				}
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
				list[memCnt++] = new Member(name, num, pnum); // 객체 생성
				
				break;
			case 3:
				boolean run2 = true;
				while(run2) {
					System.out.println("-------------------------------");
					System.out.println("1.예금 : 2.출금 : 3.잔고 : 4.종료");
					System.out.println("-------------------------------");
					System.out.print("선택> ");
					int menuNum3 = Integer.parseInt(scan.nextLine());
					switch (menuNum3) {
					
					case 1:
						System.out.print("예금액> ");
						member.balance += Integer.parseInt(scan.nextLine());
						break;
					case 2:
						System.out.print("출금액> ");
						member.balance -= Integer.parseInt(scan.nextLine());
						break;
					case 3:
						System.out.printf("잔고> %d\n",member.balance);
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
				try (FileOutputStream fos = new FileOutputStream("c:\\temp\\members.dat");
						ObjectOutputStream oos = new ObjectOutputStream(fos)){
					
					oos.writeObject(list);
					System.out.println("객체를 파일에 저장했습니다.");
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}

				run = false;
				break;
							
			}
				
		}		
		
		System.out.println("프로그램 전체 종료");		
	}	
}

