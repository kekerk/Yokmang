package chap17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ���� �޼��� ó�� ���� ���α׷�.
 *  (Ŭ���̾�Ʈ ���α׷��� �־���Ѵ�.)
 */
public class EchoServerEx1 {
	public static void main(String[] args) {
		int port = 5000;
		Socket client = null;
		ServerSocket server = null;
		try {
			//������ ���� port�� ������ ����.
			server = new ServerSocket(port);
			System.out.println("Ŭ���̾�Ʈ ���� ���");
			//client�� server�� accept�Ͽ� port�� ������ ����.
			client = server.accept();
			// 
			System.out.println("server port : " + server.getLocalPort());
			System.out.println();

			System.out.println("client IP : " + client.getInetAddress());

			System.out.println("client PORT : " + client.getPort());

			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

			String input;
			//client�� �������� ������ readLine���� ����.
			while ((input = in.readLine()) != null) {
				//readLine���� �߱� ������ out.println���� �о���Ѵ�.
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
