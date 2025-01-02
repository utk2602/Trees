//for every node in the tree , the difference in height of left and right subtree of that node
//should be less than equal to 1
//Balanced tree



/*So the problem is the tree not being balanced and that will be solved by self balancing binary tree which is termed as AVL
It will be restructured in such a way that the unbalanced binary tree will be balanced

 */

class BST {
    public class Node {
      private int value;
      private Node left;
      private Node right;
      private int height;
  
      public Node(int value) {
        this.value = value;
      }
  
      public int getValue() {
        return value;
      }
    }
  
    private Node root;
  
    public BST() {
  
    }
  
    public void insert(int value) {
      root = insert(value, root);
    }
  
    private Node insert(int value, Node node) {
      if (node == null) {
        node = new Node(value);
        return node;
      }
  
      if (value < node.value) {
        node.left = insert(value, node.left);
      }
  
      if (value > node.value) {
        node.right = insert(value, node.right);
      }
  
      node.height = Math.max(height(node.left), height(node.right)) + 1;
      return node;
    }
  
    public void populate(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        this.insert(nums[i]);
      }
    }
  
    public void populatedSorted(int[] nums) {
      populatedSorted(nums, 0, nums.length);
    }
  
    private void populatedSorted(int[] nums, int start, int end) {
      if (start >= end) {
        return;
      }
  
      int mid = (start + end) / 2;
  
      this.insert(nums[mid]);
      populatedSorted(nums, start, mid);
      populatedSorted(nums, mid + 1, end);
    }
  
    public void display() {
      display(this.root, "Root Node: ");
    }
  
    private void display(Node node, String details) {
      if (node == null) {
        return;
      }
      System.out.println(details + node.value);
      display(node.left, "Left child of " + node.value + " : ");
      display(node.right, "Right child of " + node.value + " : ");
    }
  
    public boolean isEmpty() {
      return root == null;
    }
  
    public int height(Node node) {
      if (node == null) {
        return -1;
      }
      return node.height;
    }
  
    public boolean balanced() {
      return balanced(root);
    }
  
    private boolean balanced(Node node) {
      if (node == null) {
        return true;
      }
      return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }
  
  }
  /*
   algorithm for AVL tree
   1) Insert normally the node (n)
   2) Start from node n and find the node which makes it unbalanced 
   Bottom Up approach 
   3) Using one of the four rules rotate 







   the 4 methods 



   ok so the "Grandchild" will be the last node which will be added in the line of change of the Tree
   first motivation should be to make everyone come into a single line 
   
   */