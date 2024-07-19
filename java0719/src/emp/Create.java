package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {

	public static void main(String[] args) {
		String createString = "CREATE TABLE IF NOT EXISTS emp" +
				"(Empno int(11) not null," +
				"Ename varchar(10) default null ," +
				"Job varchar(9) default null," +
				"Mgr int(11) default null," +
				"Hiredate date default null," +
				"Sal int(11) default null," +
				"COMM int(11) DEFAULT NULL,"+
				"DEPTNO int(11) DEFAULT NULL)ENGINE=InnoDB DEFAULT CHARSET=utf8";
		
		String URL = "jdbc:mysql://localhost:3309/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("Mysql 접속 성공!");
			stmt = con.createStatement();
			int num = stmt.executeUpdate(createString);
			System.out.println("테이블 생성!" + num);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
