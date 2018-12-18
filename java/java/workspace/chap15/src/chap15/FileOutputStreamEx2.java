package chap15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/*
 * File에 예외 정보 출력하기.
 */
public class FileOutputStreamEx2 {
	public static void main(String[] args) {
		method1();

	}

	private static void method1() {
		method2();
	}

	private static void method2() {
		try {
			throw new Exception("파일에 메시지 저장하기."); //에러 발생.
		} catch (Exception e) {
	    	e.printStackTrace(); //표준 출력(System.out)에 출력하기.
	    	//new FileOutputStream("err.log",true)
	    	//err.log 파일이 존재하는 경우 기존 내용을 보존하고, 새로운 내용을 추가하는 기능.
			PrintStream ps = null;
			try {
				FileOutputStream fos = new FileOutputStream("err.log",true);
				//자료형에 상관 x, 출력에 최적화된 클래스.
				//ps : err.log파일에 println() 으로 출력하기.
				ps = new PrintStream(fos);
				ps.println(e.getMessage());
				e.printStackTrace(ps);

			} catch (FileNotFoundException fe) {
			} finally {
				ps.close();
			}

		}
	}
}