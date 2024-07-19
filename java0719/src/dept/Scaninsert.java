package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Scaninsert {

	public static void main(String[] args) {
		int Deptno;
		String Dname,Loc;
		Scanner scan = new Scanner(System.in);
		System.out.print("테이블에 insert할 것을 입력> ");
		Deptno = scan.nextInt();
		Dname = scan.next();
		Loc = scan.next();
		String createString =String.format( "insert into dept(Deptno,Dname,Loc) values('%d','%s','%s')",Deptno,Dname,Loc);
		
		String URL = "jdbc:mysql://localhost:3309/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("Mysql 접속 성공!");
			stmt = con.createStatement();
			int num = stmt.executeUpdate(createString);
			
			System.out.println("테이블 삽입!"+num);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	}


