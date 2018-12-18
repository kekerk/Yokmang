package chap14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * Properties 클래스 예제
 *  1. Hashtable 의 하위 클래스. Map 객체임. Hashtable의 멤버를 가지고있겠지. Properties is a map.
 *  2. Key와 value 모두 String인 map 객체임 => 제네릭 (< >) 사용 안함.
 */
public class PropertiesEx1 {
	public static void main(String[] args) throws IOException {
		
		Properties pr = new Properties();
		
		FileInputStream fis = new FileInputStream("a.properties"); // 파일을 읽어온다.
		//fis 파일의 값을 key=value 로 설정.
		pr.load(fis);
		
		System.out.println(pr); //age=20에서 20은 문자열.
		
		System.out.println("이름:" + pr.getProperty("name"));
//		System.out.println("이름:" + pr.get("name")); //.get은 map 객체의 기능.
		pr.put("subject","컴퓨터공학");
		//store : pr의 객체들을 b.txt에 저장.
		System.out.println("subject:"+pr.get("subject"));
		pr.store(new FileOutputStream("b.txt"), "#save"); //#이하는 주석.
		
		System.out.println(pr);
		
		
		
		
		
	}
}
