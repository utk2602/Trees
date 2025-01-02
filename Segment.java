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