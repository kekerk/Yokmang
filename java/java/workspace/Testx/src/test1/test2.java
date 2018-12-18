package test1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 웹서버 구현
 */
public class test2 {
	public static void main(String[] args) {
		try {
			// ServerSocket : 6000번 포트를 할당받기.(바인드)
			ServerSocket server = new ServerSocket(6000);
			while (true) {
				System.out.println("클라이언트 접속 대기");
				// Socket : 클라이언트와 통신을 하는 객체. 가상 공간에 서버와 클라이언트 연결.
				// 클라이언트 들어올 때까지 대기
				Socket client = server.accept();
				// 클라이언트 접속 상태.
				// Thread 객체를 이용하여 클라이언트와 통신함.
				HThread ht = new HThread(client);
				ht.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 내부 클래스.
	static class HThread extends Thread {
		private Socket client; // 접속된 Socket 객체.
		BufferedReader br; // 클라이언트 정보를 읽은 입력스트림 객체.
		PrintWriter pw;

		HThread(Socket client) {// 생성자. 객체 생성.
			this.client = client;
			try {
				// client.getInputStream() : 클라이언트가 전달한 메세지 정보.
				br = new BufferedReader // 한줄씩 읽기위해 READER로 가져옴.
				(new InputStreamReader(client.getInputStream()));
				// client.getOutputStream() : 서버가 클라이언트에 전달할 메세지의 정보.
				pw = new PrintWriter(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			BufferedReader fbr = null;
			try {
				// line : 클라이언트가 전송한 메세지.
				// line의 내용 : GET / ' ' HTTP / 1.1
				String line = br.readLine();
				System.out.println(line);
				int start = line.indexOf("/") + 1;
				int end = line.lastIndexOf("HTTP") - 1;
				String filename = line.substring(start, end);
				if (filename.equals("")) {
					filename = "index.html";
				}
				System.out.println("클라이언트 요청 파일:" + filename);
				// 한줄씩 읽기위해 BufferedReader 사용.
				// fbr : 요청된 파일을 읽기위한 입력 스트림.
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
