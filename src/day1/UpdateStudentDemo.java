package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStudentDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mysql_week11?useUnicode=true&characterEncoding=utf-8";
		String user="root";
		String password="990827";
		//�������Ӷ���
		Connection conn=DriverManager.getConnection(url,user,password);
		//����һ�����
		PreparedStatement ps=conn.prepareStatement("update Student set StudentNO=?,LoginPwd=?,StudentName=?,Sex=? where Phone=?");
		//��Ӹ���
		ps.setString(1,"S1101001");
		ps.setString(2,"228996245");
		ps.setString(3, "���");
		ps.setString(4, "��");
		ps.setString(5,"717215147");
		int rows=ps.executeUpdate();
		System.out.println("������"+rows+"����¼");
		conn.close();
	}
}
