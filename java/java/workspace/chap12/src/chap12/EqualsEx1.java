package chap12;
/*
 * 
 */
class Equal{
	String str;
	int value;
	Equal(int value){
		this.value= value;
	}
	
	Equal(String str){
		this.str = str;
	}
	
	
	@Override
	public int hashCode() {
		
		return str.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Equal) {
			Equal e = (Equal)obj;
			return value == e.value;
		}else {
			return false;
		}
	}
}
public class EqualsEx1 {
	public static void main(String[] args) {
		Equal e1 = new Equal(10);
		Equal e2 = new Equal(10);
		if(e1==e2) {
			System.out.println("e1�� e2�� ���� ��ü��");
		}else {
			System.out.println("e1�� e2�� �ٸ� ��ü��");
		}
		
		if(e1.equals(e2)) { //.equals()�� Object�� ���. ���� ��ü�� true, �ٸ� ��ü�� false  
			System.out.println("e1�� e2�� ������ ���� ��ü��");
		} else {
			System.out.println("e1�� e2�� ������ �ٸ� ��ü��");
		}
	}
}
