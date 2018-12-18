package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.CommentMapper3;

public class MybatisMain4 {
	private final static String ns = "mapper.CommentMapper3.";
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
//		List<Comment> list = session.getMapper(CommentMapper3.class).select(); //구문에 어노테이션 확인 가능.
		List<Comment> list = session.selectList(ns+"select"); //인터페이스 안의 select를 실행
		for(Comment c : list) System.out.println(c);
		
		System.out.println("interface를 사용하여 insert 하기");
		Comment comment = new Comment(7,"test7","comment 7 인터페이스로 추가",new Date());
		int result = session.getMapper(CommentMapper3.class).insert(comment);
		list = session.selectList(ns+"select");
		System.out.println(result + "건 추가됨.");
		for(Comment c : list) {
			System.out.println(c);
		}
		
		System.out.println("interface를 사용하여 update 하기");
		comment = new Comment(7,"test7","comment 7 인터페이스로 변경",new Date());
		result = session.getMapper(CommentMapper3.class).update(comment);
		list = session.selectList(ns+"select");
		System.out.println(result + "건 수정됨.");
		for(Comment c : list) {
			System.out.println(c);
		}
		
		System.out.println("interface를 사용하여 delete 하기");
		result = session.getMapper(CommentMapper3.class).delete(7);
		System.out.println(result + "건 삭제됨.");
		list = session.selectList(ns+"select");
		for(Comment c : list) {
			System.out.println(c);
		}
		}
	}


