package chap1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// url : /CurrentServlet 요청시 호출되는 서블릿.
//@WebServlet("/CurrentServlet")
public class CurrentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public CurrentServlet() {
        super();
     }
	//GET 방식으로 요청시 호출되는 메서드 (기본 요청 방식)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request : 요청객체.
		// response : 응답객체. 브라우저에 전송되는 객체.
		response.setContentType("text/html; charset=EUC-KR" );  // html 형태에 한글 형식으로 타입을 할 것이라고 설정.
		PrintWriter out = response.getWriter(); //문자형 출력 스트림 형태로 브라우저에 전송할 내용을 출력하는 객체. println 부분만 날아간다.
		out.println("<html><head><title>현재 시간</title></head>");
		out.println("<body>");
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int min = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		out.println("<h1>"+hour+"시"+min+"분"+second+"초</h1>");
		out.println("</body></html>");
	}

	//POST 방식으로 요청시 호출되는 메서드	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
