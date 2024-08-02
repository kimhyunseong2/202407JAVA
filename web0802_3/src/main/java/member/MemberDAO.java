package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBCUtil;

public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private String MEMBER_LOGIN = "select * from member where id=? and pw=?";
	
	public MemberDTO getSelect(String id, String pw, String name){
		MemberDTO dto = null;
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(MEMBER_LOGIN);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			rs = stmt.executeQuery();
			if (rs.next()) {
				dto = new MemberDTO(rs.getString(id),rs.getString(pw), rs.getString(name));
                dto.setId(rs.getString("id"));
                dto.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return dto;
	}
}
