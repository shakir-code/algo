package trees;

import java.util.Stack;

public class StackSort {
    public void sort(Stack<Integer> mainStack) {
        Stack<Integer> newStack = new Stack<>();
        //all values from mainStack are arranged in descending order
        //from top in newStack
        while(!mainStack.isEmpty()){
            int temp = mainStack.pop();
            //check and pop all those values that are greater than temp
            //and push them back to stack1
            while(newStack.size()!=0 && newStack.peek()>temp){
                mainStack.push(newStack.pop());
            }
            //now peek value will be less than temp or newStack is empty
            newStack.push(temp);
        }

        //iterate and pop one value from newStack and push it to mainStack
        //mainStack will be in ascending order from the top
    }

}
