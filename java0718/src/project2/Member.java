package project2;
import java.io.Serializable;

public class Member implements Serializable {
	private String name;
	private String num; // 주민번호 6자리 패스워드
	private String pnum;
	private int balance;
	
	//입금
	public void deposit(int deposit) {
		if(deposit <= 0) {
			System.out.println("금액을 정확히 입력하세요");
			return;
		}
		balance += deposit;
	}
	
	public void withdraw(int withdraw) {
		if(withdraw > balance) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		if(withdraw <= 0) {
			System.out.println("0원 및 마이너스 단위는 출금할 수 없습니다.");
			return;
		}
		balance -= withdraw;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", num=" + num + ", pnum=" + pnum + ", balance=" + balance + "]";
	}


	public Member(String name, String num, String pnum) {
		super();
		this.name = name;
		this.num = num;
		this.pnum = pnum;
	}
	
	
	public Member() {}


	public String getName() {
		return name;
	}


	public String getNum() {
		return num;
	}


	public String getPnum() {
		return pnum;
	}


	public int getBalance() {
		return balance;
	}
	
	

}