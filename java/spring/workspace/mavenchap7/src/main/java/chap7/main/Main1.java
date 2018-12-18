package chap7.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import chap7.spring.WriteImpl;

public class Main1 {
	   public static void main(String[] args) {
	      AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:aop.xml");
	      WriteImpl bean = ctx.getBean("write", WriteImpl.class);
	      bean.write();//핵심 알고리즘
	   }
	}