package chap2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Message m = ctx.getBean("message", Message.class);
		m.sayHello("홍길동"); //인터페이스의 기능을 끌어온다.
	}

}
