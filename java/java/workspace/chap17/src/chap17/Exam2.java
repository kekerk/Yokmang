package chap17;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import chap17.SimpleWebServerEx1.HttpThread;
/*
 * ������ �� ���� �����ϱ� : �̹������Ϸ� ó�� �ǵ��� ���α׷� �ۼ��ϱ�.
 * 1. ������ ����Ʈ���Է½�Ʈ������ �б�.
 * 2. Ŭ���̾�Ʈ�� ���۽� ����Ʈ�� �Է� ��Ʈ��.
 */
public class Exam2 {

	public static void main(String[] args) {
		try {
			// ServerSocket : 8000�� ��Ʈ�� �Ҵ�ޱ� : ���ε�.
			ServerSocket server = new ServerSocket(8000);
			while (true) {
				System.out.println("Ŭ���̾�Ʈ ���� ���");
				//Socket : Ŭ���̾�Ʈ�� ����� �ϴ� ��ü. ���� ������ ������ Ŭ���̾�Ʈ�� ������ ����...?
				// Ŭ���̾�Ʈ�� ���� ������ ���.
				Socket client = server.accept(); 
				// Ŭ���̾�Ʈ ���� ����
				// Thread ��ü�� �̿��Ͽ� Ŭ���̾�Ʈ�� �����.
				HttpThread ht = new HttpThread(client);
				ht.start();//Thread �۵�.
				/*
				 * 1. Stack ����ȭ.
				 * 2. run �޼��� ȣ��.
				 */
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//���� Ŭ����.
	static class HttpThread extends Thread {
		private Socket client; //���ӵ� Socket ��ü.
		BufferedReader br; //Ŭ���̾�Ʈ ������ ���� �Է½�Ʈ�� ��ü.
		OutputStream pw; // Ŭ���̾�Ʈ�� ������ ������ ����Ʈ�� ��½�Ʈ��.
		
		HttpThread(Socket client){// ������. ��ü�� �����ϱ� ���ؼ�.
			this.client = client;
			try {
				//client.getInputStream() : Ŭ���̾�Ʈ�� ������ �޼��� ����.
				br = new BufferedReader //���پ� �б����� reader�� ������.
						(new InputStreamReader(client.getInputStream()));
				//client.getOutputStream() :������ Ŭ���̾�Ʈ�� ������ �޼����� ���.					
				pw = client.getOutputStream();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		public void run() {
			FileInputStream fbr = null;
			try {
				//line : Ŭ���̾�Ʈ�� ������ �޼���.
				//line�� ���� : GET /' ' HTTP/ 1.1
				String line = br.readLine();
				System.out.println(line);
				int start = line.indexOf("/") +1;
				int end = line.lastIndexOf("HTTP")-1;
				String fileName = line.substring(start,end);
				if(fileName.equals("")) {
					fileName = "index.html";
				}
				System.out.println("Ŭ���̾�Ʈ ��û ����: "+fileName);
				//���پ� �б� ���� BufferdReader ���.
				//fbr : ��û�� ������ �б����� �Է� ��Ʈ��.
				fbr = new FileInputStream(fileName);
				int fileLine = 0;
				byte[] buf = new byte[1024];
				while((fileLine = fbr.read(buf))!= -1) {
					//���پ� �������� ���ư���. �׸��� �Ľ� ������ ���� ��� ����.
					pw.write(buf,0,fileLine);
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
		} //run �޼��� ����. Thread : dead ����.
	}

}
