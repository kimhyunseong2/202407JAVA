package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Insert {

	public static void main(String[] args) {
		String createString = "insert into emp values(7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300, NULL, 10)";
		
		String URL = "jdbc:mysql://localhost:3309/spring5fs";
		Connection con = null;
		java.sql.Statement stmt = null;
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
