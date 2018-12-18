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
		// obj : �Ķ���Ͱ��� �����ϰ� �ִ� User��ü
				User user = (User) obj;
				String group = "error.required";
				if (user.getUserId() == null || user.getUserId().length() == 0) {
					errors.rejectValue("userId", group);	// error.required.userId
				}
				if (user.getPassword() == null || user.getPassword().length() == 0) {
					errors.rejectValue("password", group);	// error.required.password
				}
				
				if (errors.hasErrors()) {	// ��ȿ���� �����ʴ� �����Ͱ� �ִ� ���. �Ķ���� ���� �ϳ��� �Էµ��� ���� ���
					errors.reject("error.input.user");	// global error�� ó��
				}
		
	}

}
