package annotation;

import org.springframework.beans.factory.annotation.Required;

public class DisplayMode {
	private String type;
	@Required //Autowired�� ����� ���. �� (required=false) ������ �ȵ�. ������ �����ؾ� ��.
	public void setType(String type) {
		this.type=type;
	}
	public String getType() {
		return type;
	}
}
