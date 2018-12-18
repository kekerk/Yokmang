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
 *  student 테이블의 내용을 조회하기
 *  1. 학년별, 성별, 학과별 조회 가능하기. 단 모든 조건은 and로
 *  2. 학년을 선택하여 조회하기
 *  3. 학과를 선택하여 조회하기
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
		System.out.println("조건 조회");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("grade", 2);
		map.put("jumin", 1);
		map.put("major1", 102 );
		List<Student> list = session.selectList(ns+"selectByTrim",map);
		for(Student s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n학년 선택 조회");
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
		
		System.out.println("\n학과 선택 조회");
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
