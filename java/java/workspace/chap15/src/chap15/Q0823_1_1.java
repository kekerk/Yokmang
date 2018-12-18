package chap15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Q0823_1_1 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("파일명을 입력하세요");
		String fileName = scan.nextLine();
		System.out.println("조회할 라인을 숫자로 입력하세요");
		int num = scan.nextInt();
		// BufferedReader br: 성능 향상. 버퍼의 기능을 추가.
		// br.readLine() : 한줄씩 읽을 수 있는 메서드.
		//보조스트림 : 객체 생성할 때 매개변수로 다른 스트림을 입력받는다.
		//			다른 기능을 추가할 수 있는 스트림.
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		//PrintWriter : println,print,printf 기능을 추가.
		//				모든 타입에 상관없이 출력할 수 있는 기능을 추가.
		//				예외처리를 하지 않아도 됨.(예외 처리를 생략할 수 있다.)
		PrintWriter pw = new PrintWriter(new FileWriter(fileName+".subfile"));
		String line = null;		
		for (int i=0;i<num;i++) {
			if((line=br.readLine())==null) break;
			System.out.println(line);
			//출력하려는 파일(fileName+".subfile")에 line 문자열을 출력.
			pw.println(line);
		}
		pw.close(); br.close();
	}

}
