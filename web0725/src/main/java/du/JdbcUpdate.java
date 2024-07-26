package du;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JdbcUpdate
 */
@WebServlet("/update.do")
public class JdbcUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JdbcUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dname1 = request.getParameter("dname");
		System.out.println(dname1);
		String loc1 = request.getParameter("loc");
		System.out.println(loc1);
		int deptno1 = 0; // 기본 값으로 초기화
		
		 
		// deptno 파라미터 처리
        String deptnoParam = request.getParameter("deptno");
        if (deptnoParam != null && !deptnoParam.isEmpty()) {
            try {
                deptno1 = Integer.parseInt(deptnoParam);
            } catch (NumberFormatException e) {
                e.printStackTrace(); // 예외 처리
                return; // 예외 발생 시 처리 중단
            }
        } else {
            // deptnoParam이 null이거나 비어 있을 경우 처리
            // 예를 들어, 오류 메시지 출력 등
            return; // 처리 중단
        }
		
		response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();
		out.println("<h1>서블릿 페이지</h1>");
		
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="update dept set dname = ?, loc = ? where deptno = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩!");
			conn = DriverManager.getConnection(URL, "root" , "mysql");
			System.out.println("Mysql 접속 성공!");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname1);
			pstmt.setString(2, loc1);
			pstmt.setInt(3, deptno1);
			int ret = pstmt.executeUpdate();
			out.println(ret + "건 update 성공!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
