package chap17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 에코 메세지 처리 서버 프로그램.
 *  (클라이언트 프로그램이 있어야한다.)
 */
public class EchoServerEx1 {
	public static void main(String[] args) {
		int port = 5000;
		Socket client = null;
		ServerSocket server = null;
		try {
			//소켓을 만들어서 port를 가지고 있음.
			server = new ServerSocket(port);
			System.out.println("클라이언트 접속 대기");
			//client는 server를 accept하여 port를 가지고 있음.
			client = server.accept();
			// 
			System.out.println("server port : " + server.getLocalPort());
			System.out.println();

			System.out.println("client IP : " + client.getInetAddress());

			System.out.println("client PORT : " + client.getPort());

			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

			String input;
			//client가 전달해준 내용을 readLine으로 읽음.
			while ((input = in.readLine()) != null) {
				//readLine으로 했기 때문에 out.println으로 읽어야한다.
				out.println(input);
				out.flush();
				System.out.println("echo : " + input);
			}
			in.close();
			out.close();
			client.close();
			server.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
