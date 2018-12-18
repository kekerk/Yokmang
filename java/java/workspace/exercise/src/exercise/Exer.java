package exercise;

import java.util.Scanner;


public class Exer {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("배열의 길이를 입력하세요");
	int len = scan.nextInt();
	int[][] arr = new int[len][len];
	int index = 0;
	
	for(int i=0;i<arr.length;i++) {
		arr[i] = new int[i+1]; //가변 배열. 첫째행에 한칸 , 둘째 행에 두칸.
	}
	for( int j=arr.length-1;j>=0;j--) {
		for(int i = j;i<arr.length;i++ ) {
			arr[i][j]=++index;
		}
		
	}
	
	for( int i=0;i<arr.length;i++) {
		for(int j = 0;j<arr[i].length;j++ ) {
			System.out.print(arr[i][j]+" ");
		}
		System.out.println();
	}
	}

}
