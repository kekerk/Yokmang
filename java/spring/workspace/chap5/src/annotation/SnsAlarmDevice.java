package annotation;

import org.springframework.stereotype.Component;


//AlarmDevice -> SnsAlarmDevice 
public class SnsAlarmDevice implements AlarmDevice{

	@Override
	public void alarm(String name) {
		System.out.println(name+"���� ħ�� Ž����. �Ű� ���");		
	}

}
