package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.ShopService;
import logic.User;
import util.LoginValidator;

public class LoginController {
	private ShopService shopService;
	private LoginValidator loginValidator;

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	public void setLoginValidator(LoginValidator loginValidator) {
		this.loginValidator = loginValidator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String loginForm() {
		return "login";
	}

	@ModelAttribute
	public User getUser() {
		return new User();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView login(User user, BindingResult bindResult, HttpSession session) {
		// user ��ü : �Ķ���� userId�� password ���� �����.
		ModelAndView mav = new ModelAndView();
		loginValidator.validate(user, bindResult); //�Է°� ����
		if (bindResult.hasErrors()) { //�Է°� ���� �߻� ��(id�� password �� �Ѱ� �̻� �Է��� �ȵ� ���)
			mav.getModel().putAll(bindResult.getModel());
			return mav;
		}
		//���̵� �н����尡 ��� �Էµ� ���
		try {
			// selectUser : ���̵� �ش��ϴ� db�� ����� ���� ����
			User selectedUser = shopService.loginUser(user.getUserId());
			// ���̵� �����ϴ� ���
			if (user.getPassword().equals(selectedUser.getPassword())) { // ���̵�� ��й�ȣ�� ��ġ�ϴ� ���.
				session.setAttribute("loginUser", selectedUser); //�α��� ����
			} else { //��й�ȣ�� ��ġ���� �ʴ� ���.
				bindResult.reject("error.login.password");
				mav.getModel().putAll(bindResult.getModel());
				return mav;
			}
		} catch (EmptyResultDataAccessException e) { // �ش� ���̵� ���� ������ db�� ���� ��� �߻�.
													 // ������������ �߻��Ǵ� ����.(myBatis������ �߻����� ����)
			bindResult.reject("error.login.id");
			mav.getModel().putAll(bindResult.getModel());
			return mav;
		}
		mav.setViewName("loginSuccess"); //�α����� �����ϴ� ��츸 ����.
		return mav;
	}

	@InitBinder // �ʱⰪ ���� ������̼�
	public void initBinder(WebDataBinder binder) { // �Ķ���Ͱ� ����ȯ�� ���� �޼���
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//      Date.class : �Ķ���Ͱ��� Date Ÿ������ ����ȯ. User��ü�� Date�� ������ Ÿ���̿����� 
//     new CustomDateEditor(dateFormat, boolean��) : �Ķ���� ����ȯ. ������ dateFormat�� ����. 
//             - true : ���Է��� �����. �Է½ÿ��� ������ ������� 
//             - false : �ݵ�� �Է��ؾ���
//       
//       ������ Ʋ�� ��� : typeMismatch.�Ķ�����̸� �ڵ带 ������ �����

	}
}
