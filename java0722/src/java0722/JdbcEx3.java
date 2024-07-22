package java0722;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx3 {

	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		Statement stmt = null;
		String sql = "insert into dept(deptno, dname, loc) values (102, '총무부', '인천'),(103, '인사부', '부산'),"
				+ "(104, '회계부', '성남')";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			System.out.println("접속성공!!");
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("쿼리 성공!");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
