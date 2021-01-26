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
		//生成连接对象
		Connection conn=DriverManager.getConnection(url,user,password);
		//创建一条语句
		PreparedStatement ps=conn.prepareStatement("update Student set StudentNO=?,LoginPwd=?,StudentName=?,Sex=? where Phone=?");
		//填坑更新
		ps.setString(1,"S1101001");
		ps.setString(2,"228996245");
		ps.setString(3, "金蝶");
		ps.setString(4, "男");
		ps.setString(5,"717215147");
		int rows=ps.executeUpdate();
		System.out.println("更新了"+rows+"条记录");
		conn.close();
	}
}
