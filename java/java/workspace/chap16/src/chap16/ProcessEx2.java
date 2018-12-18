package chap16;

import java.io.IOException;
import java.io.OutputStream;

/*
 * 다른 Process의 결과를 화면에 출력하기.
 */
public class ProcessEx2 {
	public static void main(String[] args) throws Exception {
		Process p = Runtime.getRuntime().exec("ping 192.168.0.1");
		byte[] buf= new byte[1024];
		int len = 0;
		//p.getInputStream() : p의 내용을 InputStream으로 가져오겠다.
		// byte[] buf = new byte[1024] : 1024byte씩 끊어서 읽겠다.
		while((len = p.getInputStream().read(buf))!= -1) {
			System.out.println(new String(buf,0,len));
		}
		OutputStream out = System.out;
		out.write("aaa".getBytes());
		System.out.write("안녕".getBytes());
	}
}
