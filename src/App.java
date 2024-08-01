import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    /*
	 * Write a function that takes in a string of one or more words,
	 * and returns the same string, but with all five or more letter
	 * words reversed (Just like the name of this Kata). Strings passed
	 * in will consist of only letters and spaces. Spaces will be included
	 * only when more than one word is present
	 * spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
	 * spinWords( "This is a test") => returns "This is a test"
	 * spinWords( "This is another test" )=> returns "This is rehtona test"
	 */
	public static String spinWords(String sentence) {
		String finalText = "";
		List<String> textList = new ArrayList<String>();
		textList = Arrays.asList(sentence.split(" "));
		for (String wordByWord : textList) {
			if (wordByWord.length() >= 5) {
				StringBuilder sb = new StringBuilder();
				sb.append(wordByWord);
				sb.reverse();
				wordByWord = sb.toString();
			}
			finalText = finalText.concat(" ".concat(wordByWord));
		}
		return finalText.strip();

		/*
		 * best practice
		 * public String spinWords(String sentence) {
		 * String[] words = sentence.split(" ");
		 * for (int i=0; i<words.length; i++) {
		 * if (words[i].length() >= 5) {
		 * words[i] = new StringBuilder(words[i]).reverse().toString();
		 * }
		 * }
		 * return String.join(" ",words);
		 * }
		 */
	}

	public static String maskify(String str) {
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; (i + 4) < str.length(); i++) {
			sb.replace(i, i + 1, "#");
		}
		return sb.toString();
	}

	/*
	 * best practice
	 * public static String maskify(String str) {
	 * return str.replaceAll(".(?=.{4})", "#");
	 * }
	 */

	public static boolean isValid(String braces) {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("(", ")");
		hashMap.put("[", "]");
		hashMap.put("(", ")");

		for (Map.Entry<String, String> en : hashMap.entrySet())
			if (!(braces.contains(en.getKey()) && braces.contains(en.getValue())))
				return false;
		return true;
	}

	public static String[] splitStrings(String text){
		String[] finalList = new String[(int)Math.ceil(text.length()/2.0)];
		int i = 0;
		while(text.length()>0){
			if(text.length()>1){
				finalList[i] = text.substring(0, 2);
				text=text.substring(2);
			}else{
				finalList[i] = text.substring(0).concat("_");
				text="";
			}
			i++;
		}
		return finalList;
	}

	//best solution
	/*
	public class StringSplit {
		public static String[] solution(String s) {
			s = (s.length() % 2 == 0)?s:s+"_";
			return s.split("(?<=\\G.{2})");
		}
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

    //BitCounting
    //Write a function that takes an integer as input, and returns the number of bits that are equal to one in the binary representation of that number. You can guarantee that input is non-negative. Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case
    public static int numbersOneInBinary(int num){
        String binaryNum = invertNum(binaryValues(num));
        int cont = 0;
        for(int i=0; i<binaryNum.length(); i++){
            if(Integer.parseInt(String.valueOf(binaryNum.charAt(i)))==1){
                cont++;
            }
        }
        return cont;
    }

    public static String invertNum(String num){
        String invertedNum = "";
        for(int i=num.length()-1; i>=0; i--){
            invertedNum+=String.valueOf(num.charAt(i));
        }
        return invertedNum;
    }
    
    public static String binaryValues(int num){
        return num<=0 ? "" : (num%2) + binaryValues(num/2);
        //Integer.toBinaryString(num).chars().filter(charNum -> charNum == '1').count();    //solución rápida
    }

    //Best practice
    //1
    // public static int countBits(int n){
    //     int ret = n % 2;
    // while ((n /= 2) > 0) ret += n % 2;
    // return ret;
    // }
    
    //2
    // public static int countBits(int n){		
    //     return Integer.bitCount(n);
    // }
    //BitCounting

	public static void main(String[] args) {
		// System.out.println(spinWords("Welcome"));
		// System.out.println(maskify("William Wun"));
		// System.out.println(isValid("(){}[]"));
		// System.out.println(isValid("([{}])"));
		// System.out.println(isValid("(}"));
		// System.out.println(isValid("[(])"));
		// System.out.println(isValid("[({})](]"));
		// System.out.println(isValid("()"));
		// System.out.println(Arrays.toString(splitStrings("abcd")));
        
        System.out.println(numbersOneInBinary(75));
        System.out.println(Integer.toBinaryString(75).chars().filter(charNum -> charNum == '1').count());
	}
}
