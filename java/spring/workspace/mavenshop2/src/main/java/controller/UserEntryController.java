package controller;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.ShopService;
import logic.User;
import util.UserValidator;

public class UserEntryController {
	private ShopService shopService;
	private UserValidator userValidator;

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	public void setUserValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}

	@RequestMapping(method = RequestMethod.GET) // userEntry.shop ��û�� GET����� ��� ȣ��
	public String userEntryForm() {
		return "userEntry"; // view �̸� ����. ������ ����.
	}

	@ModelAttribute
	public User getUser() { // view�� modeltAttribute="user"
		return new User(); // User��ü�� view�� ���޵�
	}

	// userEntryForm() �� getUser()�� ���ļ� �̷��� �ۼ��ص� �ȴ�.

	// @RequestMapping(method = RequestMethod.GET)
	// public String userEntryForm() {
	// ModelAndView mav = new ModelAndView();
	// mav.addObject(new User());
	// return mav;
	// }

	@RequestMapping(method = RequestMethod.POST) // userEntry.shop ��û�� POST����� ��� ȣ��
	public ModelAndView userEntry(User user, BindingResult bindResult) {
		// user : form���� ���޵� �Ķ���� ���� �����ϰ� ���� (������������ �˾Ƽ� �ڵ����� �־���)
		// bindResult : ��ȿ�� ������ ����� �����ϴ� ��ü

		ModelAndView mav = new ModelAndView(); // userEntry.shop���� ��û�� ��� userEntry�� �⺻ View�� ������
		// ModelAndView mav = new ModelAndView("a"); // View �̸��� a�� ����

		userValidator.validate(user, bindResult); // ��ȿ�� �˻�

		if (bindResult.hasErrors()) { // �Է� ������ �߻��� ���
			mav.getModel().putAll(bindResult.getModel());
			return mav;
		}
		try {
			shopService.insertUser(user);
			mav.addObject("user", user);
		} catch (DataIntegrityViolationException e) {	// �ߺ�Ű ����. spring jdbc �κп����� ��밡��!
			bindResult.reject("error.duplicate.user");	// ����� �ߺ�Ű ���� ����
			mav.getModel().putAll(bindResult.getModel());
			return mav;
		}
		mav.setViewName("userEntrySuccess");	// �Է� ���� �� �̵��� View
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
