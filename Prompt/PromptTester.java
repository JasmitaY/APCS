/**
 *	Test the Prompt class
 *	@author	Jasmita Yechuri
 *	@since	September 10, 2020
 */

public class PromptTester {

	public static void main(String[] args) {
		String str = Prompt.getString("Provide me a string");
		System.out.println("Here it is -> " + str);
		
		int a = Prompt.getInt("Give me an integer");
		System.out.println("Here it is -> " + a);
		
		a = Prompt.getInt("Give me an integer", 20, 40);
		System.out.println("Here it is -> " + a);
		
		String str2 = Prompt.getString("Provide me a char");
		System.out.println("Here it is -> " + str2);
		
		double b = Prompt.getDouble("Give me an double");
		System.out.println("Here it is -> " + b);
		
		b = Prompt.getDouble("Give me an double", 20.0, 40.0);
		System.out.println("Here it is -> " + b);  
		
	}

}