package mybatis;
/*
 * student ���̺��� ������ ��ȸ�ϱ�.
 * 1. ��ü �л� ��ȸ�ϱ�
 * 2. �г��� �������� ��ȸ�ϱ�
 * 3. ������ �������� ��ȸ�ϱ� => �ֹι�ȣ 7��° �ڸ��� (1,3) ���� (2,4) ����
 * 4. �а��� �������� ��ȸ�ϱ� 
 * 5. �й����� �л� �Ѹ� ��ȸ�ϱ�.
 * 
 * select ���� �ϳ��� �ؾ��Ѵ�.
 * namespace = student
 * select id="select"
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTest1 {
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
		System.out.println("===��ü ���ڵ� ��ȸ�ϱ�===");
		List<Student> list = session.selectList(ns+"select");
		for(Student s : list) System.out.println(s);
		
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println("\n===1�г� ���ڵ� ��ȸ�ϱ�===");
		map.put("grade", 1);
		list = session.selectList(ns+"select",map);
		for(Student s:list) System.out.println(s);
		
		System.out.println("\n===�а��� ���ڵ� ��ȸ�ϱ�===");
		map.clear();
		map.put("major1", 101);
		list = session.selectList(ns+"select",map);
		for(Student s:list) System.out.println(s);
		
		System.out.println("\n===�й��� �´� �л� ���ڵ� ��ȸ�ϱ�===");
		map.clear();
		map.put("studno", 960315);
		Student student = session.selectOne(ns+"select",map);
		System.out.println(student);
		
		System.out.println("\n===���л� ���ڵ� ��ȸ�ϱ�===");
		map.clear();
		map.put("jumin", 2);
		list = session.selectList(ns+"select",map);
		for(Student s: list) System.out.println(s);
		
	}
}


