class BubbleSort {
 
  
  public static void main(String[] args) {
    int arr[] = new int[] {-10, 1, 3, 8, -13, 32, 9, 5};
   
    int [] sorted = bubbleSort(new int[] {});
    display(sorted);
    
    sorted = bubbleSort(new int[] {1});
    display(sorted);
    
    sorted = bubbleSort(new int[] {3, 1, 2, 4});
    display(sorted);
    
    sorted = bubbleSort(arr);
    display(sorted);
    
 } 
  
  public static void display(int [] arr) {
    for(int i =0; i< arr.length ; i++) {
      System.out.print(arr[i]+ " ");
    }
     System.out.println();
  }
  public static int[] bubbleSort(int [] arr) {
    
    for(int i=arr.length-1; i>0; i--) {
      for(int j=0;j<i; j++){
        if(arr[j] > arr[j+1]){
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }
    return arr;    
  } 
}
