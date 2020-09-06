package Java;

public class middlecharacter {

	public static void main(String[] args) {
		
		String str="Selenium Automation";
		middlecharac(str);
	}

	public static void middlecharac(String str)
	{
		int length = str.length();
		int middleindex= length/2;
		
		System.out.println(str.charAt(middleindex));
	}
	
	
}
