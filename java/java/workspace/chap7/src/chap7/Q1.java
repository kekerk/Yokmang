package chap7;

/*1. 

����Ŭ����(Animal) ����
      ������� : �̸�(name), ����(age)
     ����޼���: eat() 
            ��� :" ���ְ� ��� "  �����

         

����Ŭ����(AnimalTest.java) ����
   main �޼��忡�� �����
   [���]

  ������:26��

  ���ְ� ���
*/
class Animal {
	String name;
	int age;

	void eat() {
		System.out.println("���ְ� �ȳ�");
	}

}

public class Q1 {
	public static void main(String[] args) {
		Animal[] ani = new Animal[5];
		String[] a = { "������", "�⸰", "����", "Ÿ��", "������ź" };
		int[] b = { 25, 14, 32, 2, 5 };
		for (int i = 0; i < ani.length; i++) {
			ani[i] = new Animal();
			ani[i].name = a[i];
			ani[i].age = b[i];
			System.out.print((ani[i].name) + ":" + ani[i].age + "��\n");
			ani[i].eat();
			System.out.println();

		}

	}

}
