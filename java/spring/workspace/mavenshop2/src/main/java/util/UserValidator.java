package util;

import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

import logic.User;

// 유효성 검증 클래스
// Validator 인터페이스를 구현한 구현 클래스로 작성되어야함
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return User.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// obj : 파라미터값을 저장하고 있는 User객체
		User user = (User) obj;
		String group = "error.required";
		if (user.getUserId() == null || user.getUserId().length() == 0) {
			errors.rejectValue("userId", group);	// error.required.userId
		}
		if (user.getPassword() == null || user.getPassword().length() == 0) {
			errors.rejectValue("password", group);	// error.required.password
		}
		if (user.getUserName() == null || user.getUserName().length() == 0) {
			errors.rejectValue("userName", group);	// error.required.userName
		}
		if (user.getPhoneNo() == null || user.getPhoneNo().length() == 0) {
			errors.rejectValue("phoneNo", group);
		}
		if (user.getPostcode() == null || user.getPostcode().length() == 0) {
			errors.rejectValue("postcode", group);	
		}
		if (user.getAddress() == null || user.getAddress().length() == 0) {
			errors.rejectValue("address", group);	
		}
		if (user.getEmail() == null || user.getEmail().length() == 0) {
			errors.rejectValue("email", group);	
		}
		
		// birthDay는 UserEntryController클래스의 initBinder() 메서드로 타입 설정.
		// messages.properties에서 typeMismatch.birthDay로 지정해놨기때문에 따로 reject설정하지않아도 알아서 비교.
		
		if (errors.hasErrors()) {	// 유효성에 맞지않는 데이터가 있는 경우. 파라미터 값이 하나라도 입력되지 않은 경우
			errors.reject("error.input.user");	// global error로 처리
		}
	}

}
