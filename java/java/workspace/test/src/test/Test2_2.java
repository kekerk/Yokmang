package test;

import java.util.Scanner;
/*
 * math.random() : 0<= x <1.0
 *  math.random() * 3 : 0<= x <3.0
 *  (int)(math.random()*3) : 0<= x <= 2
 *  (int)(math.random()*3) +1 : 0<= x <=3
 *    
 * 
 */
public class Test2_2 {

	public static void main(String[] args) {
		int comn = (int) (Math.random() * 3) + 1;
		System.out.println("ÄÄÇ»ÅÍ°¡ ³½°Å´Â" + comn);
		Scanner scan = new Scanner(System.in);
		System.out.println("°¡À§(1), ¹ÙÀ§(2), º¸(3) Áß ´Ï°¡ ³¾ ²¨´Â?");
    	int num = scan.nextInt();
		String result = null;
		
		
		switch (comn) {
		case 1:
			result = (num == 1) ? "ºñ±è" : (num == 2) ? "³»°¡ ½Â¸®" : "ÄÄÇªÅÍ ½Â¸®";
			break;
		case 2:
			result = (num == 2) ? "ºñ±è" : (num == 3) ? "³»°¡ ½Â¸®" : "ÄÄÇªÅÍ ½Â¸®";
			break;

		case 3:
			result = (num == 3) ? "ºñ±è" : (num == 1) ? "³»°¡ ½Â¸®" : "ÄÄÇªÅÍ ½Â¸®";
			break;

		}
		System.out.println(result);
	}

}
