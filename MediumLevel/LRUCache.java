
import java.io.*;
import java.util.*;


class Solution {
  public static void main(String[] args) {
    LRUCache cache = new LRUCache(3);
 
    System.out.println(cache.get(0)); // -1
    cache.put( 1, 10);
    cache.put( 2, 20);
    cache.put(3, 30);
    System.out.println(cache.get(1)); // 10
    System.out.println(cache.get(2)); // 20
    cache.put( 4, 40);
    System.out.println(cache.get(3)); // -1
  }
}


class Node
{
  int key;
  int value;
  Node next;
  Node prev;
  
  Node(int key, int value) {
    this.key = key;
    this.value = value;
  }

}


class LRUCache {

  int capacity;
  HashMap<Integer, Node> cache;
  Node start;
  Node end;
  
  
  LRUCache(int capacity) {
    cache = new HashMap<>();
    this.capacity = capacity;
    start = null;
    end = null;
  
  }

  public int get(int key) {
    
    if(cache.containsKey(key)) {
       Node curr = cache.get(key);
       remove(curr);
       insertEnd(curr);
       return curr.value;
    } else {
      return -1;
    }
  
  }
  
  public void put(int key, int value) {
    
    if(cache.containsKey(key)) {
       Node curr = cache.get(key);
       curr.value = value;
       remove(curr);
       insertEnd(curr);
       cache.put(key, curr);
    } else {
      Node curr = new Node(key, value);
      if(cache.size() == capacity) {
        evict();
      }
      insertEnd(curr);
      cache.put(key, curr);
    }
  
  }
  
  
  public void insertEnd(Node curr) {
    
    if(end == null) {
     end = curr;
     start = curr;
    } else {
      end.next = curr;
      curr.prev = end;
      end = end.next;
    }
    
  }
  
  
  public void remove(Node curr) {
    
    if(curr.next == null && curr.prev == null) {
      start = null;
      end = null;
    } else if(curr.prev == null) {
    
      start = start.next;
      start.prev = null;
    } else if (curr.next == null) {
      
      end = end.prev;
      end.next = null;
      
    } else {
    
      curr.prev.next = curr.next;
      curr.next.prev = curr.prev;
    }
    
    
    curr.next = null;
    curr.prev = null;
    
    
  }
  
  
  public void evict () {
    
    if(start!=null) {
    
      cache.remove(start.key);

      remove(start);
      
    }
  
  
  }

}

