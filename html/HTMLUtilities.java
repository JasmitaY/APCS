/**
 *	Utilities for handling HTML
 *  In this program we practice using a file IO and string manipulation in order to 
 *  create a simple HTML tokenizer. When we tokenize the HTML code from a file we break it 
 *  down by first simply work on tokenizing the tags that start with < and end with >. 
 *  Then we tokenize the words, then punctuation and then numbers. All these tokens 
 *  are continuously stored in one big array. In part 2 we worked on enhancing the project
 *  and worked on our program to handle multiline constructs, specifically the HTML 
 *  comments and pre-formatted text.
 *
 *	@author	Jasmita Yechuri
 *	@since	November 9, 2020
 */
public class HTMLUtilities 
{
	/* none is for not is nest block, comment for inside a comment block and pre-format
	   is inside the pre-format block
	*/
	private enum TokenState {NONE, COMMENT, PREFORMAT}; 
	private TokenState state = TokenState.NONE; // token state

	/**
	 *	Break the HTML string into tokens. The array returned is
	 *	exactly the size of the number of tokens in the HTML string.
	 *	Example:	HTML string = "Goodnight moon goodnight stars"
	 *				returns { "Goodnight", "moon", "goodnight", "stars" }
	 *	@param str			the HTML string
	 *	@return				the String array of tokens
	 */
	public String[] tokenizeHTMLString(String str) 
	{
		// make the size of the array large to start
		String[] result = new String[10000];
		String[] endValue;
		
		int num  = 0;
		int val = 0;
		int length = 0;
		
		for(int i = 0; i < result.length; i++)
		{
			result[i] = "";
		}
		
		// Checks to see if token is a comment and continues to check until its end '>'
		// 1 - tokenize the tags
		if(state == TokenState.COMMENT) 
		{
				do {
					val++;
				} while(val < str.length() && str.charAt(val) != '>');
				
				if(val == str.length() && str.charAt(val-1) == '>')
				{
					 state = TokenState.NONE;
				}
				else if(val < str.length() && str.charAt(val) == '>')
				{
					 state = TokenState.NONE;
				}
		}
			
			
		/* A loop to go index by index you would check the indexs to see if the include 
			anything symbolizing either a preformat or a comment if it is comment, 
			then u ignore and if it is preformat, then you keep the spaces. Otherwise, 
			continue with part1 of htmlUtilities
		*/
		for(val = val; val < str.length(); val++)
		{
			char indexChar = str.charAt(val);
			if(indexChar == '<' && state == TokenState.NONE) 
			{
				if(str.charAt(val + 1) == '!' && str.charAt(val + 2) == '-') 
				{
					state = TokenState.COMMENT;
					do {
						val++;
					} while(val < str.length() && indexChar != '>');
					
					if(val == str.length() && str.charAt(val-1) == '>') 
					{
						state = TokenState.NONE;
					}
					else if(val < str.length() && str.charAt(val) == '>')
					{
						state = TokenState.NONE;
					} 
				}
				
				// checks to see of </pre by looking at each index and character
				else if(val < str.length() - 4 && str.charAt(val + 1) == 'p' 
						&& str.charAt(val + 2) == 'r' && str.charAt(val + 3) == 'e'
						&& str.charAt(val + 4) == '>') 
				{
					state = TokenState.PREFORMAT;
					val--;
				}
				
				// continue to tokenize until it reaches '>'
				else 
				{
					int place = val;
					char ch;
					do {
						ch = str.charAt(place);
						result[num ] += ch;
						place++;
					} while(ch != '>');
					
					val = place- 1;
					num ++;
				}	
			}
			
			// checks to see of </pre by looking at each index and character
			else if(state == TokenState.PREFORMAT) 
			{
				if(val < str.length() - 5 && str.charAt(val + 1) == '/' 
						&& str.charAt(val + 2) == 'p' && str.charAt(val + 3) == 'r' 
						&& str.charAt(val + 4) == 'e' && str.charAt(val + 5) == '>')
				{
					result[num ] = "</pre";
					val += 5;
					state = TokenState.NONE;
				}
				while((val < str.length() - 5 && str.charAt(val + 1) != '/' 
						&& str.charAt(val + 2) != 'p' && str.charAt(val + 3) != 'r' 
						&& str.charAt(val + 4) != 'e' && str.charAt(val + 5) != '>') 
						|| val < str.length())
					{
						result[num] += str.charAt(val);
						val++;
					}
			}
			
			/* 2- Tokenize words:
				The conditional would look for a letter, finds the firs < and last > and tokenizes
				and copies all the contents into the array. */
				
			else if(Character.isLetter(indexChar) && state == TokenState.NONE)
			{
				int place = val;
				char ch;
				do 
				{
					ch = str.charAt(place);
					result[num ] += ch;
					place++;
				} while(place < str.length() && Character.isLetter(str.charAt(place)) &&
				 str.charAt(place) != ' ' && str.charAt(place) != '<' && !isPunctucation(str.charAt(place)));
				
				val = place - 1;
				num ++;
			}
		
			/* 	2 and 4- Tokenize numbers + word:
				 And for number so within the 
				conditional, you also have to check for all those cases and then you find when 
				the number actually ends and then add that number to the array. The special 
				cases are when the number has a negative sign, e or a '.' in it - hardcode
			*/
			else if(((indexChar > 47 && indexChar < 58) || (val < str.length() - 1 && indexChar == '-' && 
				str.charAt(val + 1) != ' ')) && state == TokenState.NONE)
			{
				int place = val;
				char ch;
				do {
					ch = str.charAt(place);
					result[num] += ch;
					place++;
				} while(place < str.length() && (((str.charAt(place) > 47 && str.charAt(place) < 58)) 
					|| (place < str.length() - 1 && str.charAt(place) == '.' && (str.charAt(place+1) > 47 && str.charAt(place+1) < 58)))
					|| (place < str.length() && str.charAt(place) == 'e') || (place < str.length() && str.charAt(place) == '-'));	
				
				val = place - 1;
				num ++;
			}
			
			/* 3 - Tokenize punctuation: isPunctuation, with all possibilities of the punctuations
				it check to see if the current index is a type of punctuation and if it is, 
			 	then add it to the array 
			 */
			else if((isPunctucation(indexChar) || indexChar == '-') && state == TokenState.NONE )
			{
				result[num] += indexChar;
				num ++;
			}

		}
		
		// Keep going unless there is an array index with nothing inside
		while(result[length] != "")
		{
			length++;
		}	
		
		// a array that stores all the tokens and switch between result and endValue
		endValue  = new String[length];
		for(int i = 0; i < length; i++)
		{
			endValue [i] = result[i];
		}
		
		return endValue ; // an array with all the tokens
	}
	/**
	 *	A method that holds all the punctuation used to tekenize the punctuation
	 *	@param punct		a char punct with checks to see if it is either of the punctuations
	 *  @return boolean 	if a punction then tokenize if not then continue with code
	 */
	public boolean isPunctucation(char punct) 
	{
		if(punct == '.' || punct == ',' || punct == ';' || punct == ':' || punct == '(' || punct == ')' 
		|| punct == '?' || punct == '!' || punct == '=' || punct == '&' || punct == '~' || punct == '+')
		{
			 return true;
		}
		return false;
	}
	
	/**
	 *	Print the tokens in the array to the screen
	 *	Precondition: All elements in the array are valid String objects.
	 *				(no nulls)
	 *	@param tokens		an array of String tokens
	 */
	public void printTokens(String[] tokens) {
		if (tokens == null) return;
		for (int a = 0; a < tokens.length; a++) {
			if (a % 5 == 0) System.out.print("\n  ");
			System.out.print("[token " + a + "]: " + tokens[a] + " ");
		}
		System.out.println();
	}
}