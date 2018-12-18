package chap15;
/*
 *  OutputStream > ... > PrintStream
 *  :��� ��� ����. ������Ʈ��.
 *  println, print, printf �޼��� �߰�.
 *  => ��� �ڷ����� ����ϴ� ���.
 *  => ����ó�� ���� ����.
 *  
 *  printf : ���������. (%d,%f,%s ...) ��� ���.
 *  String.format() : ���������. (%d,%f,%s ...) ��� ���.(String Ÿ��)
 */
public class PrintStreamEx1 {

	public static void main(String[] args) {
		// char ��� ���� ���� ; %c   , %n == \n
	System.out.printf("%c%n",'A');
	System.out.printf("%5c%n",'A');	//5�ڸ�Ȯ��. ����������.
	System.out.printf("%-5c%n",'A'); // 5�ڸ� Ȯ��. ���� ����.
	//���� ��� : %d, %o, %x, %X
	System.out.printf("%d%n",12345); //Decimal 10�� ����.
	
	System.out.printf("%,d%n",12345);//���ڸ����� , ǥ��.
	
	System.out.printf("%o%n",12345);//12345�� Octal 8������.
	
	System.out.printf("%x%n",12345);//Hexa 16����. %x -> 10 �̻��� �ҹ��� ���ĺ�����.
	System.out.printf("%X%n",12345);//Hexa 16����. %X -> 10 �̻��� �빮�� ���ĺ�����.
	
	System.out.printf("%10d%n",12345);//�ּ� 10�ڸ� Ȯ��. ������ ����.
	System.out.printf("%010d%n",12345);//�ּ� 10�ڸ� Ȯ�� �� ���ڸ��� 0���� ä��.
	System.out.printf("%-10d%n",12345);//�ּ� 10�ڸ� Ȯ��. ���� ����.
	System.out.printf("%,10d%n",12345);
	System.out.printf("%-,10d%n",12345);
	System.out.printf("%-,10d%n",12345);
	//�Ǽ����. %f %d
	System.out.printf("%f%n",12345.12345);//�Ǽ����.
	System.out.printf("%g%n",12345.12345);//�ٻ�Ǽ�.
	System.out.printf("%e%n",12345.12345);//�����Ǽ�.
	System.out.printf("%.2f%n",12345.12345);//�Ҽ��� ���� ����° �ڸ����� �ݿø���.
	System.out.printf("%10.2f%n",12345.12345);
	System.out.printf("%,10.2f%n",12345.12345);
	System.out.printf("%-,10.2f%n",12345.12345);
	System.out.printf("%,02.20f%n",Math.PI);
	//���� ���. %b
	System.out.printf("%b%n",true);
	System.out.printf("%b%n",(10>5));
	//10>5=true  ������������ ����ϱ�.
	System.out.printf("%d > %d = %b%n", 10,5,(10>5));
	//���ڿ� : %s
	System.out.printf("%s�� %s��","��ȣ","�ٺ�");
	System.out.println();
	//10���� 255�� 8���� 377�̴�. : ������
	System.out.printf("%d���� %d�� %d���� %o�̴�. : %b",10,255,8,255,((Integer.toOctalString(255)).equals("377")));
	System.out.println();
	//ȫ�浿�� �޿��� 3,000,000���̴�. 
	System.out.printf("%s�� %s��(��)%,10d���̴�. : %s%n","ȫ�浿","����",3000000,"�赿��");
	System.out.println(String.format("%d���� %d�� %d���� %o�̴�.%n",10,255,8,255));
	
	}
}
