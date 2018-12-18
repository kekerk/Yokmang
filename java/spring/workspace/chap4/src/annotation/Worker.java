package annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component //객체화. 찾을 때 Component scan을 통해서 해당 클래스를 찾아서 객체화
@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS) //일회용 객체 생성
public class Worker {
	public void work(WorkUnit unit) {
		System.out.println(this+"work:"+unit); 
	}
}
/*
 * 어노테이션
 * @Component : 클래스 위에 구현
 * 				해당 클래스를 객체화하여 컨테이너에 저장. 객체의 이름(소문자로 시작하는 클래스이름)       (property의 id속성[유일])
 * @Autowired : 변수 선언 시 구현, 메서드 선언 부위에 구현
 * 				컨테이너에 저장된 객체 중 자료형이 일치하는 객체를 바로 주입.
 * @Scope(..) : 객체를 주입할 때 재사용을 안하고, 일회용으로 주입함. 재사용시에는 다시 객체를 생성함		 
 */
