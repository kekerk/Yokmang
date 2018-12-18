package test1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ������ ����
 */
public class test2 {
	public static void main(String[] args) {
		try {
			// ServerSocket : 6000�� ��Ʈ�� �Ҵ�ޱ�.(���ε�)
			ServerSocket server = new ServerSocket(6000);
			while (true) {
				System.out.println("Ŭ���̾�Ʈ ���� ���");
				// Socket : Ŭ���̾�Ʈ�� ����� �ϴ� ��ü. ���� ������ ������ Ŭ���̾�Ʈ ����.
				// Ŭ���̾�Ʈ ���� ������ ���
				Socket client = server.accept();
				// Ŭ���̾�Ʈ ���� ����.
				// Thread ��ü�� �̿��Ͽ� Ŭ���̾�Ʈ�� �����.
				HThread ht = new HThread(client);
				ht.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ���� Ŭ����.
	static class HThread extends Thread {
		private Socket client; // ���ӵ� Socket ��ü.
		BufferedReader br; // Ŭ���̾�Ʈ ������ ���� �Է½�Ʈ�� ��ü.
		PrintWriter pw;

		HThread(Socket client) {// ������. ��ü ����.
			this.client = client;
			try {
				// client.getInputStream() : Ŭ���̾�Ʈ�� ������ �޼��� ����.
				br = new BufferedReader // ���پ� �б����� READER�� ������.
				(new InputStreamReader(client.getInputStream()));
				// client.getOutputStream() : ������ Ŭ���̾�Ʈ�� ������ �޼����� ����.
				pw = new PrintWriter(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			BufferedReader fbr = null;
			try {
				// line : Ŭ���̾�Ʈ�� ������ �޼���.
				// line�� ���� : GET / ' ' HTTP / 1.1
				String line = br.readLine();
				System.out.println(line);
				int start = line.indexOf("/") + 1;
				int end = line.lastIndexOf("HTTP") - 1;
				String filename = line.substring(start, end);
				if (filename.equals("")) {
					filename = "index.html";
				}
				System.out.println("Ŭ���̾�Ʈ ��û ����:" + filename);
				// ���پ� �б����� BufferedReader ���.
				// fbr : ��û�� ������ �б����� �Է� ��Ʈ��.
				fbr = new BufferedReader(new FileReader(filename));
				String fileline = null;
				while ((fileline = fbr.readLine()) != null) {
					pw.println(fileline);
					pw.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (fbr != null)
						fbr.close();
					if (br != null)
						br.close();
					if (pw != null)
						pw.close();
					if (client != null)
						client.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
