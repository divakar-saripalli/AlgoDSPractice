package src.com.div.mission.faang.hackerrank;

public class VowelsSubstring {

    public static String findSubstring(String s, int k) {
	// Write your code here
	boolean vowelExists = false;
	for (int i = 0; i < s.length(); i++){
	    if(isVowel(s.charAt(i))){
		vowelExists = true;
		break;
	    }
	}

	if(vowelExists){
	    String substring = s.substring(0, k);
	    int vowelsCounter = 0;
	    int maxVowelsCount = 0;
	    for(int i = 0; i < substring.length(); i++){
		if(isVowel(s.charAt(i))){
		    vowelsCounter++;
		}
	    }
	    int startIndex = 0;
	    maxVowelsCount = vowelsCounter;
	    for(int i = k, j = 0; i < s.length(); i++, j++){
		if(isVowel(s.charAt(j)) && !isVowel(s.charAt(i))){
		    vowelsCounter--;
		}else if(!isVowel(s.charAt(j)) && isVowel(s.charAt(i))){
		    vowelsCounter++;
		}

		if(maxVowelsCount < vowelsCounter){
		    maxVowelsCount = vowelsCounter;
		    startIndex = j+1;
		}
	    }
	    String finalString = s.substring(startIndex, k);
	    return finalString;
	}else{
	    return "Not found";
	}
    }

    public static boolean isVowel(char letter){
	if(letter == 'a' ||
			letter == 'e'||
			letter == 'i'||
			letter == 'o'||
			letter == 'u'){
	    return true;
	}
	return false;
    }

    public static void main(String[] args) {
	System.out.println(findSubstring("azerdii", 5));
    }
}
