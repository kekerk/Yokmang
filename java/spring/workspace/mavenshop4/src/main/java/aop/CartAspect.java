package aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import exception.CartEmptyException;
import exception.LoginException;
import logic.Cart;
import logic.User;

@Component //��üȭ
@Aspect    //���� ��ü�� AOP ��ü ����
public class CartAspect {
	/*
	 * advice �߿� Around : �ٽ� logic�� ���� ��, ���� �� ��� ȣ��Ǵ� AOP �޼���
	 */
	@Around("execution(* controller.Cart*.check*(..))") // �ٽ� �˰��� "execution(* controller.Cart*.check*(..))"
	public Object userLoginCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		// joinPoint.getArgs() : �ٽɾ˰����� �Ű����� ���
		HttpSession session = (HttpSession)joinPoint.getArgs()[0];
		Cart cart = (Cart) session.getAttribute("CART");
		User loginUser = (User) session.getAttribute("loginUser");
		if(loginUser == null) { //�α����� �ȵ� ���
			throw new LoginException("�α��� �� �ŷ��ϼ���","../user/loginForm.shop");
		}
		if(cart == null || cart.isEmpty()) {
			throw new CartEmptyException("��ٱ��ϰ� ������ϴ�.","../item/list.shop");
		}
		Object ret = joinPoint.proceed(); 
		return ret;
	}
}
