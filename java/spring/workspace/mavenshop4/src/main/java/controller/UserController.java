package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import exception.LoginException;
import logic.Item;
import logic.Sale;
import logic.SaleItem;
import logic.ShopService;
import logic.User;
import util.CiperUtil;
/*
 * 1. ȸ�� ����/���� �� �̸����� ��ȣȭ�Ͽ� db�� �����ϱ�
 * 2. ��ȸ �� ��ȣȭ �Ͽ� ȭ�鿡 ���
 * 	  ȸ�� ��ȸ, admin�� ȸ�� ��� ��ȸ
 */
@Controller
public class UserController {

	@Autowired
	ShopService service;

	@RequestMapping("user/userForm")
	public ModelAndView userForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject(new User());
		return mav;
	}

	@RequestMapping("user/loginForm")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("user/login");
		mav.addObject(new User());
		return mav;
	}

	@RequestMapping("user/login")
	public ModelAndView login(@Valid User user, BindingResult bindResult, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if (bindResult.hasErrors()) {
			mav.getModel().putAll(bindResult.getModel());
			return mav;
		}
		try {
			User selectedUser = service.selectUser(user.getUserId());
			if(selectedUser == null) {
				bindResult.reject("error.login.id");
				mav.getModel().putAll(bindResult.getModel());
				return mav;
			}
			if (service.getHashValue(user.getPassword()).equals(selectedUser.getPassword())) {
				session.setAttribute("loginUser", selectedUser);
				mav.setViewName("/user/loginSuccess");
			} else {
				bindResult.reject("error.login.password");
				mav.getModel().putAll(bindResult.getModel());
				return mav;
			}
		} catch (Exception e) {
			e.printStackTrace();
			bindResult.reject("error.login.id");
			mav.getModel().putAll(bindResult.getModel());
			return mav;
		}
		return mav;
	}

	@RequestMapping("user/userEntry")
	public ModelAndView userEntry(@Valid User user, BindingResult bindResult) {
		ModelAndView mav = new ModelAndView("user/userForm");
		if (bindResult.hasErrors()) {
			mav.getModel().putAll(bindResult.getModel());
			return mav;
		}
		try {
			service.userCreate(user);
			mav.setViewName("user/login");
			mav.addObject("user", user);
		} catch (DataIntegrityViolationException e) {
			bindResult.reject("error.duplicate.user");
		}
		return mav;
	}

	@RequestMapping("user/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.invalidate();
		mav.setViewName("redirect:loginForm.shop");
		return mav;
	}

	@RequestMapping("user/mypage")
	public ModelAndView mypage(String id, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User user = service.selectUser(id);
		// sale ���̺��� �ش� ����ڰ� �ֹ��� ���� ��� ��ȸ
		List<Sale> salelist = service.SaleList(id);
		for (Sale s : salelist) {
			// �ֹ� ��ȣ�� ���� �ش� �ֹ��� ���Ե� ��ǰ��� list ��ü�� ����
			List<SaleItem> saleItemlist = service.SaleItemlist(s.getSaleId());
			for (SaleItem si : saleItemlist) {
				Item item = service.getItem(si.getItemId());
				si.setItem(item);
			}
			s.setItemList(saleItemlist);
		}
		mav.addObject("user", user);
		mav.addObject("salelist", salelist);
		return mav;
	}

	@RequestMapping("user/updateForm")
	public ModelAndView updateForm(String id, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User user = service.selectUser(id);
		mav.addObject("user", user);
		return mav;
	}

	/*
	 * �Ķ���� ������ user ��ü�� ���� ��й�ȣ�� ��ġ�ϴ� ��츸 ȸ������ ���� ���� ���� :mypage.shop ���� ����
	 * :updateForm.shop
	 */
	@RequestMapping("user/update")
	public ModelAndView update(@Valid User user, BindingResult bindResult, HttpSession session) {
		ModelAndView mav = new ModelAndView("user/updateForm");
		if (bindResult.hasErrors()) {
			mav.getModel().putAll(bindResult.getModel());
			return mav;
		}
		User dbuser = service.selectUser(user.getUserId());
		if (service.getHashValue(user.getPassword()).equals(dbuser.getPassword())) {
			try {
				service.update(user);
				mav.setViewName("redirect:../user/mypage.shop?id=" + user.getUserId());
			} catch (Exception e) {
				e.printStackTrace();
				bindResult.reject("error.user.update");
				mav.getModel().putAll(bindResult.getModel());
			}
		} else {
			bindResult.reject("error.login.password");
			mav.getModel().putAll(bindResult.getModel());
		}
		return mav;
	}

/*	 ȸ�� Ż��(GET)
	 admin�� ��� Ż����� �ʵ��� ó��
	 1.�����ڰ� �ٸ� ȸ���� ���� Ż��
	 1)��й�ȣ�� ������ ��й�ȣ�� �Է��ϱ�.
	 2)�����ں�й�ȣ�� �´� ��� ȸ�� ���� ����.
	 3)����Ż�� ���� : redirect:admin/list.shop �̵�
	 4)����Ż�� ���� : ���� �߻� �� delete.shop �������� ���
	 2.���� ȸ�� Ż��
	 1)��й�ȣ�� ȸ�� ��й�ȣ �Է��ϱ�
	 2)��й�ȣ�� �´� ��� ȸ�� ���� ����
	 Ż�� ���� : session ���� �� loginForm.shop ������ �̵�
	 Ż�� ���� : ���ܹ߻� �� delete.jsp �������� ���*/
	@RequestMapping(value = "user/delete", method = RequestMethod.GET)
	public ModelAndView delete(String id, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User user = service.selectUser(id);
		mav.addObject("user", user);
		return mav;
	}

	// ȸ��Ż��(POST)
	@RequestMapping(value = "user/delete", method = RequestMethod.POST)
	public ModelAndView delete(String id, HttpSession session, String password) {
		ModelAndView mav = new ModelAndView();
		User loginUser = (User) session.getAttribute("loginUser"); // ���� �α��ε� ����
		if (loginUser.getPassword().equals(service.getHashValue(password))) { // �н����� ��ġ
			try {
				service.deleteUser(id);
				if (!loginUser.getUserId().equals("admin")) { // �����ڰ� �ƴ� ���
					session.invalidate();
					mav.setViewName("redirect:loginForm.shop");
				} else { // �������� ���
					mav.setViewName("redirect:../admin/list.shop");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new LoginException("Ż�� ����", "../user/delete.shop?id=" + id);
			}
		} else {// �н����� ����ġ
			throw new LoginException("��й�ȣ ����", "../user/delete.shop?id=" + id);
		}
		return mav;
	}

	@InitBinder // ��¥���� �ʱ� ����
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
