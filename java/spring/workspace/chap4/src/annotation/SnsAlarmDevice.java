package annotation;

import org.springframework.stereotype.Component;

@Component
//AlarmDevice -> SnsAlarmDevice 
public class SnsAlarmDevice implements AlarmDevice{

	@Override
	public void alarm(String name) {
		System.out.println(name+"¿¡¼­ Ä§ÀÔ Å½ÁöµÊ. ½Å°í ¿ä¸Á");		
	}

}
