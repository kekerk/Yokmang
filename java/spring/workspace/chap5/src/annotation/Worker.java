package annotation;



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
