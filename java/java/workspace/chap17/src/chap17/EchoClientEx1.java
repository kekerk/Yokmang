package chap17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * d���� Ŭ���̾�Ʈ ����
 */
public class EchoClientEx1 {
	public static void main(String[] args) throws Exception {
		int port = 5000;
		String ip = "192.168.0.87";
		Socket client = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String input;
		//scanner ��� �� �� �ִ�.
		BufferedReader stdin = new BufferedReader
				(new InputStreamReader(System.in));
		// ip�� server ip �ּ�, port�� 5000
		client = new Socket(ip, port);
		// in�� server���� ������ �о �����´�.
		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(client.getOutputStream(), true);
		System.out.println("local port: " + client.getLocalPort());
		System.out.println("local ip: " + client.getInetAddress());
		System.out.println("server port: " + client.getPort());
		System.out.println("server ip: " + client.getInetAddress());
		System.out.println("�޼����� �Է��ϼ���");
		while ((input = stdin.readLine()) != null) {
			if (input.equals("bye"))
				break;
			//out�� ���ؼ� server�� ���� �ȴ�.
			out.println(input);
			out.flush();
			System.out.println("sever echo: " + in.readLine());
			System.out.println("�޼����� �Է��ϼ���");
		}
		out.close();
		in.close();
		stdin.close();
		client.close();
	}
}
