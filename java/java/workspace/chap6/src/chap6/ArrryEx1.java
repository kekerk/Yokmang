package chap6;

public class ArrryEx1 {
	public static void main(String[] args) {
		int[] arr1; //�迭 (��������) ����.
		
		
		arr1 = new int[5]; //�迭 ��ü ����  //new �� ��ü�� ���� �� �⺻�� 0 ����
		arr1[0] = 10; // �迭�� �ʱ�ȭ
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
	    //������ for ��: ÷�� ��� �Ұ� (new?)
		
		for(int a : arr1) {  
			System.out.println(a);  // a�� ���� [0]~�� ��� ��.
		}
	}

}
