package stacksAndQueues;

import java.util.Stack;

public class ValidateStacks {
    public boolean validateStackSequences(int[] pushed, int[] popped){

        Stack<Integer> stack = new Stack<>();
        if(popped.length==0 && pushed.length==0){
            return true;
        }
        stack.push(pushed[0]);
        int pushedIndex=1;
        int poppedIndex=0;
        while(pushedIndex<pushed.length || poppedIndex<popped.length) {

            if(stack.size()!=0 && stack.peek()==popped[poppedIndex]){
                stack.pop();
                poppedIndex++;
            } else {
                if(pushedIndex>=pushed.length){
                    break;
                }
                stack.push(pushed[pushedIndex]);
                pushedIndex++;
            }
        }

        if(stack.size()==0) {
            return true;
        }

        return false;

    }
}
