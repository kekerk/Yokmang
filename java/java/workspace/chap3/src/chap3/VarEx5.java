package chap3;
/*
 * ���� 39
 * Ư������ : � ���ڿ� �ǹ̸� �ο��ϰų�, �ǹ��ִ� ������ �ǹ̸� ������ �� �ִ�.
 * \ : Ư�� ���ڸ� ǥ���ϴ� ����
 * "a" : 
 *  
 *  */
public class VarEx5 {

	public static void main(String[] args) {
	System.out.println("\"�ȳ�\"");
	System.out.println("�ȳ�");
	char single = '\'';
	String qoato = "Hello \" ȫ�浿 \"";
	String root = "c:\\";
	System.out.println(single);
	System.out.println(qoato);
	System.out.println(root);
	System.out.println("����\t�뱸\t�λ�"); //tap ��� �ο�
	System.out.println("�ȳ��ϼ��� \n�̺κ��� �����ٿ�"); // enter ��� �ο�
	System.out.println("\uD64D\uAE38\uB3D9"); // �����ڵ�� ���ڴٶ�� ��.
	// ������ : char�� ���������� ǥ�� �����ϴ�.
	char ch = 65;
	System.out.println(ch);//A
	ch++;
	System.out.println(ch);//B
	ch--;
	System.out.println(ch);//A?
	long jumin = 9001011234567l;
	System.out.println("�ֹι�ȣ:" + jumin);
	System.out.println("1" + "2"); //12 ���� �״�� ǥ��
	System.out.println("true"+1+2+3); //true123
	System.out.println('A'+'B'); //65+66=131
	System.out.println("A"+"B");
	System.out.println("A"+'B'+'C');
	System.out.println('A'+'B'+"C");
	System.out.println("a"+ null);
	}

}
