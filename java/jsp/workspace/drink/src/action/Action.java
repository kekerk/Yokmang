package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��Ű���� �̸����� �빮�ڸ� ���� �ʴ°��� ����.
public interface Action {
	ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception;
}
