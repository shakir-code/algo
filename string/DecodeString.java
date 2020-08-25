package string;

public class DecodeString {
    int pointer=0;

    public String decode(String str){

        StringBuilder runningString = new StringBuilder();
        int lastIndexOfNumber =0;
        int iterations=0;
        String returnedStr = "";
        while(pointer< str.length() && str.charAt(pointer)!=']'){

            if(Character.isDigit(str.charAt(pointer))) {
             lastIndexOfNumber = pointer;
                while (Character.isDigit(str.charAt(lastIndexOfNumber))) {
                    lastIndexOfNumber++;

                }
                iterations = Integer.parseInt(str.substring(pointer, lastIndexOfNumber));
                pointer = lastIndexOfNumber+1;
                returnedStr = decode(str);
                for(int i=0;i<iterations;i++){
                    runningString.append(returnedStr);
                }
            } else if(Character.isAlphabetic(str.charAt(pointer))){
                runningString.append(str.charAt(pointer));
                pointer++;
            }
        }

        if(pointer< str.length()) pointer++;
        return runningString.toString();
    }
}
