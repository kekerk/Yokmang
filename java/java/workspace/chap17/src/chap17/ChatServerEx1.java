package chap17;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

//멀티 채팅 서버 프로그램 예제
public class ChatServerEx1 {
	static Hashtable<String, ObjectOutputStream> hm = new Hashtable<String, ObjectOutputStream>();

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(6000); //서버 생성.
		System.out.println("채팅서버 시작합니다.");
		while (true) {
			System.out.println("클라이언트 서버 대기중");
			Socket client = server.accept(); //대기 상태.
			ChatServerThread ct = new ChatServerThread(client);
			ct.start();
		}
	}
// 접속된 클라이언트별로 한개씩 생성.
	static class ChatServerThread extends Thread {
		Socket client;
		ObjectInputStream ois; //클라이언트가 전송한 메세지 read를 위한 입력 스트림.
		ObjectOutputStream oos; //클라이언트로 전송할 메세지 write를 위한 출력 스트림.
		String userid; //나의 이름.
		ChatServerThread(Socket client) {
			this.client = client;
			try { // 읽거나 쓸 수 있도록 ois,oos 
				ois = new ObjectInputStream(client.getInputStream());
				oos = new ObjectOutputStream(client.getOutputStream());
				userid = (String) ois.readObject();
				synchronized (hm) {
					hm.put(userid, oos);
				}
				broadcast(userid + "님이 입장하셨습니다.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 모든 클라이언트에게 메세지 전송 가능.
		private void broadcast(String msg) {
			try {// 다른 사람이 들어오면 전부에게 메세지 보냄.
				for (ObjectOutputStream o : hm.values()) {
					o.writeObject(msg);
					o.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public void run() {
			String rcvData;
			try {
					while (true) {
					rcvData = (String) ois.readObject(); //클라이언트의 내용 읽기.
					if (rcvData.equals("/bye"))
						break;
					else if (rcvData.startsWith("/to")) //귓속말
						sendMsg(rcvData); //귓속말
					else
						broadcast(userid + ":" + rcvData);

				}
					}  catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					broadcast(userid + "님이 퇴장하셨습니다."); 
					hm.remove(userid);
					try {
						if (client != null)
							client.close();
					} catch (IOException e) {
					}
				}
			}
		//귓속말 : 한명한명 한테만 보내는 메서드. /to userid 메세지
		private void sendMsg(String rcvData) {
			int begin = rcvData.indexOf(" ") + 1; //userid의 시작 인덱스
			int end = rcvData.indexOf(" ", begin); //userid의 종료 인덱스 +1
			if (end != -1) {
				String id = rcvData.substring(begin, end); //상대 userid를 id로 넣음.
				String msg = rcvData.substring(end + 1); // 귓속말 내용을 msg로 넘김.
				ObjectOutputStream oos = hm.get(id);  // oos는 상대 userid의 출력스트림.
				ObjectOutputStream oos2 = hm.get(userid); // oos2는 본인 userid의 출력스트림.
				if (oos != null) { //상대편이 존재할 경우.
					try {
						oos.writeObject(userid + "님의 귓속말: " + msg); //보낸사람:userid >> 홍길동님의 귓속말 : 하하
						oos.flush();
						oos2.writeObject(id + "님에게 귓속말 전송: " + msg);
						oos2.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
