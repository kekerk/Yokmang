package chap6;

public class W1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int sum=0;
		  for(int a=2; a<12; a++)
		  {
		   System.out.print("(");
		   for(int b=1; b<a; b++)
		   {
		    if(b==1)
		     System.out.print("");
		    else
		    System.out.print("+");
		    System.out.print(b);
		    sum=sum+b;
		   }
		   if(a==11)
		    System.out.print(")");
		   else
		   System.out.print(")" + "+");
		  }
		  System.out.print("=" + sum);
	}

}
