package project1;

import java.io.Serializable;

public class Member implements Serializable {
	String name;
	String num; // 주민번호 6자리 패스워드
	String pnum;
	int balance;
	
	

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
	
	

}
