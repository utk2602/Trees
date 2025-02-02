/*Three  ways of doing it , preorder, inorder, postorder 
 
*/


class solution {
    public int diameterOfBinaryTree(TreeNode root){
        if(root == null) return 0;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight + rightHeight, Math.max(left, right));
    }
    public int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}