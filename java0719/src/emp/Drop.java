package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Drop {

	public static void main(String[] args) {
String createString = "drop table emp";
		
		String URL = "jdbc:mysql://localhost:3309/spring5fs";
		Connection con = null;
		java.sql.Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("Mysql 접속 성공!");
			stmt = con.createStatement();
			int num = stmt.executeUpdate(createString);
			System.out.println("테이블 삭제!" + num);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
