package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
	@RequestMapping("chat/chat")
	public String chat() {
		return null;//������ "chat/chat" : view�̸� ����. null�� �־ chat/chat.jsp�� �̵��Ѵ�.(null�� ��� url�� "chat/chat"�̹Ƿ�, view�� chat/chat.jsp�� ����
	}
}
