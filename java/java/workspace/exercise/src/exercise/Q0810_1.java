package exercise;

//1.
//강아지와 병아리의 합이  1000 이하, 다리의 합이 4000 이하까지 입력받는다.
//하나의 결과가 나온 후에도 계속 새로운 입력을 받다가  0 이 입력되면   프로그램을 종료한다.
//   
//강아지와 병아리의 합과 다리의 수를 입력받아  강아지와 병아리가 각각 몇 마리씩인지  구하는 프로그램을 작성하시오.
//
//
//강아지와 병아리가 각각 몇 마리씩인지 출력한다.
//주어진 데이터로 마리수를 정할 수 없을 때는  "0" 을 출력한다.
//데이터의 크기가 주어진 범위를 벗어날 경우는 "INPUT ERROR!"를 출력한다.
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
		super("강아지",  4);
	}
}

class Chicken extends Animal {

	Chicken() {
		super("병아리", 2);
	}

}

public class Q0810_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("강아지와 병아리의 합을 입력하세요");
		int n = scan.nextInt();
		System.out.println("강아지와 병아리의 다리 개수의 총합을 입력하세요");
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
