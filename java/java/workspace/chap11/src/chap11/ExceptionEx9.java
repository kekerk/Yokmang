package chap11;

import java.util.Scanner;

class LoginFailException2 extends Exception { //내가 가진 메세지를 추가하여  예외객체를 만들 수 있다.

	private String[] msg = { "아이디가 틀립니다. 아이디를 확인하세요", "비밀번호가 틀립니다. 비밀번호를 확인하세요" };
	private int index;

	LoginFailException2(int index) {
		this.index = index;
	}

	public String getMsg() {
		return msg[index];
	}
}

public class ExceptionEx9 {
	public static void main(String[] args) {
		try {
			loginCheck("hong","1234");
		}catch(LoginFailException2 e) {
			e.printStackTrace(); //Exception의 멤버 메서드
		}
	}

	private static void loginCheck(String id, String pw) // id = hong, pw = 1234 
		throws LoginFailException2{
			Scanner scan = new Scanner(System.in);
			System.out.println("아이디 입력:");
			String inputId = scan.nextLine();
			System.out.println("비밀번호 입력:");
			String inputPw = scan.nextLine();
			try {
			if(id.equals(inputId) && pw.equals(inputPw)) {
				System.out.println("로그인 성공");
			} else if(!id.equals(inputId)) {
				throw new LoginFailException2(0);
			}else {
				throw new LoginFailException2(1);
			}
			}catch(LoginFailException2 e) {
				System.out.println(e.getMsg());  //LoginFailException2 class의 멤버 메서드
				throw e;
			}
		}
	}
