package chap14;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * Exam6.java에서 등록된 나라가 아닌 경우 수도를 입력받아 등록하기.
 * 종료시 현재 map의 정보를 출력하기. (Iterator 이용)
 */
public class Exam7 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		String[] country = { "대한민국", "캐나다", "영국", "스위스" };
		String[] capital = { "서울", "오타와", "런던", "베른" };
		for (int i = 0; i < country.length; i++) {
			map.put(country[i], capital[i]);
		}
		System.out.println(map);

		while (true) {
			System.out.println("나라이름을 입력하세요.");
			Scanner scan = new Scanner(System.in);
			String name = scan.nextLine();
			if (name.equals("끝"))
				break;
			// String value = map.get(name);
			if (map.get(name) == null) {
				System.out.println("등록되지 않은 나라입니다. 수도를 등록해주세요.");
				String cap = scan.nextLine();
				map.put(name, cap);

			} else {
				System.out.println(name + "의 수도는 " + map.get(name));
			}
		}
		System.out.println("Map의 내용 조회하기:1");
		Set<String> keys = map.keySet(); // key들의 정보만 가져오는 기능. 나라만 불러온다.
		Iterator it = keys.iterator();
		// Keys 에 대한 Iterator 내용을 메서드로 불러오기.
		while (it.hasNext()) { //읽어올 요소가 ㅇ남아있는지 아닌지. 
			// Iterator에 제네릭 표시가 없어서 Object로 선언.
			Object k = it.next(); //다음 요소를 읽어온다.
			System.out.println(k + ":" + map.get(k));
		}
		
		System.out.println("Map의 내용 조회하기:2");
		Set<Map.Entry<String, String>> entry = map.entrySet();
		it = entry.iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> k = (Map.Entry<String, String>) it.next();
			System.out.println(k.getKey() + ":" + k.getValue());
		}

	}
}
