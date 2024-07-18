package project2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import project2.Member;

public class MyFrame extends JFrame{
	JLabel la1 = new JLabel("아이디");
	JLabel la2 = new JLabel("패스워드");
	JLabel la3 = new JLabel("전화번호");
	JTextField tf1 = new JTextField(8);
	JTextField tf2 = new JTextField(8);
	JTextField tf3 = new JTextField(8);
	JTextArea ta = new JTextArea(15,40);
	JButton bt1 = new JButton("로그인");
	JButton bt2 = new JButton("회원가입");
	JButton bt3 = new JButton("예금");
	JButton bt4 = new JButton("출금");
	JButton bt5 = new JButton("잔고");
	List<Member> list ; // = new ArrayList<>();
	Member member ; //로그인 된 현재 사용자
	
		MyFrame() {
			
			try (FileInputStream fis = new FileInputStream("c:\\temp\\members.dat");
					ObjectInputStream ois = new ObjectInputStream(fis)){
				Member[]list2 = (Member[]) ois.readObject();
				list = new ArrayList<>(Arrays.asList(list2)); //배열을 ArrayList로

				System.out.println("파일에서 객체를 가져왔습니다.");

			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			for (Member member : list) {
				
					System.out.println(member);
				
			}

			System.out.println("총회원수:"+list.size());

				
		
		JPanel jp1 = new JPanel();
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add(jp1, BorderLayout.NORTH);
		jp1.setLayout(new FlowLayout());
		jp1.add(la1);
		jp1.add(tf1);
		jp1.add(la2);
		jp1.add(tf2);
		jp1.add(la3);
		jp1.add(tf3);
		
		JPanel jp2 = new JPanel();
		con.add(jp2, BorderLayout.CENTER);
		jp2.setLayout(new FlowLayout());
		jp2.add(ta);
		
		JPanel jp3 = new JPanel();
		con.add(jp3, BorderLayout.SOUTH);
		jp3.setLayout(new FlowLayout());
		jp3.add(bt1);
		

		jp3.add(bt2);
		jp3.add(bt3);
		jp3.add(bt4);
		jp3.add(bt5);
		
		this.setBounds(1200, 200, 600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = tf1.getText();
				String strPassword = tf2.getText();
				for(Member member2 : list) {
					if(member2.getName().equals(id) && member2.getNum().equals(strPassword)) {
						member = member2;
						ta.setText("로그인성공!\n" + String.valueOf(member));
						break;
					
					}else {
						ta.setText("로그인실패 다시입력하세요!\n" + String.valueOf(member));
					}
				}
				
				
			}
		});
		bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		bt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		bt4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		bt5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		this.addWindowListener((WindowListener) new JFrameWindowClosingEventHandler());
	}
		class JFrameWindowClosingEventHandler extends WindowAdapter {
			
			@Override
			public void windowClosing(WindowEvent e) {
				// 파일 저장 위치
				
				
				JFrame frame = (JFrame)e.getWindow();
				frame.dispose();
				System.out.println("windowClosing()");
			}
		}
		
	
	
	public static void main(String[] ar) {
		new MyFrame();
	}
}
