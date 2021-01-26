package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

	public static void main(String[] args) throws SQLException {
		//1.注册MySQL数据库驱动程序
		try {
			Class.forName("com.mysql.jdbc.Driver");
		System.out.println("注册数据库驱动成功");
		} catch (ClassNotFoundException e) {
			System.out.println("注册数据库驱动失败");
		}
		String url="jdbc:mysql://localhost:3306/mysql_week11?useUnicode=true&characterEncoding=utf-8";
		String user="root";
		String password="990827";
		//2.创建连接对象
		Connection conn=DriverManager.getConnection(url,user,password);
		//3.创建一条语句
		Statement st=conn.createStatement();
		//4.执行语句
		ResultSet rs=st.executeQuery("select * from student");
		//5.遍历rs，输出每一行数据
		while(rs.next()){
			System.out.println("学号："+rs.getString(1));
			System.out.println("姓名："+rs.getString(3));
			System.out.println("性别："+rs.getString(4));
			System.out.println("地址："+rs.getString(7));
			System.out.println("emile："+rs.getString(9));
			System.out.println("——————————————————————");
		}
	}
}
