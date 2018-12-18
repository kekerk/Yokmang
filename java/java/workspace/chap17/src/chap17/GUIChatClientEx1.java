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

//멀티 채팅 클라이언트 프로그램
//awt : 자바에서 GUI환경을 실행.
// Frame : 윈도우 창.
public class GUIChatClientEx1 extends Frame implements ActionListener {
	CardLayout c1;
	String userid;
	Button btnexit, btnsend, btnconnect;
	TextArea talist;
	TextField tfip, tfname, tfinput;
	ObjectOutputStream oos;
	ObjectInputStream ois;

	GUIChatClientEx1() { //생성자.
		super("채팅프로그램");//frame의 타이틀 집어넣기.
		c1 = new CardLayout(); //카드처럼 보겠다.
		setLayout(c1); //Frame의 setLayout() : Frame의 배치관리자를 c1(CardLayout)으로 설정.
		Panel connect = new Panel();// 
		connect.setLayout(new BorderLayout()); //connect Panel의 배치관리자 설정.
		connect.add("North", new Label("채팅접속화면", Label.CENTER));

		Panel conn_sub = new Panel();
		conn_sub.setLayout(new GridLayout(10, 1)); //표형태 10행 1열의 형태로 만듦.
		conn_sub.add(new Label("서버 IP", Label.CENTER));
		tfip = new TextField("192.168.0.87", 15);
		conn_sub.add(tfip);
		conn_sub.add(new Label("사용자 ID", Label.CENTER));
		tfname = new TextField("홍길동", 15);
		conn_sub.add(tfname);
		connect.add("Center", conn_sub);
		btnconnect = new Button("서버접속");
		connect.add("South", btnconnect);
		btnconnect.addActionListener(this);

		Panel chat = new Panel();
		chat.setLayout(new BorderLayout());

		chat.add("North", new Label("채팅 ver1.0"));
		talist = new TextArea();
		chat.add("Center", talist);
		Panel chat_sub = new Panel();
		tfinput = new TextField("", 25);
		btnexit = new Button("종료");
		btnsend = new Button("전송");
		chat_sub.add(tfinput);
		chat_sub.add(btnexit);
		chat_sub.add(btnsend);

		//Listener  : 이벤트 처리에 활용. 
		//.addActionListener() : 리스너 등록.
		tfinput.addActionListener(this);  // 리스너 등록. 엔터키가 입력되면
		btnexit.addActionListener(this);  //btnexit 버튼 클릭되면 리스너 등록.
		btnsend.addActionListener(this);  //btnsend 버튼 클릭되면 리스너 등록.  전부 action
		chat.add("South", chat_sub);
		add(connect, "접속창");
		add(chat, "채팅창");
		c1.show(this, "접속창");
		setSize(300, 300); //윈도우 크기 지정.
		setVisible(true); //윈도우가 화면에 표시됨.
		//이벤트 등록.
		addWindowListener(new WindowAdapter() {
			//윈도우창 닫을때
			public void windowClosing(WindowEvent e) {
				System.exit(0); //프로세스 종료.
			}
		});

	}

	public static void main(String[] args) {
		new GUIChatClientEx1();

	}
	// 이벤트 핸들러 
	@Override
	public void actionPerformed(ActionEvent e) {  //이름없는 내부 클래스.
		try {
			Object obj = e.getSource();  
			if (obj == btnconnect) { //btnconnect 버튼 클릭된 경우.
				init();

			} else if (obj == btnexit) { //btnexit 버튼 클릭된 경우
				System.exit(0);
			} else if (obj == btnsend || obj == tfinput) { //btnsend, tfinput : 
				String sendData = tfinput.getText(); // 입력된 내용.
				oos.writeObject(sendData); //server단으로 입력된 내용을 보낸다.
				oos.flush();
				tfinput.setText(""); // 입력된 내용 삭제.
				tfinput.requestFocus(); // focus를 유지.
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
			oos.writeObject(userid); //userid를 서버에 전송.
			oos.flush();
			// 서버에서 전송된 메세지를 read()를 위한 Thread. TextArea에 표시.
			ReceiveDataThread rt = new ReceiveDataThread(); 
			rt.setDaemon(true); // 살아있는 동안 계속 돈다.
			rt.start(); 
			
			c1.show(this, "채팅창"); //chat 패널로 화면 변경.
			setTitle(userid + " 채팅창"); //홍길동 채팅창. 윈도우 창의 title 변경.
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
