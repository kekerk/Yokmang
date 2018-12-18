package util;

import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

import logic.User;

// ��ȿ�� ���� Ŭ����
// Validator �������̽��� ������ ���� Ŭ������ �ۼ��Ǿ����
public class UserValidator implements Validator {

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
		
		// birthDay�� UserEntryControllerŬ������ initBinder() �޼���� Ÿ�� ����.
		// messages.properties���� typeMismatch.birthDay�� �����س��⶧���� ���� reject���������ʾƵ� �˾Ƽ� ��.
		
		if (errors.hasErrors()) {	// ��ȿ���� �����ʴ� �����Ͱ� �ִ� ���. �Ķ���� ���� �ϳ��� �Էµ��� ���� ���
			errors.reject("error.input.user");	// global error�� ó��
		}
	}

}
