package chap17;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//��Ƽ ä�� Ŭ���̾�Ʈ ���α׷�
//awt : �ڹٿ��� GUIȯ���� ����.
// Frame : ������ â.
public class GUIChatClientEx1 extends Frame implements ActionListener {
	CardLayout c1;
	String userid;
	Button btnexit, btnsend, btnconnect;
	TextArea talist;
	TextField tfip, tfname, tfinput;
	ObjectOutputStream oos;
	ObjectInputStream ois;

	GUIChatClientEx1() { //������.
		super("ä�����α׷�");//frame�� Ÿ��Ʋ ����ֱ�.
		c1 = new CardLayout(); //ī��ó�� ���ڴ�.
		setLayout(c1); //Frame�� setLayout() : Frame�� ��ġ�����ڸ� c1(CardLayout)���� ����.
		Panel connect = new Panel();// 
		connect.setLayout(new BorderLayout()); //connect Panel�� ��ġ������ ����.
		connect.add("North", new Label("ä������ȭ��", Label.CENTER));

		Panel conn_sub = new Panel();
		conn_sub.setLayout(new GridLayout(10, 1)); //ǥ���� 10�� 1���� ���·� ����.
		conn_sub.add(new Label("���� IP", Label.CENTER));
		tfip = new TextField("192.168.0.87", 15);
		conn_sub.add(tfip);
		conn_sub.add(new Label("����� ID", Label.CENTER));
		tfname = new TextField("ȫ�浿", 15);
		conn_sub.add(tfname);
		connect.add("Center", conn_sub);
		btnconnect = new Button("��������");
		connect.add("South", btnconnect);
		btnconnect.addActionListener(this);

		Panel chat = new Panel();
		chat.setLayout(new BorderLayout());

		chat.add("North", new Label("ä�� ver1.0"));
		talist = new TextArea();
		chat.add("Center", talist);
		Panel chat_sub = new Panel();
		tfinput = new TextField("", 25);
		btnexit = new Button("����");
		btnsend = new Button("����");
		chat_sub.add(tfinput);
		chat_sub.add(btnexit);
		chat_sub.add(btnsend);

		//Listener  : �̺�Ʈ ó���� Ȱ��. 
		//.addActionListener() : ������ ���.
		tfinput.addActionListener(this);  // ������ ���. ����Ű�� �ԷµǸ�
		btnexit.addActionListener(this);  //btnexit ��ư Ŭ���Ǹ� ������ ���.
		btnsend.addActionListener(this);  //btnsend ��ư Ŭ���Ǹ� ������ ���.  ���� action
		chat.add("South", chat_sub);
		add(connect, "����â");
		add(chat, "ä��â");
		c1.show(this, "����â");
		setSize(300, 300); //������ ũ�� ����.
		setVisible(true); //�����찡 ȭ�鿡 ǥ�õ�.
		//�̺�Ʈ ���.
		addWindowListener(new WindowAdapter() {
			//������â ������
			public void windowClosing(WindowEvent e) {
				System.exit(0); //���μ��� ����.
			}
		});

	}

	public static void main(String[] args) {
		new GUIChatClientEx1();

	}
	// �̺�Ʈ �ڵ鷯 
	@Override
	public void actionPerformed(ActionEvent e) {  //�̸����� ���� Ŭ����.
		try {
			Object obj = e.getSource();  
			if (obj == btnconnect) { //btnconnect ��ư Ŭ���� ���.
				init();

			} else if (obj == btnexit) { //btnexit ��ư Ŭ���� ���
				System.exit(0);
			} else if (obj == btnsend || obj == tfinput) { //btnsend, tfinput : 
				String sendData = tfinput.getText(); // �Էµ� ����.
				oos.writeObject(sendData); //server������ �Էµ� ������ ������.
				oos.flush();
				tfinput.setText(""); // �Էµ� ���� ����.
				tfinput.requestFocus(); // focus�� ����.
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private void init() {
		try {
			String ip = tfip.getText();
			Socket client = new Socket(ip, 6000);
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			userid = tfname.getText();
			oos.writeObject(userid); //userid�� ������ ����.
			oos.flush();
			// �������� ���۵� �޼����� read()�� ���� Thread. TextArea�� ǥ��.
			ReceiveDataThread rt = new ReceiveDataThread(); 
			rt.setDaemon(true); // ����ִ� ���� ��� ����.
			rt.start(); 
			
			c1.show(this, "ä��â"); //chat �гη� ȭ�� ����.
			setTitle(userid + " ä��â"); //ȫ�浿 ä��â. ������ â�� title ����.
			tfinput.requestFocus(); 

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	class ReceiveDataThread extends Thread{
		String rcvData;
		
		public void run() {
			try {
				while(true) {
					rcvData = (String) ois.readObject();
					talist.append(rcvData+"\n");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
