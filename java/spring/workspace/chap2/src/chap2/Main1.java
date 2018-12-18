package chap2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main1 {

	public static void main(String[] args) {
		// ctx : 컨테이너
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		// g:chap2.Greeter(format 변수 : %s, 안녕하세요! 저장) 객체 참조
		Greeter g = ctx.getBean("greeter",Greeter.class);
		System.out.println(g.greet("스프링"));
		Greeter g2 =ctx.getBean("greeter", Greeter.class);
		if(g==g2) {
			System.out.println("g와 g2 객체는 같다.");
		}else {
			System.out.println("g와 g2 객체는 다르다.");
		}
		ctx.close();
	}

}
