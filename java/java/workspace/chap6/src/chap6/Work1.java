package chap6;
// 2����  ��� ���� �� ���ϱ�
public class Work1 {
	public static void main(String[] args) {
		int arr[][]= {{10,20},{30,40},{50,60,70}};
		int maxcol = 0;
		for(int i=0;i<arr.length;i++) {
			if(maxcol < arr[i].length) {
				maxcol = arr[i].length;
			}}
			
		int tot[] = new int[maxcol];
		for(int i=0;i<arr.length;i++) {
			int sum = 0;
			for(int j=0;j<arr[i].length;j++) {
				sum += arr[i][j];
				tot[j]+=arr[i][j];
			}
			System.out.println(i+"���� ��: "+sum);
		}
		for(int i=0;i<tot.length;i++) {
			System.out.println(i+"���� ��: "+ tot[i]);
		}
	}

}
