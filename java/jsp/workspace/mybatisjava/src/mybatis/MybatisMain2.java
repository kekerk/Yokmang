package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisMain2 {
	private final static String ns = "comment2.";//변경 x
	private static SqlSessionFactory sqlMap;
	static { //static 초기화 블럭 : 클래스 변수의 초기화 담당. main method 이전에 생성.
		InputStream input = null; //외부의 데이터를 읽어오는 담당.
		try {
			input = Resources.getResourceAsStream("mapper/mybatis-config.xml");
		}catch(IOException e) {
			e.printStackTrace();
		}
		sqlMap=new SqlSessionFactoryBuilder().build(input); //내용들을 sqlMap에 저장.
	}
	public static void main(String[] args) {
		// 인스턴스 초기화 블럭으로 하면 객체 생성 해야한다.
		
		SqlSession session = sqlMap.openSession();
		System.out.println("===전체 레코드 조회하기===");
		List<Comment> list = session.selectList(ns+"selectByCondition");
		for(Comment c : list) {
			System.out.println(c);
		}
		/* ------------------------------------------------------------------------------------------------------- */		
		Map<String,Object> map = new HashMap<String,Object>();
		int num=1;
		System.out.println("\n===no:" +num+"레코드 조회하기===");
		map.put("no", num);
		Comment comment = session.selectOne(ns+"selectByCondition",map);
		System.out.println(comment);
		/* ------------------------------------------------------------------------------------------------------- */		
		String id = "3";
		System.out.println("\n===id:"+id+" 포함하는 레코드 조회하기===");
		map.clear();
		map.put("id",id);
		list =  session.selectList(ns+"selectByCondition", map);
		for(Comment c : list) {
			System.out.println(c);
		}
		/* ------------------------------------------------------------------------------------------------------- */
		String content = "4";
		System.out.println("\n==== content :"+content+"문자 포함하는 레코드 조회하기====");
		map.clear();
		map.put("content", content);
		list = session.selectList(ns+"selectByCondition",map);
		for(Comment c : list) {
			System.out.println(c);
		}
		/* ------------------------------------------------------------------------------------------------------- */
		System.out.println("\n==== selectByChoose 구문 연습====");
		list = session.selectList(ns+"selectByChoose");
		for(Comment c : list) {
			System.out.println(c);
		}
		/* ------------------------------------------------------------------------------------------------------- */
		System.out.println("\n==== selectByChoose 구문 연습 -> no=3====");
		map.clear();
		map.put("no", 3);
		list = session.selectList(ns+"selectByChoose",map);
		for(Comment c : list) {
			System.out.println(c);
		}
		/* ------------------------------------------------------------------------------------------------------- */
		System.out.println("\n==== selectByChoose 구문 연습 -> id=4====");
		map.clear();
		map.put("id", "4");
		list = session.selectList(ns+"selectByChoose",map);
		for(Comment c : list) {
			System.out.println(c);
		}
		/* ------------------------------------------------------------------------------------------------------- */
		System.out.println("\n==== selectByChoose 구문 연습 -> no=4,id=test====");
		map.clear();
		map.put("no", 3);
		map.put("id", "test");
		list = session.selectList(ns+"selectByChoose",map);
		for(Comment c : list) {
			System.out.println(c);
		}
	}
}
