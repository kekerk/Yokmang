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

	@RequestMapping(method = RequestMethod.GET) // userEntry.shop 요청이 GET방식일 경우 호출
	public String userEntryForm() {
		return "userEntry"; // view 이름 리턴. 데이터 없음.
	}

	@ModelAttribute
	public User getUser() { // view에 modeltAttribute="user"
		return new User(); // User객체가 view에 전달됨
	}

	// userEntryForm() 과 getUser()을 합쳐서 이렇게 작성해도 된다.

	// @RequestMapping(method = RequestMethod.GET)
	// public String userEntryForm() {
	// ModelAndView mav = new ModelAndView();
	// mav.addObject(new User());
	// return mav;
	// }

	@RequestMapping(method = RequestMethod.POST) // userEntry.shop 요청이 POST방식일 경우 호출
	public ModelAndView userEntry(User user, BindingResult bindResult) {
		// user : form에서 전달된 파라미터 값을 저장하고 있음 (스프링엔진이 알아서 자동으로 넣어줌)
		// bindResult : 유효성 검증의 결과를 저장하는 객체

		ModelAndView mav = new ModelAndView(); // userEntry.shop으로 요청된 경우 userEntry가 기본 View로 설정됨
		// ModelAndView mav = new ModelAndView("a"); // View 이름을 a로 설정

		userValidator.validate(user, bindResult); // 유효성 검사

		if (bindResult.hasErrors()) { // 입력 오류가 발생한 경우
			mav.getModel().putAll(bindResult.getModel());
			return mav;
		}
		try {
			shopService.insertUser(user);
			mav.addObject("user", user);
		} catch (DataIntegrityViolationException e) {	// 중복키 오류. spring jdbc 부분에서만 사용가능!
			bindResult.reject("error.duplicate.user");	// 출력할 중복키 오류 설정
			mav.getModel().putAll(bindResult.getModel());
			return mav;
		}
		mav.setViewName("userEntrySuccess");	// 입력 성공 시 이동할 View
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
