package chap7;
/*
 * Ŭ���� ����� �ν��Ͻ�������� ȣ��
 * Ŭ���� ������� �ν��Ͻ������ ȣ���� ������ ��üȭ �ʿ�.
 */
public class MainCallEx2 {
	static int cv1 = 10; //Ŭ�������
	static int cv2 = cv1;//Ŭ�������
	int iv1 = 100;		 //�ν��Ͻ����. ��üȭ �ʿ�
	int iv2 = iv1;		 //�ν��Ͻ����. ��üȭ �ʿ�
	static int cv3 = new MainCallEx2().iv2; //main �޼��� �ۿ����� ��üȭ�� �����ϴ�.
	
	public static void main(String[] args) {
		MainCallEx2  mc = new MainCallEx2();
		cv2 = mc.iv1;
		 //iv1�� ����Ǳ� ���� ��üȭ�� �Ǿ���Ѵ�.
		mc.method1();
		method2();
	}
		void method1() { // ��üȭ�� �Ǿ���Ѵ�.
		//�ν��Ͻ� �޼���
			System.out.println(cv1+cv2);  
			System.out.println(iv1+iv2);
		}
		
		static void method2() { //Ŭ���� �޼���
			MainCallEx2  mc = new MainCallEx2();
			System.out.println(cv1+cv2);
			System.out.println(mc.iv1+mc.iv2); //
		}
		
	}


