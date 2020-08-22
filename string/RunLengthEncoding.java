package string;

public class RunLengthEncoding {

    public void encode(String str){
        for(int i=0;i<str.length();i++){
            int count =1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)) {
                count++;
                i++;
            }
            System.out.println(str.charAt(i));
            System.out.println(count);
        }
    }
}
