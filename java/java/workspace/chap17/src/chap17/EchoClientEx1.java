package chap17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * d에코 클라이언트 예제
 */
public class EchoClientEx1 {
	public static void main(String[] args) throws Exception {
		int port = 5000;
		String ip = "192.168.0.87";
		Socket client = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String input;
		//scanner 대신 쓸 수 있다.
		BufferedReader stdin = new BufferedReader
				(new InputStreamReader(System.in));
		// ip는 server ip 주소, port는 5000
		client = new Socket(ip, port);
		// in은 server에서 내용을 읽어서 가져온다.
		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(client.getOutputStream(), true);
		System.out.println("local port: " + client.getLocalPort());
		System.out.println("local ip: " + client.getInetAddress());
		System.out.println("server port: " + client.getPort());
		System.out.println("server ip: " + client.getInetAddress());
		System.out.println("메세지를 입력하세요");
		while ((input = stdin.readLine()) != null) {
			if (input.equals("bye"))
				break;
			//out을 통해서 server로 전달 된다.
			out.println(input);
			out.flush();
			System.out.println("sever echo: " + in.readLine());
			System.out.println("메세지를 입력하세요");
		}
		out.close();
		in.close();
		stdin.close();
		client.close();
	}
}
