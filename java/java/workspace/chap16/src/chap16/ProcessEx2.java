package chap16;

import java.io.IOException;
import java.io.OutputStream;

/*
 * �ٸ� Process�� ����� ȭ�鿡 ����ϱ�.
 */
public class ProcessEx2 {
	public static void main(String[] args) throws Exception {
		Process p = Runtime.getRuntime().exec("ping 192.168.0.1");
		byte[] buf= new byte[1024];
		int len = 0;
		//p.getInputStream() : p�� ������ InputStream���� �������ڴ�.
		// byte[] buf = new byte[1024] : 1024byte�� ��� �аڴ�.
		while((len = p.getInputStream().read(buf))!= -1) {
			System.out.println(new String(buf,0,len));
		}
		OutputStream out = System.out;
		out.write("aaa".getBytes());
		System.out.write("�ȳ�".getBytes());
	}
}
