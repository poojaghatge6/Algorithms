class KthElementInFibonacci{
  public static void main(String[] args) {

  
    System.out.println(fibonacci(0)) ; 
    System.out.println(fibonacci(1)) ; 
    System.out.println(fibonacci(10)) ;
    System.out.println(fibonacci(20)) ; 

  } 



   public static int fibonacci(int k) {
     
    if(k<1) return 0;
    if(k==1) return 1;
     
    int memo[] = new int [k+1];
    memo[0] = 0;
    memo[1] = 1;
    for(int i=2;i<=k;i ++) {
    
      memo[i] = memo[i-1] + memo[i-2];
    }
     
     return memo[k];
   
    
  }

  
  
}
