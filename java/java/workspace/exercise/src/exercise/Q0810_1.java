package exercise;

//1.
//�������� ���Ƹ��� ����  1000 ����, �ٸ��� ���� 4000 ���ϱ��� �Է¹޴´�.
//�ϳ��� ����� ���� �Ŀ��� ��� ���ο� �Է��� �޴ٰ�  0 �� �ԷµǸ�   ���α׷��� �����Ѵ�.
//   
//�������� ���Ƹ��� �հ� �ٸ��� ���� �Է¹޾�  �������� ���Ƹ��� ���� �� ����������  ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
//
//
//�������� ���Ƹ��� ���� �� ���������� ����Ѵ�.
//�־��� �����ͷ� �������� ���� �� ���� ����  "0" �� ����Ѵ�.
//�������� ũ�Ⱑ �־��� ������ ��� ���� "INPUT ERROR!"�� ����Ѵ�.
import java.util.Scanner;

class Animal {
	String name;
	int legs, num;

	Animal(String name,  int legs) {
		this.name = name;
		this.legs = legs;
		
	}
}

class Dog extends Animal {
	Dog() {
		super("������",  4);
	}
}

class Chicken extends Animal {

	Chicken() {
		super("���Ƹ�", 2);
	}

}

public class Q0810_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�������� ���Ƹ��� ���� �Է��ϼ���");
		int n = scan.nextInt();
		System.out.println("�������� ���Ƹ��� �ٸ� ������ ������ �Է��ϼ���");
		int l = scan.nextInt();
		Animal[] ani = new Animal[2];
		ani[0] = new Dog();
		ani[1] = new Chicken();
		
			if (n > 4000 || l > 1000) {
				System.out.println("input error!!");
				break;
			}
		
			
			  while(l!=0) {
					l = l - s.legs;
					
					
					if(l==1) {
						System.out.println("0");
						break;
					}
				}

			}

		
	}
