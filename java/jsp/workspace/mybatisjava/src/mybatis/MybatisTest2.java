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

/*
 *  student ���̺��� ������ ��ȸ�ϱ�
 *  1. �г⺰, ����, �а��� ��ȸ �����ϱ�. �� ��� ������ and��
 *  2. �г��� �����Ͽ� ��ȸ�ϱ�
 *  3. �а��� �����Ͽ� ��ȸ�ϱ�
 * 
 */
public class MybatisTest2 {
	private final static String ns = "student.";
	private static SqlSessionFactory sqlMap;
	static {
		InputStream input =null;
		try {
			input = Resources.getResourceAsStream("mapper/mybatis-config.xml");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		sqlMap=new SqlSessionFactoryBuilder().build(input);
	}
	
	public static void main(String[] args) {
		SqlSession session = sqlMap.openSession();
		System.out.println("���� ��ȸ");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("grade", 2);
		map.put("jumin", 1);
		map.put("major1", 102 );
		List<Student> list = session.selectList(ns+"selectByTrim",map);
		for(Student s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n�г� ���� ��ȸ");
		List<Integer> lists = new ArrayList<Integer>();
		map.clear();
		lists.add(1);
		lists.add(3);
		map.put("column", "grade");
		map.put("lists", lists);
		list = session.selectList(ns+"selectByforeach",map);
		for(Student s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n�а� ���� ��ȸ");
		map.clear();
		lists.add(101);
		lists.add(202);
		map.put("column", "major1");
		map.put("lists", lists);
		list = session.selectList(ns+"selectByforeach",map);
		for(Student s : list) {
			System.out.println(s);
		}
		
	
	
	}
	
}
