package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			double num1 = Double.parseDouble(request.getParameter("num1"));
			double num2 = Double.parseDouble(request.getParameter("num2"));
			String op = request.getParameter("op");
			double tot = 0.0;
			switch (op) {
			case "+":
				tot = num1 + num2;
				break;
			case "-":
				tot = num1 - num2;
				break;
			case "*":
				tot = num1 * num2;
				break;
			case "/":
				tot = num1 / num2;
				break;
			}
			request.setAttribute("result", tot);
		} catch (NumberFormatException e) {
			request.setAttribute("result", 0);
		}
		return new ActionForward(false, "calc.jsp");

	}
}
