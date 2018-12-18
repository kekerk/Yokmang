package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //��üȭ ����� �Ǵ� Ŭ����. executor �̸����� �����̳ʿ� �����
public class Executor {
	@Autowired //�����̳ʿ� ���� ��ü �� Worker ��ü�� ã�Ƽ� ����. DI. ���������ڰ� private�� �������� ���� ����.
	private Worker worker;
	
	public void addUnit(WorkUnit workunit) {
		worker.work(workunit);
	}
	
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
}
