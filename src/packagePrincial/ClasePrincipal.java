package packagePrincial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClasePrincipal {

	/*
	Write a function that takes in a string of one or more words, 
	and returns the same string, but with all five or more letter 
	words reversed (Just like the name of this Kata). Strings passed 
	in will consist of only letters and spaces. Spaces will be included 
	only when more than one word is present
	spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw" 
	spinWords( "This is a test") => returns "This is a test" 
	spinWords( "This is another test" )=> returns "This is rehtona test"	
	*/
	public static String spinWords(String sentence) {
		String finalText = "";
        List<String> textList = new ArrayList<String>();
        textList = Arrays.asList(sentence.split(" "));
        for(String wordByWord : textList) {
        	if(wordByWord.length() >= 5) {
	        	StringBuilder sb = new StringBuilder();
	        	sb.append(wordByWord);
	        	sb.reverse();
	        	wordByWord = sb.toString();
        	}
        	finalText = finalText.concat(" ".concat(wordByWord));
        }
        return finalText.strip();
        
        /*best practice
        public String spinWords(String sentence) {
		  String[] words = sentence.split(" ");
		  for (int i=0; i<words.length; i++) {
		    if (words[i].length() >= 5) {
		      words[i] = new StringBuilder(words[i]).reverse().toString();
		    }
		  }
		  return String.join(" ",words);
		}
         */
	}
	
	public static String maskify(String str) {
		StringBuilder sb = new StringBuilder(str);
		for(int i=0; (i+4)<str.length(); i++) {
			sb.replace(i, i+1, "#");
		}
		return sb.toString();
    }
	
	/*best practice
	public static String maskify(String str) {
        return str.replaceAll(".(?=.{4})", "#");
    }
	*/

	/*best practice
	public static long digPow(int n, int p) {
    	String intString = String.valueOf(n);
    	long sum = 0;
    	for (int i = 0; i < intString.length(); ++i, ++p)
      		sum += Math.pow(Character.getNumericValue(intString.charAt(i)), p);
    	return (sum % n == 0) ? sum / n : -1;
	}
	 */

	/*digPow
	public static long digPow(int n, int p) {
		long powerValue = powerValue(n, p);
		if((((int)(powerValue/n))*n)==powerValue)
			return (int)powerValue/n;
		return -1;
	}

	public static long powerValue(int n, int p){
		if(n<10){
			return (long)Math.pow(n,p);
		}
		int sizeNumber = (int)Integer.toString(n).length();
		int newN = (int)Math.pow((n%10),(p+sizeNumber-1));
		return newN+powerValue((n/10), p);
	}

	//test
	//powerValue(89,1);	//1
	//powerValue(92,1);	//-1
	//powerValue(46288,3)	//51
	//powerValue(123,8)	//-1
	*/

	public static void main(String[] args) {
		//test
	}

}
