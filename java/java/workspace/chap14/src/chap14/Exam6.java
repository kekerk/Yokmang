package chap14;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 대한민국(서울), 캐나다(오타와), 영국(런던), 스위스(베른)의 수도를 
 * HashMap에 저장 후 화면에서 나라이름을 입력받아, 입력받은 나라의 
 * 수도를 출력하는 프로그램 작성하기.
 * 입력된 나라가 아닌경우 "등록되지 않은 나라입니다" 출력하기.
 */
public class Exam6 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		String[] country = { "대한민국", "캐나다", "영국", "스위스" };
		String[] capital = { "서울", "오타와", "런던", "베른" };
		for (int i = 0; i < country.length; i++) {
			map.put(country[i], capital[i]);
		}
		System.out.println(map);
		System.out.println("나라이름을 입력하세요.");
		while (true) {
			Scanner scan = new Scanner(System.in);
			String name = scan.nextLine();
			if (name.equals("끝"))
				break;
//			String value = map.get(name);
			if ( map.get(name) == null) {
				System.out.println("등록되지 않은 나라입니다.");
			} else {
				System.out.println(name + "의 수도는 " + map.get(name));
			}
		}
	}

}
