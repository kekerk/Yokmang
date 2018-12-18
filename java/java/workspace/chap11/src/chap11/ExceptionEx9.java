package chap11;

import java.util.Scanner;

class LoginFailException2 extends Exception { //���� ���� �޼����� �߰��Ͽ�  ���ܰ�ü�� ���� �� �ִ�.

	private String[] msg = { "���̵� Ʋ���ϴ�. ���̵� Ȯ���ϼ���", "��й�ȣ�� Ʋ���ϴ�. ��й�ȣ�� Ȯ���ϼ���" };
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
			e.printStackTrace(); //Exception�� ��� �޼���
		}
	}

	private static void loginCheck(String id, String pw) // id = hong, pw = 1234 
		throws LoginFailException2{
			Scanner scan = new Scanner(System.in);
			System.out.println("���̵� �Է�:");
			String inputId = scan.nextLine();
			System.out.println("��й�ȣ �Է�:");
			String inputPw = scan.nextLine();
			try {
			if(id.equals(inputId) && pw.equals(inputPw)) {
				System.out.println("�α��� ����");
			} else if(!id.equals(inputId)) {
				throw new LoginFailException2(0);
			}else {
				throw new LoginFailException2(1);
			}
			}catch(LoginFailException2 e) {
				System.out.println(e.getMsg());  //LoginFailException2 class�� ��� �޼���
				throw e;
			}
		}
	}
