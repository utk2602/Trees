//Bfs is level search ,  should be used when answer lies near the root node 
//when we are asked to search by level
public List<List<Integer>> result = new ArrayList<>();
public List<List<Integer>> levelOrder(TreeNode root) {
    result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int level = 0;
    while (!queue.isEmpty()) {
        result.add(new ArrayList<>());
        int level_length = queue.size();
        for (int i = 0; i < level_length; ++i) {
            TreeNode node = queue.remove();
            result.get(level).add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        level++;
    }
    return result;
}