package mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisMain1 {
	public static void main(String[] args) {
		SqlSessionFactory sqlMap = null; //sql 실행 문장?
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("mapper/mybatis-config.xml"); //
			sqlMap = new SqlSessionFactoryBuilder().build(reader); //
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		int x=0;
		// jdbc 실행 권한 객체.
		SqlSession session = sqlMap.openSession();
		x = (Integer) session.selectOne("comment.count"); //session.selectOne : 조회되는 레코드가 한개인 경우
		System.out.println("comment 테이블의 레코드 갯수 : "+ x);
		System.out.println("\ncomment 테이블의 전체 데이터는 아래에 출력");
		List<Comment> list = session.selectList("comment.list"); //session.selectList : 조회되는 레코드가 여러 개인 경우
		for(Comment c : list ) {
			System.out.println(c);
		}
		System.out.println("\ncomment 테이블에 레코드 추가하기");
		Comment comment = new Comment(6,"test6","comment 6",new Date());
		session.insert("comment.insert",comment);
		commentlist(session);
		
		System.out.println("\ncomment 테이블에 레코드 수정하기");
		comment = new Comment(6,"test6","comment 666666", null);
		session.update("comment.update",comment);
		commentlist(session);
		
		System.out.println("\ncomment 테이블에 5번 레코드만 조회하기");
		comment = session.selectOne("comment.selectone",5);
		System.out.println(comment);
		
		System.out.println("\ncomment 테이블에 id가 test3인 레코드만 조회하기");
		comment = session.selectOne("comment.selectoneid","test3");
		System.out.println(comment);
		
		System.out.println("\ncomment 테이블에 id가 test4를 포함한 레코드 목록 조회하기");
		list= session.selectList("comment.selectid","test4");
		for(Comment c : list) {
			System.out.println(c);
		}
		System.out.println("\n동적으로 컬럼 조회하기");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("column", "no");
		map.put("value", "1");
		list = session.selectList("comment.selectcolumn",map);
		for(Comment c : list) {
			System.out.println(c);
		}
	}
	
	private static void commentlist(SqlSession session) {
		List<Comment> list = session.selectList("comment.list");
		for(Comment c : list) {
			System.out.println(c);
		}
	}
}
