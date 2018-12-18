package websocket;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {
	// ������ ������ ���� �ִ�.
	Set<WebSocketSession> clients = new HashSet<WebSocketSession>();

	@Override// ���� ����� ȣ��Ǵ� �޼���
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session,status);
		System.out.println("Ŭ���̾�Ʈ ������ ������ : "+status.getReason());
	}

	
	@Override// ����Ǿ��� �� ȣ��Ǵ� �޼���
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		System.out.println("Ŭ���̾�Ʈ ���ӵ�.");
		clients.add(session);
	}


	@Override// �޼��� ���� �� ȣ��Ǵ� �޼���
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		String payloadMessage = (String) message.getPayload();
		System.out.println("������ ������ �޼��� : "+payloadMessage);
		clients.add(session);
		// clients : ���� handler�� ��ϵ� ��� client ��� ����
		for(WebSocketSession s : clients) {
			s.sendMessage(new TextMessage(payloadMessage));//�ٸ� Ŭ���̾�Ʈ�鿡�� �޼��� ����
		}
	}

	@Override //���� �߻��� ȣ��Ǵ� �޼���
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		super.handleTransportError(session, exception);
		System.out.println("���� �߻��� : "+exception.getMessage());
	}	
}
