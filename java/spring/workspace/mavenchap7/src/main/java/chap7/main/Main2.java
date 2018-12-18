package chap7.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chap7.xml.Article;
import chap7.xml.ArticleNotFoundException;
import chap7.xml.Member;
import chap7.xml.MemberService;
import chap7.xml.ReadArticleService;
import chap7.xml.UpdateInfo;

public class Main2 {

	public static void main(String[] args) {
		String[] config = {"di.xml","aop2.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
		ReadArticleService service = ctx.getBean("readArticleService",ReadArticleService.class);
		try {
			Article a1 = service.getArticleAndReadCnt(1); //A
			/*
			   [ACA] cache before 실행(2)
               [LA]메서드 실행 전 전처리 수행함.(3)
               getArticleAndReadCnt(1) 호출됨
               [LA]메서드 정상 처리 후 수행함. 리턴값 : chap7.xml.Article@21507a04(3)
               [LA]메서드 실행 후 후처리 수행함.(3)
               [ACA] cache after 실행(2)
               [ACA] cache에 Article[1] 객체를 추가함.(2)
			 */
			Article a2 = service.getArticleAndReadCnt(1); //B
			/*
			   [ACA] cache before 실행(2)
               [ACA] cache에서 Article[1] 가져옴(2)
               (joinPoint.proceed() 실행 x : 핵심 알고리즘 실행 안함)
			 */
			System.out.println("[main] a1==a2 : "+(a1==a2));
			//[main] a1==a2 : true
			service.getArticleAndReadCnt(0);              //C
			/*
			   [ACA] cache before 실행(2)
               [LA]메서드 실행 전 전처리 수행함.(3)
               getArticleAndReadCnt(0) 호출됨
               [LA]메서드 예외 발생 후 수행함. 예외 :id는 0이 안됨(3)
               [LA]메서드 실행 후 후처리 수행함.(3)
			 */
		}catch(ArticleNotFoundException e) {
			System.err.println("[main] "+e.getMessage());
			//[main] id는 0이 안됨
		}
		System.out.println("\n=== updateMemberInfoTrace Aspect 연습"); 
		MemberService memberService = ctx.getBean("memberService",MemberService.class); 
		memberService.regist(new Member());
		memberService.update("hong",new UpdateInfo());
		memberService.delete("hong2","test");
		
	}
}
