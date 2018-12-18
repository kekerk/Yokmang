package model;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/*  DB연동  */
public class DBConnection {
	private static SqlSessionFactory sqlMap;
	static {
		String resource = "mapper/mybatis-config.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		}catch(IOException e) {
			e.printStackTrace();
		}
		sqlMap = new SqlSessionFactoryBuilder().build(reader);
	}
	private DBConnection() {} //생성자. 객체 생성 불가.
	static SqlSession getSession() {
		return sqlMap.openSession();
	}
	static void close(SqlSession session) {
	session.commit();
	session.close();
	}
}
