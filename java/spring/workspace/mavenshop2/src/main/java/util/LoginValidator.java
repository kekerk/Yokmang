package util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import logic.User;

public class LoginValidator implements Validator {

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
				
				if (errors.hasErrors()) {	// 유효성에 맞지않는 데이터가 있는 경우. 파라미터 값이 하나라도 입력되지 않은 경우
					errors.reject("error.input.user");	// global error로 처리
				}
		
	}

}
