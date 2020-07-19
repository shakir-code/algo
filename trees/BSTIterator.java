package trees;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    private void generateStack(TreeNode root) {
        if (root != null) {
            stack.push(root);
            generateStack(root.left);
        }
        return;
    }

    public BSTIterator(TreeNode root){
        generateStack(root);
    }

    public int next() {
          TreeNode node = stack.pop();
          if(node.right!=null){
              generateStack(node);
          }
          return node.val;
    }

    public boolean hasNext() {
        if(stack.size()!=0){
            return true;
        } else {
            return false;
        }
    }

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
}




