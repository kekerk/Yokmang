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
	private final static String ns = "comment2.";//���� x
	private static SqlSessionFactory sqlMap;
	static { //static �ʱ�ȭ �� : Ŭ���� ������ �ʱ�ȭ ���. main method ������ ����.
		InputStream input = null; //�ܺ��� �����͸� �о���� ���.
		try {
			input = Resources.getResourceAsStream("mapper/mybatis-config.xml");
		}catch(IOException e) {
			e.printStackTrace();
		}
		sqlMap=new SqlSessionFactoryBuilder().build(input); //������� sqlMap�� ����.
	}
	public static void main(String[] args) {
		// �ν��Ͻ� �ʱ�ȭ ������ �ϸ� ��ü ���� �ؾ��Ѵ�.
		
		SqlSession session = sqlMap.openSession();
		System.out.println("===��ü ���ڵ� ��ȸ�ϱ�===");
		List<Comment> list = session.selectList(ns+"selectByCondition");
		for(Comment c : list) {
			System.out.println(c);
		}
		/* ------------------------------------------------------------------------------------------------------- */		
		Map<String,Object> map = new HashMap<String,Object>();
		int num=1;
		System.out.println("\n===no:" +num+"���ڵ� ��ȸ�ϱ�===");
		map.put("no", num);
		Comment comment = session.selectOne(ns+"selectByCondition",map);
		System.out.println(comment);
		/* ------------------------------------------------------------------------------------------------------- */		
		String id = "3";
		System.out.println("\n===id:"+id+" �����ϴ� ���ڵ� ��ȸ�ϱ�===");
		map.clear();
		map.put("id",id);
		list =  session.selectList(ns+"selectByCondition", map);
		for(Comment c : list) {
			System.out.println(c);
		}
		/* ------------------------------------------------------------------------------------------------------- */
		String content = "4";
		System.out.println("\n==== content :"+content+"���� �����ϴ� ���ڵ� ��ȸ�ϱ�====");
		map.clear();
		map.put("content", content);
		list = session.selectList(ns+"selectByCondition",map);
		for(Comment c : list) {
			System.out.println(c);
		}
		/* ------------------------------------------------------------------------------------------------------- */
		System.out.println("\n==== selectByChoose ���� ����====");
		list = session.selectList(ns+"selectByChoose");
		for(Comment c : list) {
			System.out.println(c);
		}
		/* ------------------------------------------------------------------------------------------------------- */
		System.out.println("\n==== selectByChoose ���� ���� -> no=3====");
		map.clear();
		map.put("no", 3);
		list = session.selectList(ns+"selectByChoose",map);
		for(Comment c : list) {
			System.out.println(c);
		}
		/* ------------------------------------------------------------------------------------------------------- */
		System.out.println("\n==== selectByChoose ���� ���� -> id=4====");
		map.clear();
		map.put("id", "4");
		list = session.selectList(ns+"selectByChoose",map);
		for(Comment c : list) {
			System.out.println(c);
		}
		/* ------------------------------------------------------------------------------------------------------- */
		System.out.println("\n==== selectByChoose ���� ���� -> no=4,id=test====");
		map.clear();
		map.put("no", 3);
		map.put("id", "test");
		list = session.selectList(ns+"selectByChoose",map);
		for(Comment c : list) {
			System.out.println(c);
		}
	}
}
