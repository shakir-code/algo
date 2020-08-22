package string;

import java.util.HashMap;

public class MinimumWindowString {

    public String getSubString(String str, String pattern) {
        HashMap<Character, Integer> referenceMap = new HashMap<>();

        int referenceCount = pattern.length();
        for (int i = 0; i <pattern.length();i++) {
            if(!referenceMap.containsKey(pattern.charAt(i))){
                referenceMap.put(pattern.charAt(i), 1);
            } else {
                int count = referenceMap.get(pattern.charAt(i));
                referenceMap.put(pattern.charAt(i), count+1);
            }

        }

        int left = 0;
        int right = 0;
        int leftMin = 0;
        int rightMin = 0;
        int minSize = str.length()+1;
        HashMap<Character, Integer> runningMap = new HashMap<>();
        int runningCount = 0;

        if(referenceMap.containsKey(str.charAt(right))){
            runningCount = add(str, referenceMap, right, runningMap, runningCount);
        }
        while(!(right==str.length()-1 && runningCount!=referenceCount)){
            if(runningCount<referenceCount) {
                right++;
                //add to running map
                if(referenceMap.containsKey(str.charAt(right))){
                    runningCount = add(str, referenceMap, right, runningMap, runningCount);
                }

            } else {
                //remove from running map
                if(referenceMap.containsKey(str.charAt(left))){
                    if(runningMap.containsKey(str.charAt(left))){
                        int temp = runningMap.get(str.charAt(left));
                        runningMap.replace(str.charAt(left), temp-1);
                        if(runningMap.get(str.charAt(left))<referenceMap.get(str.charAt(left))){
                            runningCount--;
                        }
                    }
                }

                if(minSize>(right-left+1)){
                    minSize = right -left+1;
                    leftMin = left;
                    rightMin = right;
                }


                left++;

            }
        }
        if(minSize>str.length()){
            return "";
        }
        return str.substring(leftMin,rightMin+1);

    }

    private int add(String s, HashMap<Character, Integer> referenceMap, int right,
                    HashMap<Character, Integer> runningMap, int runningCount){
        if(!runningMap.containsKey(s.charAt(right))){
            runningMap.put(s.charAt(right), 1);
        } else {
            if(runningMap.get(s.charAt(right))<referenceMap.get(s.charAt(right))){
              runningCount++;
            }
            int temp = runningMap.get(s.charAt(right));
            runningMap.replace(s.charAt(right), temp+1);
        }
        return runningCount;

    }
}
