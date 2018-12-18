package chap7;

/*1. 

동물클래스(Animal) 구현
      멤버변수 : 이름(name), 나이(age)
     멤버메서드: eat() 
            기능 :" 맛있게 얌얌 "  출력함

         

구동클래스(AnimalTest.java) 구현
   main 메서드에서 결과가
   [결과]

  원숭이:26살

  맛있게 얌얌
*/
class Animal {
	String name;
	int age;

	void eat() {
		System.out.println("맛있게 냠냠");
	}

}

public class Q1 {
	public static void main(String[] args) {
		Animal[] ani = new Animal[5];
		String[] a = { "원숭이", "기린", "사자", "타조", "오랑우탄" };
		int[] b = { 25, 14, 32, 2, 5 };
		for (int i = 0; i < ani.length; i++) {
			ani[i] = new Animal();
			ani[i].name = a[i];
			ani[i].age = b[i];
			System.out.print((ani[i].name) + ":" + ani[i].age + "살\n");
			ani[i].eat();
			System.out.println();

		}

	}

}
