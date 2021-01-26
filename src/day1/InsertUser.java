package day1;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class InsertUser extends JFrame{
	private static final long serialVersionUID = 1L;
	JTextField tfID,tfName,tfPwd;//���������ı���
	JButton btnInsert,btnClose;//����������ť
	public InsertUser(){//����һ��������
		super("�����û�");
		this.setSize(300,120);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);//��ֹ��ק
		JPanel panel1=new JPanel();//������������swing����;
		panel1.setLayout(new GridLayout(3,2));//���ò��֣��������С�
		JLabel labID,labName,labPwd;//����������ť
		labID=new JLabel("UserID:");
		labName=new JLabel("�û���");
		labPwd=new JLabel("����");
		tfID=new JTextField(10);
		tfName=new JTextField(10);
		tfPwd=new JTextField(10);
		panel1.add(labID);
		panel1.add(tfID);
		panel1.add(labName);
		panel1.add(tfName);
		panel1.add(labPwd);
		panel1.add(tfPwd);
		this.setVisible(true);
		Container c=this.getContentPane();
		JPanel panel2=new JPanel();
		btnInsert=new JButton("����");
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//1.�ȵõ������е������ı����ֵ
				String id=tfID.getText();
				String name=tfName.getText();
				String pwd=tfPwd.getText();
				if(id==null||id.equals("")){JOptionPane.showMessageDialog(null,"ID����Ϊ��");
				return;
				}
				if(name==null||name.equals("")){JOptionPane.showMessageDialog(null,"name����Ϊ��");
				return;
				}
				if(pwd==null||pwd.equals("")){JOptionPane.showMessageDialog(null,"password����Ϊ��");
				return;
				}
				String url="jdbc:mysql://localhost:3306/mysql_week11?useUnicode=true&characterEncoding=utf-8";
				String user="root";
				String password="990827";
				//1.�������ݿ�,ע������
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection(url,user,password);//������!���ɺ�ϰ�߹ر�����
					Statement st=conn.createStatement();
					int rows=st.executeUpdate("insert into student Values('"+id+"','"+name+"','"+pwd+"')");//ִ�и������
					if(rows==1)JOptionPane.showMessageDialog(null, "�����û��ɹ�");
					conn.close();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
		});
		btnClose=new JButton("�ر�");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);������ϵͳ�ر�;
				//InsertUser.this.setVisible(false);�������岻�ɼ�
				InsertUser.this.dispose();//dispose();���䴰�ڹرա�
			}
		});
		panel2.add(btnInsert);
		panel2.add(btnClose);
		c.add(panel1,BorderLayout.CENTER);
		c.add(panel2,BorderLayout.SOUTH);
	}
	public static void main(String[] args) {
		new InsertUser();
	}
}
