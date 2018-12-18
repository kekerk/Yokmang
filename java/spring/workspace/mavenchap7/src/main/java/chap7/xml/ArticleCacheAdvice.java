package chap7.xml;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class ArticleCacheAdvice {
	private Map<Integer,Article> cache = new HashMap<Integer,Article>();
	// cache(1,Article(1) 객체) 저장된 상태. 25번째 줄 [cache.put(id, ret);]에 의해.
	public Article cache(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("[ACA] cache before 실행");
		// joinPoint.getArgs() : 핵심알고리즘의 매개변수 목록
		// id : 1
		Integer id = (Integer)joinPoint.getArgs()[0];
		Article article = cache.get(id);
		if(article != null) { //기존의 Article 객체가 저장되어 있음.
			System.out.println("[ACA] cache에서 Article["+id+"] 가져옴");
			return article;
		}
		Article ret = (Article)joinPoint.proceed(); //다음 메서드 실행.
		// ret : Article(1) 객체. 핵심 알고리즘이 리턴객체.
		System.out.println("[ACA] cache after 실행");
		if(ret != null) {
			cache.put(id, ret);
			System.out.println("[ACA] cache에 Article["+id+"] 객체를 추가함.");
		}
		return ret;
	}
}
