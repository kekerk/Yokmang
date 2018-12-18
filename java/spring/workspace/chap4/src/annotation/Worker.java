package annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component //��üȭ. ã�� �� Component scan�� ���ؼ� �ش� Ŭ������ ã�Ƽ� ��üȭ
@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS) //��ȸ�� ��ü ����
public class Worker {
	public void work(WorkUnit unit) {
		System.out.println(this+"work:"+unit); 
	}
}
/*
 * ������̼�
 * @Component : Ŭ���� ���� ����
 * 				�ش� Ŭ������ ��üȭ�Ͽ� �����̳ʿ� ����. ��ü�� �̸�(�ҹ��ڷ� �����ϴ� Ŭ�����̸�)       (property�� id�Ӽ�[����])
 * @Autowired : ���� ���� �� ����, �޼��� ���� ������ ����
 * 				�����̳ʿ� ����� ��ü �� �ڷ����� ��ġ�ϴ� ��ü�� �ٷ� ����.
 * @Scope(..) : ��ü�� ������ �� ������ ���ϰ�, ��ȸ������ ������. ����ÿ��� �ٽ� ��ü�� ������		 
 */
