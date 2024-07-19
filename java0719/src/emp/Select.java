package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

	public static void main(String[] args) {
		String sql = "select * from emp";
		
		String URL = "jdbc:mysql://localhost:3309/spring5fs";
		Connection con = null;
		java.sql.Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("Mysql 접속 성공!");
			stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
