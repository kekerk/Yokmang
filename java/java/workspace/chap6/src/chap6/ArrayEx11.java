package chap6;

public class ArrayEx11 {

	public static void main(String[] args) {
		//1.�����迭 ����
		int[][] arr = new int[10][];
		//2.�迭 ��ü ����
		for(int i = 0 ; i<arr.length;i++) {
			arr[i] = new int[i+1];
		}
		//3.�迭�� ���� ����
		int data = 0;
		for(int j=9;j>=0;j--) {
			for(int i=j;i<arr.length;i++) {
				arr[i][j] = ++data;
			}
		}
		//�迭�� �� ����ϱ�.
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+"\t");
			}
		System.out.println();
		}
	}

}
