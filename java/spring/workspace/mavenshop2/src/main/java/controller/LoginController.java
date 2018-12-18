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
		// user 객체 : 파라미터 userId와 password 값만 저장됨.
		ModelAndView mav = new ModelAndView();
		loginValidator.validate(user, bindResult); //입력값 검증
		if (bindResult.hasErrors()) { //입력값 오류 발생 시(id나 password 중 한개 이상 입력이 안된 경우)
			mav.getModel().putAll(bindResult.getModel());
			return mav;
		}
		//아이디 패스워드가 모두 입력된 경우
		try {
			// selectUser : 아이디에 해당하는 db의 사용자 정보 저장
			User selectedUser = shopService.loginUser(user.getUserId());
			// 아이디 존재하는 경우
			if (user.getPassword().equals(selectedUser.getPassword())) { // 아이디와 비밀번호가 일치하는 경우.
				session.setAttribute("loginUser", selectedUser); //로그인 성공
			} else { //비밀번호가 일치하지 않는 경우.
				bindResult.reject("error.login.password");
				mav.getModel().putAll(bindResult.getModel());
				return mav;
			}
		} catch (EmptyResultDataAccessException e) { // 해당 아이디에 대한 정보가 db에 없을 경우 발생.
													 // 스프링에서만 발생되는 예외.(myBatis에서는 발생되지 않음)
			bindResult.reject("error.login.id");
			mav.getModel().putAll(bindResult.getModel());
			return mav;
		}
		mav.setViewName("loginSuccess"); //로그인이 성공하는 경우만 설정.
		return mav;
	}

	@InitBinder // 초기값 설정 어노테이션
	public void initBinder(WebDataBinder binder) { // 파라미터값 형변환을 위한 메서드
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//      Date.class : 파라미터값을 Date 타입으로 형변환. User객체의 Date와 동일한 타입이여야함 
//     new CustomDateEditor(dateFormat, boolean값) : 파라미터 형변환. 형식은 dateFormat을 따름. 
//             - true : 비입력을 허용함. 입력시에는 형식을 맞춰야함 
//             - false : 반드시 입력해야함
//       
//       형식이 틀린 경우 : typeMismatch.파라미터이름 코드를 오류로 등록함

	}
}
