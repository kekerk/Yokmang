package chap4;
//나누기연산자(/), 나머지연산자(%) 예제.
// 정수=정수/정수  정수 간의 나누기는 소수점 생략됨
// 나머지 연산 후의 결과의 부호는 피제수의 부호를 따른다. 10을 8로 나눌시 양수, -10 을 8로 나눌시 음수
public class OpEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(10/8); //소수점 처리를 하면 소수점까지 표시
		System.out.println(10/-8); //-1
		System.out.println(-10/8); //-1
		System.out.println(-10/-8); // 1
		System.out.println(10%8); //2
		System.out.println(10%-8); //2 10이라서 2
		System.out.println(-10%8); //-2  피제수의 부호를 따른다. (나머지연산)
		System.out.println(-10%-8); //-2 -10이라서 -2
		
	}

}
