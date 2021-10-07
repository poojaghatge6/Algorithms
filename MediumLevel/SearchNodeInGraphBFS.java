/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
class GNode {

  int value;
  GNode[] children;
  GNode(int value, GNode[] children) {
    this.value = value;
    this.children = children;
  }
  
  public boolean hasPathTo(GNode node) {
    
    
    Set<Integer> visited = new HashSet<Integer>();
    Queue<GNode> queue = new LinkedList<GNode>();

    queue.add(this);
    
    while(!queue.isEmpty()) {
      
      GNode curr = queue.poll();
      if(curr == node) return true;
      else if(curr != null && curr.children != null ){
        
        for(int i=0; i< curr.children.length; i++) {
          
         
           if(!visited.contains(curr.children[i].value)) {
             queue.offer(curr.children[i]);
             visited.add(curr.children[i].value);
           }
             
        
        }
      
      }
    }
    
    return false;
  }
  
  
  
  public boolean hasPathToDFS(GNode node) {
    
    
    return hasPathToRecurr(node, this, new HashSet<GNode>());
    
    
    
  }
  
  
  public boolean hasPathToRecurr(GNode node, GNode root, HashSet<GNode> visited) {
    
    if(root == null) return false;
    else {
    
      if( visited.contains(root)) return false;
      else {
        
        visited.add(root);
        if(root == node) return true;
        else {
        
          
          boolean hasPath = false;
          if(root.children!=null) {
            for( int i=0; i<root.children.length; i++) {
              
              System.out.println(" val: " + root.children[i].value + "root: " + root.value);

              hasPath = hasPath || hasPathToRecurr(node, 
                                   root.children[i], 
                                   new HashSet<GNode>(visited)); 

            }
            return hasPath;
          }
          
        }
      
      }
    }
    
    return false;
    
    
  }
  
        
  
}
class Solution {
  public static void main(String[] args) {
    
    GNode node2 = new GNode(2, null);
    GNode node1 = new GNode(1, new GNode[]{node2, new GNode(3, null)});
    GNode node4 = new GNode(4, new GNode[]{node1});
    GNode node5 = new GNode(5, new GNode[]{node1, node4});
    GNode node6 = new GNode(6, null);
    GNode node7 = new GNode(1, null);
    GNode node8 = new GNode(2, null);
    GNode node9 = new GNode(3, null);
    node7.children = new GNode[]{node8};
    node8.children = new GNode[]{node9};
    node9.children = new GNode[]{node7};
    
    System.out.println(node5.hasPathTo(node2));
    System.out.println(node6.hasPathTo(node1));
    System.out.println(node1.hasPathTo(node4));
    System.out.println(node7.hasPathTo(node9));
    System.out.println(node7.hasPathTo(node1));

  }
}
