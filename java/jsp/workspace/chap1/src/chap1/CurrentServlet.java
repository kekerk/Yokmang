package chap1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// url : /CurrentServlet ��û�� ȣ��Ǵ� ����.
//@WebServlet("/CurrentServlet")
public class CurrentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public CurrentServlet() {
        super();
     }
	//GET ������� ��û�� ȣ��Ǵ� �޼��� (�⺻ ��û ���)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request : ��û��ü.
		// response : ���䰴ü. �������� ���۵Ǵ� ��ü.
		response.setContentType("text/html; charset=EUC-KR" );  // html ���¿� �ѱ� �������� Ÿ���� �� ���̶�� ����.
		PrintWriter out = response.getWriter(); //������ ��� ��Ʈ�� ���·� �������� ������ ������ ����ϴ� ��ü. println �κи� ���ư���.
		out.println("<html><head><title>���� �ð�</title></head>");
		out.println("<body>");
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int min = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		out.println("<h1>"+hour+"��"+min+"��"+second+"��</h1>");
		out.println("</body></html>");
	}

	//POST ������� ��û�� ȣ��Ǵ� �޼���	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
