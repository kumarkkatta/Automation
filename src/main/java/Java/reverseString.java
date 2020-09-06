
package Java;

public class reverseString {

	public static void main(String[] args)
	{
		String str = "This is selenium";
		
			char[]ch = str.toCharArray();
			for(int i=ch.length-1;i>=0;i--)
			{
				System.out.print(ch[i]);
			}
		
		StringBuilder sb = new StringBuilder(str);
		
		System.out.println(sb.reverse());
		
	}

}
