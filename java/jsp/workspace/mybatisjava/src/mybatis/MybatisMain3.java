package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisMain3 {
	private final static String ns = "comment2.";
	private static SqlSessionFactory sqlMap;
	static {
		InputStream input = null;
		try {
			input = Resources.getResourceAsStream("mapper/mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlMap = new SqlSessionFactoryBuilder().build(input);
	}

	public static void main(String[] args) {
		SqlSession session = sqlMap.openSession();
		System.out.println("\n동적 태그 trim 연습");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", 1);
		map.put("id", "test");
		List<Comment> list = session.selectList(ns + "selectByTrim", map);
		for (Comment c : list) {
			System.out.println(c);
		}
		System.out.println("동적 태그 foreach 연습");
		List<String> idlist = new ArrayList<String>();
		map.clear();
		idlist.add("test1");
		idlist.add("test4");
		map.put("column", "id");
		map.put("ids", idlist);
		list = session.selectList(ns+"selectByforeach",map);
		for(Comment c : list) {
			System.out.println(c);
		}
	}
}
