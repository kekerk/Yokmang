package chap6;

public class ArrryEx1 {
	public static void main(String[] args) {
		int[] arr1; //배열 (참조변수) 선언.
		
		
		arr1 = new int[5]; //배열 객체 생성  //new 가 객체를 만들 때 기본값 0 지정
		arr1[0] = 10; // 배열값 초기화
		arr1[1] = 20;
		arr1[3] = 30;
		
		for(int i=0; i<arr1.length; i++) {
			System.out.println("arr1["+i+"]="+arr1[i]);
		}
		System.out.println("\n");
		int[] arr2=new int[5];
		arr2 = arr1;
		arr2[3]= 100;
		for(int i=0;i<arr2.length;i++) {
			System.out.println("arr2["+i+"]="+arr2[i]);
		}
	    //개선된 for 문: 첨자 사용 불가 (new?)
		
		for(int a : arr1) {  
			System.out.println(a);  // a의 값은 [0]~의 요소 값.
		}
	}

}
