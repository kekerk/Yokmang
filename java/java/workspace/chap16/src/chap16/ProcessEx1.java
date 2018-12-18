package chap16;
/*
 * Runtime(리턴타입) Runtime.getRuntime(): OS로부터 실행 권한을 얻기.
 * Process         Runtime.exec(..)    : 현재 실행 중인 프로세스.
 *   
 */
import java.io.IOException;

public class ProcessEx1 {
	public static void main(String[] args) throws Exception {
		//현재 3개의 프로세스 가동중 : mspaint.exe, notepad.exe, ProcessEx1.java
		Process p1 = Runtime.getRuntime().exec("mspaint.exe");
		Process p2 = Runtime.getRuntime().exec("notepad.exe");
		//실행 뒤 메모장을 종료하면 그림판은 남아있으나, 그림판을 종료하면 메모장도 같이 종료됨.
		p1.waitFor(); // p1 프로세스가 종료할 때까지 대기.
		p2.destroy(); // p2 프로세스를 강제 종료.
	}
}
