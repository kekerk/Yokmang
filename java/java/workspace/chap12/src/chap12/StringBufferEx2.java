package chap12;

public class StringBufferEx2 {

	public static void main(String[] args) {
		StringBuffer sb= new StringBuffer();
		sb.append("abc").append(123).append('A').append(false);
		System.out.println(sb);
		sb.delete(2, 4);
		System.out.println(sb);
		sb.deleteCharAt(4); //index가 4인 자리의 문자를 지운다. 
		System.out.println(sb);
		sb.insert(5, "==");// index가 5인 자리에 == 집어넣는다. (나머지는 뒤로 밀림)
		System.out.println(sb);
		sb.insert(6, 1.23);// index가 6인 자리에 1.23을 집어넣는다. (나머지는 뒤로 밀림)
		System.out.println(sb);
		
		
		sb = new StringBuffer("ABCDEFG");
		sb.replace(0, 3, "abc"); // index가 0부터 3 앞까지의 문자열을 abc로 바꾼다.
		System.out.println(sb);
		sb.reverse(); // 문자열 순서 반대로.
		System.out.println(sb);
	}

}
