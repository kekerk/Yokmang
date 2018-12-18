package chap3;
/*
 * 교재 39
 * 특수문자 : 어떤 문자에 의미를 부여하거나, 의미있는 문자의 의미를 제거할 수 있다.
 * \ : 특수 문자를 표시하는 문자
 * "a" : 
 *  
 *  */
public class VarEx5 {

	public static void main(String[] args) {
	System.out.println("\"안녕\"");
	System.out.println("안녕");
	char single = '\'';
	String qoato = "Hello \" 홍길동 \"";
	String root = "c:\\";
	System.out.println(single);
	System.out.println(qoato);
	System.out.println(root);
	System.out.println("서울\t대구\t부산"); //tap 기능 부여
	System.out.println("안녕하세요 \n이부분은 다음줄에"); // enter 기능 부여
	System.out.println("\uD64D\uAE38\uB3D9"); // 유니코드로 쓰겠다라는 뜻.
	// 문자형 : char는 정수형으로 표시 가능하다.
	char ch = 65;
	System.out.println(ch);//A
	ch++;
	System.out.println(ch);//B
	ch--;
	System.out.println(ch);//A?
	long jumin = 9001011234567l;
	System.out.println("주민번호:" + jumin);
	System.out.println("1" + "2"); //12 문자 그대로 표시
	System.out.println("true"+1+2+3); //true123
	System.out.println('A'+'B'); //65+66=131
	System.out.println("A"+"B");
	System.out.println("A"+'B'+'C');
	System.out.println('A'+'B'+"C");
	System.out.println("a"+ null);
	}

}
