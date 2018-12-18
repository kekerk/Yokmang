package chap17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import chap17.SimpleWebServerEx1.HttpThread;

/*
 * SimpleWebServerEx1.java 프로그램의 HttpThread를 Runnable
 */

class Runnable1 implements Runnable {
	private Socket client; //접속된 Socket 객체.
	BufferedReader br; //클라이언트 정보를 읽은 입력스트림 객체.
	PrintWriter pw;
	
	 Runnable1(Socket client){
		this.client = client;
		try {
			//client.getInputStream() : 클라이언트가 전달한 메세지 정보.
			br = new BufferedReader //한줄씩 읽기위해 reader로 가져욤.
					(new InputStreamReader(client.getInputStream()));
			//client.getOutputStream() :서버가 클라이언트에 전달할 메세지의 통로.		
			//new PrintWriter(client.getOutputStream(),true) : true의 의미는 자동 flush 설정. true 보단 flush를 해주는게 좀 더 안정적.
			pw = new PrintWriter(client.getOutputStream());
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	 
	 
	 public void run() {
			BufferedReader fbr = null;
			try {
				//line : 클라이언트가 전송한 메세지.
				//line의 내용 : GET /' ' HTTP/ 1.1
				String line = br.readLine();
				System.out.println(line);
				int start = line.indexOf("/") +1;
				int end = line.lastIndexOf("HTTP")-1;
				String fileName = line.substring(start,end);
				if(fileName.equals("")) {
					fileName = "index.html";
				}
				System.out.println("클라이언트 요청 파일: "+fileName);
				//한줄씩 읽기 위해 BufferdReader 사용.
				//fbr : 요청된 파일을 읽기위한 입력 스트림.
				fbr = new BufferedReader(new FileReader(fileName));
				String fileLine = null;
				while((fileLine = fbr.readLine())!=null) {
					//한줄씩 브라우저로 날아간다. 그리고 파싱 과정을 통해 기계어를 번역.
					pw.println(fileLine);
					pw.flush();
					
				}
			}catch (IOException e) {
			 e.printStackTrace();
			}finally {
				try {
					if(fbr != null) fbr.close();
					if(br != null) br.close();
					if(pw != null) pw.close();
					if(client != null) client.close();
				}catch(IOException e) {
					
				}
			}
	 }
}



public class Exam1 {

	public static void main(String[] args) {
		try {
			// ServerSocket : 8000번 포트를 할당받기 : 바인드.
			ServerSocket server = new ServerSocket(8000);
			while (true) {
				System.out.println("클라이언트 접속 대기");
				// Socket : 클라이언트와 통신을 하는 객체. 가상 공간에 서버와 클라이언트가 공간을 공유...?
				// 클라이언트가 들어올 때까지 대기.
				Socket client = server.accept();
				// 클라이언트 접속 상태
				// Thread 객체를 이용하여 클라이언트와 통신함.
				Runnable1 r = new Runnable1(client);
				Thread ht = new Thread(r);
				// Thread ht = new Thread(new Runnable1(client));
				ht.start();// Thread 작동.
				/*
				 * 1. Stack 병렬화. 2. run 메서드 호출.
				 */
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
