package chap6;

/*
 * 다차원 배열
 */
public class ArrayEx7 {

	public static void main(String[] args) {
		int[][] arr = new int[3][2];
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[1][0] = 30;
		arr[1][1] = 40;
		arr[2][0] = 50;
		arr[2][1] = 60;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println("arr[" + i + "][" + j + "]=" + arr[i][j]);
			}
		}
		
		System.out.println("객체 변경");
		arr[1] = new int[] {1,2,3,4,5};
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println("arr[" + i + "][" + j + "]=" + arr[i][j]);
			}
		}
		
		int nums[] = arr[1];
		for(int i=0;i<nums.length;i++) {
			System.out.println("nums["+i+"]="+nums[i]);
			
			int[] s= new int[3];
//			s[0]= new int[] {2,4,6};
			
		}
		
	}

}
