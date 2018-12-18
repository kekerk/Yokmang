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
			server = new ServerSocket(port); //client�� accept()�� �Ѵ�. client�� �����Ǵ� ������ŭ Thread ����. 
			while(true) {  //while(true)�� Thread�� ������ �����ϱ� ���� ���.
			System.out.println("Ŭ���̾�Ʈ ���� ���");
			// client�� server�� accept�Ͽ� port�� ������ ����.
			client = server.accept(); //���Ӵ��
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
	    Socket client; // ���ӵ� Socket ��ü.
		HttpThread1(Socket client) {// ������. ��ü�� �����ϱ� ���ؼ�.
			this.client = client;
		}
		public void run() {
			try {
				// out: Ŭ���̾�Ʈ�� ������ ��� ��Ʈ��.
				PrintWriter out = new PrintWriter(client.getOutputStream(), true);
				// in : Ŭ���̾�Ʈ���� ���۵� ������ ���� �Է� ��Ʈ��. 
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				String input;
				// client�� �������� ������ readLine���� ����.
				while ((input = in.readLine()) != null) {
					// readLine���� �߱� ������ out.println���� �о���Ѵ�.
					out.println(input);
					out.flush();
					System.out.println("echo : " + input);
				}
				in.close();
				out.close();
				client.close(); //Ŭ���̾�Ʈ�� �������鼭 Thread daed ����.
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
