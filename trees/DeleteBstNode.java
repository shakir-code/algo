package trees;

public class DeleteBstNode {

    int least;

    public TreeNode deleteNodeAndReturnRoot(TreeNode root,int key){
        if(root==null){
            return root;
        }
        if(root.val==key) {
            if(root.right!=null){
                //1. save the least
                //2. delete min node
                //3. give me the root of the morphed subtree
                root.right = createSubtree(root.right);
                root.val = least;
            } else if(root.left!=null){
                root = root.left;
            } else {
                root = null;
            }
        } else if(key>root.val) {
            root.right = deleteNodeAndReturnRoot(root.right, key);
        } else {
            root.left = deleteNodeAndReturnRoot(root.left, key);
        }
        return root;
    }

    //function to find least in right subtree and delete it
    // and reattach the nodes
    private TreeNode createSubtree(TreeNode node) {
        //found the min in the tree
        if(node.left==null) {
            //save the least
            least = node.val;
            TreeNode right = node.right;
            //delete
            node = null; //GC to collect
            return right;
        } else {
            //reattachment in case previous step returned right
            node.left = createSubtree(node.left);
            return node;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

}

