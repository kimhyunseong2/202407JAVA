package dept;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class Swing extends JFrame{
	JLabel la1 = new JLabel("테이블 이름");
	JTextField tf1 = new JTextField(8);
	JTextArea ta = new JTextArea(15,40);
	JButton bt1 = new JButton("dept검색");
	JButton bt2 = new JButton("emp검색");
	
	Swing(){
		JPanel jp1 = new JPanel();
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add(jp1, BorderLayout.NORTH);
		jp1.setLayout(new FlowLayout());
		jp1.add(la1);
		jp1.add(tf1);
		
		JPanel jp2 = new JPanel();
		con.add(jp2, BorderLayout.CENTER);
		jp2.setLayout(new FlowLayout());
		jp2.add(ta);
		
		JPanel jp3 = new JPanel();
		con.add(jp3, BorderLayout.SOUTH);
		jp3.setLayout(new FlowLayout());
		jp3.add(bt1);
		jp3.add(bt2);
		
		
	
		this.setBounds(1200, 200, 800, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bt1.addActionListener(e -> {
            fetchDeptData();
            tf1.setText("dept");
        });
    }

    private void fetchDeptData() {
        String URL = "jdbc:mysql://localhost:3309/spring5fs";
        String username = "spring5";
        String password = "spring5";
        String sql = "SELECT * FROM dept";

        try (Connection con = DriverManager.getConnection(URL, username, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                int deptNo = rs.getInt("Deptno");
                String dname = rs.getString("Dname");
                String loc = rs.getString("Loc");

                sb.append("Dept No: ").append(deptNo).append(", ");
                sb.append("Dept Name: ").append(dname).append(", ");
                sb.append("Location: ").append(loc).append("\n\n");
            }

            ta.setText(sb.toString()); // Set text in JTextArea

        } catch (SQLException ex) {
            ex.printStackTrace();
            ta.setText("Error fetching data: " + ex.getMessage());
        }
    
        bt2.addActionListener(e -> {
            fetchEmpData();
            tf1.setText("emp");
        });
    }

    private void fetchEmpData() {
        String URL = "jdbc:mysql://localhost:3309/spring5fs";
        String username = "spring5";
        String password = "spring5";
        String sql = "SELECT * FROM emp";

        try (Connection con = DriverManager.getConnection(URL, username, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                int empNo = rs.getInt("Empno");
                String eName = rs.getString("Ename");
                String job = rs.getString("Job");
                int mgr = rs.getInt("Mgr");
                Date hireDate = rs.getDate("Hiredate");
                int sal = rs.getInt("Sal");
                int comm = rs.getInt("COMM");
                int deptNo = rs.getInt("DEPTNO");

                sb.append("Emp No: ").append(empNo).append(", ");
                sb.append("Emp Name: ").append(eName).append(", ");
                sb.append("Job: ").append(job).append(", ");
                sb.append("Mgr: ").append(mgr).append(", ");
                sb.append("Hire Date: ").append(hireDate).append(", ");
                sb.append("Salary: ").append(sal).append(", ");
                sb.append("Commission: ").append(comm).append(", ");
                sb.append("Dept No: ").append(deptNo).append("\n\n");
            }

            ta.setText(sb.toString()); // Set text in JTextArea

        } catch (SQLException ex) {
            ex.printStackTrace();
            ta.setText("Error fetching data: " + ex.getMessage());
        }
    }
	public static void main(String[] args) {
		new Swing();
	}

}
