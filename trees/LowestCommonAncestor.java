package trees;

public class LowestCommonAncestor {

    public TreeNode getLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        TreeNode left = getLowestCommonAncestor(root.left , p, q);
        TreeNode right = getLowestCommonAncestor(root.right, p, q);

        if(!checkIfPorQ(root, p, q)) {
            if(checkIfPorQ(left, p,q) && checkIfPorQ(right, p,q)){
                return root;
            } else if (checkIfPorQ(left, p, q) && !checkIfPorQ(right, p, q))
            {
                return left;
            } else if (checkIfPorQ(right, p, q) && !checkIfPorQ(left, p, q)){
                return right;
            } else if (right!=null){
                return right;
            } else if(left!=null){
                return left;
            } else{
                return null;
            }
        } else {
            return root;
        }
    }

    private boolean checkIfPorQ(TreeNode node, TreeNode p, TreeNode q){
        if(node!=null && (node.val==p.val ||node.val==q.val)){
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



