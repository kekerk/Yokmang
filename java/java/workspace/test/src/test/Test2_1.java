package test;

import java.util.Scanner;

public class Test2_1 {

	public static void main(String[] args) {
		int comn = (int) (Math.random() * 3) + 1;
		System.out.println("컴퓨터가 낸거는"+comn);
		Scanner scan = new Scanner(System.in);
		System.out.println("가위(1), 바위(2), 보(3) 중 니가 낼 꺼는?");
		int num = scan.nextInt();
		switch (num) {
		case 1:
			switch(comn) {
			case 1: System.out.println("비김"); break;
			case 2: System.out.println("컴퓨터 이김"); break;
			case 3: System.out.println("내가 이김"); break;
			}
			break;
		case 2:
			switch(comn) {
			case 1: System.out.println("내가 이김"); break;
			case 2: System.out.println("비김"); break;
			case 3: System.out.println("컴퓨터 이김"); break;
			}
			break;
			
		case 3:
			switch(comn) {
			case 1: System.out.println("컴퓨터 이김"); break;
			case 2: System.out.println("내가 이김"); break;
			case 3: System.out.println("비김"); break;
			}
			break;
			
		}


	}

}
