package string;

import java.util.HashMap;
import java.util.Map;

//o(n)
public class KUniqueCharacters {

    public int longestSubstring(String str, int k) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        int left =0;
        int maxSize =0;
        //expanding by moving the right pointer
        for(int right=0;right<str.length();right++){

            char rightChar =str.charAt(right);
            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar,0)+1);
            //compressing by moving the left pointer
            while(charFrequency.size()>k) {
                char leftChar = str.charAt(left);
                charFrequency.put(leftChar, charFrequency.get(leftChar)-1);
                if(charFrequency.get(leftChar)==0){
                    charFrequency.remove(leftChar);
                }
                left++;
            }

            //when freq is k unique characters,
            if(charFrequency.size()==k && right-left+1 > maxSize){
                maxSize = right-left+1;
            }
        }
        return maxSize;
    }

}
