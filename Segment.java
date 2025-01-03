//segment trees
a=[1,6,8,2,7,16]
O(n) not good enough , find the sum between particular indices using O(log N)

when are segment trees used ?
When needed to perform some query in a range 
(sum,max,avg,min,prod) etc etc

in O(log N ) time 


St is a binary tree which has interval info and operation 


Sum between any 2 integers 
a =[3,8,7,6,-2,-8,4,9]  n=8
every node represents a query and a range 

leaf node is the last element in the array 

ST is full Binary Tree
which means every node has two children except the leaf nodes 

there are a few cases regarding functions with Segment trees
Node interval is inside query Inteval 


Node interval is completely outside query interval {
    return the default value  of the query . In this case it is equal to zero 
    
}
Node end interval less than query start same 


overlapping 




How to update in O(logN) times
1) check whether index lies within the interval 
2) if yes then check child nodes ,  if child  range is out , no change in value just return 
3) in the end you will reach leaf update the leaf or recursion will update the leaf 


class Segment{
    private sttaic class Node{
        int data;
        int startinterval;
        int endinterval;
        Node left;
        Node right;

        public Node(int startinterval,int endinterval){
            this.startinterval=startinterval;
            this.endinterval=endinterval;
        }
    }
    Node root;
    public Segment(int[] arr){
        // create a tree using arr 
        this.root = constructTree(arr,0,arr.length-1);
    }
    private Node constructTree(int[]arr,int start , int end ){
        if(start==end){
            Node leaf = new Node(start,end);
            leaf.data = arr[start]; 
        }
        create a new Node with the index you are at 
        Node node = new Node(start,end);
        int mid = (start+end)/2;
        node.left = this.constructTree(arr,start,mid);
        node.right = this.constructTree(arr,mid+1,start);
        node.data = node.left.data + node.right.data;


        return node ;

    }
}class SegmentTree {

    private static class Node {
      int data;
      int startInterval;
      int endInterval;
      Node left;
      Node right;
  
      public Node (int startInterval, int endInterval) {
        this.startInterval = startInterval;
        this.endInterval = endInterval;
      }
    }
  
    Node root;
  
    public SegmentTree(int[] arr) {
      // create a tree using this array
      this.root = constructTree(arr, 0, arr.length - 1);
    }
  
    private Node constructTree(int[] arr, int start, int end) {
      if(start == end) {
        // leaf node
        Node leaf = new Node(start, end);
        leaf.data = arr[start];
        return leaf;
      }
  
      // create new node with index you are at
      Node node = new Node(start, end);
      
      int mid = (start + end) / 2;
  
      node.left = this.constructTree(arr, start, mid);
      node.right = this.constructTree(arr, mid + 1, end);
  
      node.data = node.left.data + node.right.data;
      return node;
    }
  
    public void display() {
      display(this.root);
    }
    private void display(Node node) {
      String str = "";
  
      if(node.left != null) {
        str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => "; 
      } else {
        str = str + "No left child";
      }
  
      // for current node
      str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= "; 
      
      if(node.right != null) {
        str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data; 
      } else {
        str = str + "No right child";
      }
  
      System.out.println(str + '\n');
  
      // call recursion
      if(node.left != null) {
        display(node.left);
      }
  
      if(node.right != null) {
        display(node.right);
      }
    }
  
    // query
    public int query(int qsi, int qei) {
      return this.query(this.root, qsi, qei);
    }
    private int query(Node node, int qsi, int qei) {
      if(node.startInterval >= qsi && node.endInterval <= qei) {
        // node is completely lying inside query
        return node.data;
      } else if (node.startInterval > qei || node.endInterval < qsi) {
        // completely outside
        return 0;
      } else {
        return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
      }
    }
  
    // update
    public void update(int index, int value) {
      this.root.data = update(this.root, index, value);
    }
    private int update(Node node, int index, int value) {
      if (index >= node.startInterval&& index <= node.endInterval){
        if(index == node.startInterval && index == node.endInterval) {
          node.data = value;
          return node.data;
        } else {
          int leftAns = update(node.left, index, value);
          int rightAns = update(node.right, index, value);
          node.data = leftAns + rightAns;
          return node.data;
        }
      }
      return node.data;
    }
    
  }