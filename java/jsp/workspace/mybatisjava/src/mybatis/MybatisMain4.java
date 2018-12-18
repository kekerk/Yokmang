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
//		List<Comment> list = session.getMapper(CommentMapper3.class).select(); //������ ������̼� Ȯ�� ����.
		List<Comment> list = session.selectList(ns+"select"); //�������̽� ���� select�� ����
		for(Comment c : list) System.out.println(c);
		
		System.out.println("interface�� ����Ͽ� insert �ϱ�");
		Comment comment = new Comment(7,"test7","comment 7 �������̽��� �߰�",new Date());
		int result = session.getMapper(CommentMapper3.class).insert(comment);
		list = session.selectList(ns+"select");
		System.out.println(result + "�� �߰���.");
		for(Comment c : list) {
			System.out.println(c);
		}
		
		System.out.println("interface�� ����Ͽ� update �ϱ�");
		comment = new Comment(7,"test7","comment 7 �������̽��� ����",new Date());
		result = session.getMapper(CommentMapper3.class).update(comment);
		list = session.selectList(ns+"select");
		System.out.println(result + "�� ������.");
		for(Comment c : list) {
			System.out.println(c);
		}
		
		System.out.println("interface�� ����Ͽ� delete �ϱ�");
		result = session.getMapper(CommentMapper3.class).delete(7);
		System.out.println(result + "�� ������.");
		list = session.selectList(ns+"select");
		for(Comment c : list) {
			System.out.println(c);
		}
		}
	}


