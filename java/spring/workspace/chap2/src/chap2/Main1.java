package chap2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main1 {

	public static void main(String[] args) {
		// ctx : �����̳�
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		// g:chap2.Greeter(format ���� : %s, �ȳ��ϼ���! ����) ��ü ����
		Greeter g = ctx.getBean("greeter",Greeter.class);
		System.out.println(g.greet("������"));
		Greeter g2 =ctx.getBean("greeter", Greeter.class);
		if(g==g2) {
			System.out.println("g�� g2 ��ü�� ����.");
		}else {
			System.out.println("g�� g2 ��ü�� �ٸ���.");
		}
		ctx.close();
	}

}
