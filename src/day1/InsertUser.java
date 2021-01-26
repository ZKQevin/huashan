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
	JTextField tfID,tfName,tfPwd;//定义三个文本框
	JButton btnInsert,btnClose;//定义三个按钮
	public InsertUser(){//创建一个插入类
		super("插入用户");
		this.setSize(300,120);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);//禁止拖拽
		JPanel panel1=new JPanel();//轻量级容器，swing包中;
		panel1.setLayout(new GridLayout(3,2));//设置布局：三行两列。
		JLabel labID,labName,labPwd;//定义三个按钮
		labID=new JLabel("UserID:");
		labName=new JLabel("用户名");
		labPwd=new JLabel("密码");
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
		btnInsert=new JButton("插入");
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//1.先得到界面中的三个文本框的值
				String id=tfID.getText();
				String name=tfName.getText();
				String pwd=tfPwd.getText();
				if(id==null||id.equals("")){JOptionPane.showMessageDialog(null,"ID不能为空");
				return;
				}
				if(name==null||name.equals("")){JOptionPane.showMessageDialog(null,"name不能为空");
				return;
				}
				if(pwd==null||pwd.equals("")){JOptionPane.showMessageDialog(null,"password不能为空");
				return;
				}
				String url="jdbc:mysql://localhost:3306/mysql_week11?useUnicode=true&characterEncoding=utf-8";
				String user="root";
				String password="990827";
				//1.插入数据库,注册驱动
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection(url,user,password);//打开连接!养成好习惯关闭连接
					Statement st=conn.createStatement();
					int rows=st.executeUpdate("insert into student Values('"+id+"','"+name+"','"+pwd+"')");//执行更新语句
					if(rows==1)JOptionPane.showMessageDialog(null, "插入用户成功");
					conn.close();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
		});
		btnClose=new JButton("关闭");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);让整个系统关闭;
				//InsertUser.this.setVisible(false);让他窗体不可见
				InsertUser.this.dispose();//dispose();让其窗口关闭。
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
