package chap17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ServerError;

public class EchoServerEx2 {
	public static void main(String[] args) throws Exception {
		int port = 5000;
		Socket client = null;
		ServerSocket server = null;
		try { 
			server = new ServerSocket(port); //client의 accept()만 한다. client가 생성되는 갯수만큼 Thread 생성. 
			while(true) {  //while(true)는 Thread를 여러개 생성하기 위해 사용.
			System.out.println("클라이언트 접속 대기");
			// client는 server를 accept하여 port를 가지고 있음.
			client = server.accept(); //접속대기
			System.out.println("server port : " + server.getLocalPort());
			System.out.println();
			System.out.println("client IP : " + client.getInetAddress());
			System.out.println("client PORT : " + client.getPort());
			System.out.println();
			HttpThread1 ht = new HttpThread1(client);
			ht.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	static class HttpThread1 extends Thread {
	    Socket client; // 접속된 Socket 객체.
		HttpThread1(Socket client) {// 생성자. 객체를 생성하기 위해서.
			this.client = client;
		}
		public void run() {
			try {
				// out: 클라이언트에 전송할 출력 스트림.
				PrintWriter out = new PrintWriter(client.getOutputStream(), true);
				// in : 클라이언트에서 전송된 내용을 읽을 입력 스트림. 
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				String input;
				// client가 전달해준 내용을 readLine으로 읽음.
				while ((input = in.readLine()) != null) {
					// readLine으로 했기 때문에 out.println으로 읽어야한다.
					out.println(input);
					out.flush();
					System.out.println("echo : " + input);
				}
				in.close();
				out.close();
				client.close(); //클라이언트가 끊어지면서 Thread daed 상태.
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
