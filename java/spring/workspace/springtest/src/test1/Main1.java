package test1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main1 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
				Test1 t1 = ctx.getBean("test1",Test1.class);
				t1.hello();
		
	}

}
