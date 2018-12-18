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
		SqlSessionFactory sqlMap = null; //sql ���� ����?
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("mapper/mybatis-config.xml"); //
			sqlMap = new SqlSessionFactoryBuilder().build(reader); //
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		int x=0;
		// jdbc ���� ���� ��ü.
		SqlSession session = sqlMap.openSession();
		x = (Integer) session.selectOne("comment.count"); //session.selectOne : ��ȸ�Ǵ� ���ڵ尡 �Ѱ��� ���
		System.out.println("comment ���̺��� ���ڵ� ���� : "+ x);
		System.out.println("\ncomment ���̺��� ��ü �����ʹ� �Ʒ��� ���");
		List<Comment> list = session.selectList("comment.list"); //session.selectList : ��ȸ�Ǵ� ���ڵ尡 ���� ���� ���
		for(Comment c : list ) {
			System.out.println(c);
		}
		System.out.println("\ncomment ���̺� ���ڵ� �߰��ϱ�");
		Comment comment = new Comment(6,"test6","comment 6",new Date());
		session.insert("comment.insert",comment);
		commentlist(session);
		
		System.out.println("\ncomment ���̺� ���ڵ� �����ϱ�");
		comment = new Comment(6,"test6","comment 666666", null);
		session.update("comment.update",comment);
		commentlist(session);
		
		System.out.println("\ncomment ���̺� 5�� ���ڵ常 ��ȸ�ϱ�");
		comment = session.selectOne("comment.selectone",5);
		System.out.println(comment);
		
		System.out.println("\ncomment ���̺� id�� test3�� ���ڵ常 ��ȸ�ϱ�");
		comment = session.selectOne("comment.selectoneid","test3");
		System.out.println(comment);
		
		System.out.println("\ncomment ���̺� id�� test4�� ������ ���ڵ� ��� ��ȸ�ϱ�");
		list= session.selectList("comment.selectid","test4");
		for(Comment c : list) {
			System.out.println(c);
		}
		System.out.println("\n�������� �÷� ��ȸ�ϱ�");
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
