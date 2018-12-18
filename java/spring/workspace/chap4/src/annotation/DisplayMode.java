package annotation;

import org.springframework.beans.factory.annotation.Required;

public class DisplayMode {
	private String type;
	@Required //Autowired와 비슷한 기능. 단 (required=false) 설정이 안됨. 무조건 주입해야 함.
	public void setType(String type) {
		this.type=type;
	}
	public String getType() {
		return type;
	}
}
