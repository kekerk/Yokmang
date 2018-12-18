package chap18;
/*
 *  ���ٽ� ���� : jdk 8.0 ���� �������� �߰���.
 *  FunctionalInterface : �������̽��� ����� �߻�޼��尡 �Ѱ��� �������̽�
 *  
 *  �Ű������� ����, ����Ÿ�Ե� ���� ���.
 *  
 */

@FunctionalInterface
interface LambdaInterface1{
	void method(); //����Ÿ�� ����. �Ű����� ����.
	
}
public class LambdaEx1 {
	public static void main(String[] args) {
		LambdaInterface1 f1;
		// �Ű������� ���� ����Ÿ�Ե� ���� ���.
		f1 = () -> { //����Ŭ������ ���� ���·� ����.
			String str = "method call (1)";
			System.out.println(str);
		};
		
		f1.method();
		/////////////////////////////////////////////////
		
		f1 = () -> {		
			System.out.println("method call (2)");
		};
		f1.method();
		
		execute(f1); // f1.method()�� �����Ѵ�.
		execute(()-> {System.out.println("method call (3)");}); //f1 ��� �� �� �κ��� ����ִ´�.
		execute(()-> {System.out.println("method call (4)");});
	}
	// f1 = () -> {                   } �̹Ƿ� f1���  ()-> { ���ǹ� }; �� ������� �� �ִ�.
	static void execute(LambdaInterface1 f) {
		f.method();
	}
}
