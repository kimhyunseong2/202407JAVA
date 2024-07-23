package thread3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ViewDept extends JFrame{
	JTextField tf = new JTextField(20);
	JButton jb = new JButton("조회");
	JTextArea ta = new JTextArea(15,45);
	Connection conn;
	Statement stmt;
	ViewDept(){
//		JPanel jp3 = new JPanel();
//		JLabel lb1 = new JLabel("test");
//		jp3.add(lb1);
//		Thread thread = new Thread(new Time());
//		thread.start();
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
		
		Time time = new Time();
		Thread thread = new Thread(time);
		thread.start();
		con.add(time, BorderLayout.SOUTH);
		
		
		this.setTitle("view dept 테이블");
		this.setBounds(1000, 200, 600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "select deptno, dname, loc from dept";
				
				try {
					ResultSet rs = stmt.executeQuery(sql);
					ta.setText("");
					while (rs.next()) {
						int deptno = rs.getInt("deptno");
						String dname = rs.getString("dname");
						String loc = rs.getString("loc");
						
						ta.append(String.format("%d %s %s\n", deptno,dname,loc));
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
	
	
	
	public static void main(String[] ar) {
		
		new ViewDept();
		
	}
	
//	class MyPanel extends JPanel {
//		JLabel lb1;
//		
//		MyPanel() {
//			lb1 = new JLabel();
//			this.add(lb1);
//		}
//		
//	}
	
	public class Time extends JPanel implements Runnable{
		JLabel lb1;
		
		Time() {
			lb1 = new JLabel();
			this.add(lb1);
		}
		@Override
		public void run() {
			for (;;) {
			LocalTime localtime = LocalTime.now();
			String str = String.format("%d:%d:%d\n",
					localtime.getHour(),localtime.getMinute(),localtime.getSecond());
				lb1.setText(str);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		}
	}

}
