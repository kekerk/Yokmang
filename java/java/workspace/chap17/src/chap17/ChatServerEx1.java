package chap17;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

//��Ƽ ä�� ���� ���α׷� ����
public class ChatServerEx1 {
	static Hashtable<String, ObjectOutputStream> hm = new Hashtable<String, ObjectOutputStream>();

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(6000); //���� ����.
		System.out.println("ä�ü��� �����մϴ�.");
		while (true) {
			System.out.println("Ŭ���̾�Ʈ ���� �����");
			Socket client = server.accept(); //��� ����.
			ChatServerThread ct = new ChatServerThread(client);
			ct.start();
		}
	}
// ���ӵ� Ŭ���̾�Ʈ���� �Ѱ��� ����.
	static class ChatServerThread extends Thread {
		Socket client;
		ObjectInputStream ois; //Ŭ���̾�Ʈ�� ������ �޼��� read�� ���� �Է� ��Ʈ��.
		ObjectOutputStream oos; //Ŭ���̾�Ʈ�� ������ �޼��� write�� ���� ��� ��Ʈ��.
		String userid; //���� �̸�.
		ChatServerThread(Socket client) {
			this.client = client;
			try { // �аų� �� �� �ֵ��� ois,oos 
				ois = new ObjectInputStream(client.getInputStream());
				oos = new ObjectOutputStream(client.getOutputStream());
				userid = (String) ois.readObject();
				synchronized (hm) {
					hm.put(userid, oos);
				}
				broadcast(userid + "���� �����ϼ̽��ϴ�.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ��� Ŭ���̾�Ʈ���� �޼��� ���� ����.
		private void broadcast(String msg) {
			try {// �ٸ� ����� ������ ���ο��� �޼��� ����.
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
					rcvData = (String) ois.readObject(); //Ŭ���̾�Ʈ�� ���� �б�.
					if (rcvData.equals("/bye"))
						break;
					else if (rcvData.startsWith("/to")) //�ӼӸ�
						sendMsg(rcvData); //�ӼӸ�
					else
						broadcast(userid + ":" + rcvData);

				}
					}  catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					broadcast(userid + "���� �����ϼ̽��ϴ�."); 
					hm.remove(userid);
					try {
						if (client != null)
							client.close();
					} catch (IOException e) {
					}
				}
			}
		//�ӼӸ� : �Ѹ��Ѹ� ���׸� ������ �޼���. /to userid �޼���
		private void sendMsg(String rcvData) {
			int begin = rcvData.indexOf(" ") + 1; //userid�� ���� �ε���
			int end = rcvData.indexOf(" ", begin); //userid�� ���� �ε��� +1
			if (end != -1) {
				String id = rcvData.substring(begin, end); //��� userid�� id�� ����.
				String msg = rcvData.substring(end + 1); // �ӼӸ� ������ msg�� �ѱ�.
				ObjectOutputStream oos = hm.get(id);  // oos�� ��� userid�� ��½�Ʈ��.
				ObjectOutputStream oos2 = hm.get(userid); // oos2�� ���� userid�� ��½�Ʈ��.
				if (oos != null) { //������� ������ ���.
					try {
						oos.writeObject(userid + "���� �ӼӸ�: " + msg); //�������:userid >> ȫ�浿���� �ӼӸ� : ����
						oos.flush();
						oos2.writeObject(id + "�Կ��� �ӼӸ� ����: " + msg);
						oos2.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
