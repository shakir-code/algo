package trees;

import java.util.Stack;

public class TreePaths {

    private Stack<Integer> stack = new Stack<>();

    public void printTreePaths(TreeNode root){
        if(root == null){
            return;
        }
        stack.push(root.val);
        //leaf node
        if(root.left ==null && root. right ==null){
            printStack();
        }
        printTreePaths(root.left);
        printTreePaths(root.right);
        stack.pop();
    }

    private void printStack(){
        for(int item:stack) {
            System.out.print(item);
        }
        System.out.println();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
