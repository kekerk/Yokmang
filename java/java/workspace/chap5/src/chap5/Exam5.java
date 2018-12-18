package chap5;

/*
 * 숫자로 이루어진 문자열 a가 있을 때 각각의 자리수의 합을 구하기.
 * 
 * a.length(),a.charAt()
 * for 구문 이용.
 */
public class Exam5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "123456"; // 1은 chatAt(0), 2는 chatAt(1), 3은 chatAt(2), 4는 chatAt(3), 5는 chatAt(4) >>> 이런식
		int sum = 0;
		// for문 안에서의 int i는 지역변수라고 한다. 
		for (int i = 0; i < a.length(); i++) { // a.length()는 문자열 a의 길이를 나타냄.
			sum += a.charAt(i) - '0'; // a.charAt(i)는 각 자리의 값을 나타냄. 왼쪽 끝 문자부터 charAt(0),charAt(1),......
									  // '1'은 문자형의 아스키 값으로 정수형으로는 49를 나타냄. 그래서 정수형으로 하려면 '0'을 빼줘야한다.
			 					       
		}
		System.out.println("숫자로 이루어진 문자열 각 자리의 합은 " + sum);
	}

}
