package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

	public static void main(String[] args) throws SQLException {
		//1.ע��MySQL���ݿ���������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		System.out.println("ע�����ݿ������ɹ�");
		} catch (ClassNotFoundException e) {
			System.out.println("ע�����ݿ�����ʧ��");
		}
		String url="jdbc:mysql://localhost:3306/mysql_week11?useUnicode=true&characterEncoding=utf-8";
		String user="root";
		String password="990827";
		//2.�������Ӷ���
		Connection conn=DriverManager.getConnection(url,user,password);
		//3.����һ�����
		Statement st=conn.createStatement();
		//4.ִ�����
		ResultSet rs=st.executeQuery("select * from student");
		//5.����rs�����ÿһ������
		while(rs.next()){
			System.out.println("ѧ�ţ�"+rs.getString(1));
			System.out.println("������"+rs.getString(3));
			System.out.println("�Ա�"+rs.getString(4));
			System.out.println("��ַ��"+rs.getString(7));
			System.out.println("emile��"+rs.getString(9));
			System.out.println("��������������������������������������������");
		}
	}
}
