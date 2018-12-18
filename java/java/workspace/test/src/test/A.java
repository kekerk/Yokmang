package test;

public class A {
	public static void main(String[] args) {
		  String str = "ABC";
		  System.out.println(format(str, 7, 0));
		  System.out.println(format(str, 7, 1));
		  System.out.println(format(str, 7, 2));
		 }

		 public static String format(String str, int length, int alignment) {
		  StringBuffer sb = new StringBuffer();
		  for(int i=0;i<=length;i++) {
		   sb = sb.append(" ");
		  }
		  switch (alignment) {
		  case 0:
		   sb.replace(0,3,str);
		   break;
		  case 1:
		   sb.replace(2,5,str);
		   break;
		  case 2:
		   sb.replace(4,7,str);
		   break;
		  }
		  
		  return sb.toString();
		  
		 }

}
