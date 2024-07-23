package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ViewDept2 extends JFrame{
	JTextField tf = new JTextField(20);
	JButton jb = new JButton("조회");
	JTextArea ta = new JTextArea(15,45);
	Connection conn;
	Statement stmt;
	JFrame jf;
	ViewDept2(){
		jf = this;
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			stmt = conn.createStatement();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		JPanel jp1 = new JPanel(new FlowLayout());
		jp1.add(tf); jp1.add(jb);
		con.add(jp1, BorderLayout.NORTH);
		JPanel jp2 = new JPanel(new FlowLayout());
		jp2.add(ta); 
		con.add(jp2, BorderLayout.CENTER);
		
		
		this.setTitle("select 문장을 넣으세요");
		this.setBounds(1000, 200, 600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = tf.getText();
				
				try {
					 ResultSet rs = stmt.executeQuery(sql);

			            ResultSetMetaData rsmd = rs.getMetaData();
			            int columnsNumber = rsmd.getColumnCount();
			            ta.setText("");
			            while (rs.next()) {
			                for (int i = 1; i <= columnsNumber; i++) {
			                    if (i > 1) ta.append(",  ");
			                    String columnValue = rs.getString(i);
			                    ta.append(rsmd.getColumnName(i) + ": " + columnValue);
			                }
			                ta.append("\n");
			            }
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(jf, "해당 자료없습니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
					e1.printStackTrace();
				}
				
			}
		});
	}
	
	
	
	public static void main(String[] ar) {
		new ViewDept2();
	}
}
