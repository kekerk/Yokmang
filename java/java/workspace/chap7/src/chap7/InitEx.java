package chap7;
/*
 * ���� 7-17
 * static(Ŭ����) �ʱ�ȭ �� :
 *     Ŭ���� ������ �ʱ�ȭ�� ���
 *     main �޼��� ������ ȣ���. �ѹ��� ȣ���.                    
 * 
 * �ν��Ͻ� �ʱ�ȭ �� 
 * 		�ַ� �ν��Ͻ� ������ �ʱ�ȭ�� ���. �����ڿ� ����� ��ħ.
 * 	 	�����ں��� ���� ȣ���.
 * 		��üȭ�� ������ �����ں��� ���� ȣ���.
 */
public class InitEx {
	static int cv;
	int iv;
	InitEx() {
		System.out.println("5. ������ ȣ���");
	}
	static { //static �� �ְ� �߰�ȣ �����ϸ� static �ʱ�ȭ ��. main���� ���� ����. (1)
		cv = (int)(Math.random()*100);
		System.out.println("1.Ŭ���� �ʱ�ȭ �� ���� cv= "+ cv);
//		System.out.println(iv); //����
	    System.out.println(new InitEx().iv);
	}
	{  //static���� �ٷ� �߰�ȣ �����Ǹ� �ν��Ͻ� �ʱ�ȭ ��.
		System.out.println("4. �ν��Ͻ� �ʱ�ȭ ��. �����ں��� ���� �����.");
	}
	public static void main(String[] args) {
		System.out.println("2. main �޼��� ����");
		System.out.println("3. main init1 ��ü ����");
		InitEx init1 = new InitEx();
		System.out.println("6. main init2 ��ü ����");
		InitEx init2 = new InitEx();
		
		
	}

}
