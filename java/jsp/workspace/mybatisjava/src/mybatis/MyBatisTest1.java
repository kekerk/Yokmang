package mybatis;
/*
 * student 테이블의 내용을 조회하기.
 * 1. 전체 학생 조회하기
 * 2. 학년을 기준으로 조회하기
 * 3. 성별을 기준으로 조회하기 => 주민번호 7번째 자리가 (1,3) 남자 (2,4) 여자
 * 4. 학과별 기준으로 조회하기 
 * 5. 학번으로 학생 한명만 조회하기.
 * 
 * select 구문 하나로 해야한다.
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
		System.out.println("===전체 레코드 조회하기===");
		List<Student> list = session.selectList(ns+"select");
		for(Student s : list) System.out.println(s);
		
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println("\n===1학년 레코드 조회하기===");
		map.put("grade", 1);
		list = session.selectList(ns+"select",map);
		for(Student s:list) System.out.println(s);
		
		System.out.println("\n===학과별 레코드 조회하기===");
		map.clear();
		map.put("major1", 101);
		list = session.selectList(ns+"select",map);
		for(Student s:list) System.out.println(s);
		
		System.out.println("\n===학번에 맞는 학생 레코드 조회하기===");
		map.clear();
		map.put("studno", 960315);
		Student student = session.selectOne(ns+"select",map);
		System.out.println(student);
		
		System.out.println("\n===여학생 레코드 조회하기===");
		map.clear();
		map.put("jumin", 2);
		list = session.selectList(ns+"select",map);
		for(Student s: list) System.out.println(s);
		
	}
}


