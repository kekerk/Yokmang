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
			System.out.println("e1과 e2는 같은 객체임");
		}else {
			System.out.println("e1과 e2는 다른 객체임");
		}
		
		if(e1.equals(e2)) { //.equals()는 Object의 멤버. 같은 객체면 true, 다른 객체면 false  
			System.out.println("e1과 e2는 내용이 같은 객체임");
		} else {
			System.out.println("e1과 e2는 내용이 다른 객체임");
		}
	}
}
