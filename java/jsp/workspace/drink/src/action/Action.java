package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//패키지의 이름에는 대문자를 쓰지 않는것이 좋다.
public interface Action {
	ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception;
}
