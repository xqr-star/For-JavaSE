public class Second {
	public static void main(String[] args) {
		/**
		 * 这是测试看看utf-8 是否成功
		 */


	}
	public static void main7(String[] args) {
		byte a=10;
		byte b=20;
		byte c=(byte)(a+b);
		System.out.println(c);
		//byte c = (byte)(a + b);
	}
	public static void main6(String[] args) {
		int a=10;
		long b=20;
		int c=(int)(a+b);

	}
	public static void main5(String[] args) {
		
		int a=10;
		boolean flag =true;
		//a=flag;

	}
	
	 //int --double 
	
	
	public static void main4(String[] args) {
		int a=10;
		double b=12.3;
		a=(int)b;
	}
	public static void main3(String[] args) {
		
		int a=10;
		long b=20;
		//a=(int)b;
		b=a;
		System.out.println(b);
		//System.out.println(a);
	}
	public static void main2(String[] args) {
		final int a;
		a=10;
		int b=a+10;
		System.out.println(b);
	}
	public static void main1(String[] args) {
       int a=10;
       int c=a+20;
       System.out.println(a);
       System.out.println(c);
       final int b=20;
       // b=21;
       int d=b+1;
       System.out.println(b);
       System.out.println(d);
 	}
}



