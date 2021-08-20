class MergeSort {
  public static void main(String[] args) {
    int arr[] = new int[] {-10, 1, 3, 8, -13, 32, 9, 5};
    
    int [] sorted = mergeSort(arr, 0 , arr.length-1);
    display(sorted);
    
 }
   
  public static void display(int [] arr) {
    
    for(int i =0; i< arr.length ; i++) {
      System.out.print(arr[i]+ " ");
    }
  }
  
 public static int [] mergeSort(int [] arr, int start , int end) {
    
    if(arr.length == 0) return new int[]{};
    
    if(end - start == 0) return new int[] {arr[start]};
    
    int mid = start + (end-start)/2;
    
    int [] arr1 = mergeSort(arr, start, mid);
    int [] arr2 = mergeSort(arr, mid+1, end);
   
    return merge( arr1, arr2);
    
  }
  
  public static int [] merge( int [] arr1, int [] arr2){
    
      int num1 = i < arr1.length ? arr1[i] : Integer.MAX_VALUE;
      int num2 =  j < arr2.length ? arr2[j] : Integer.MAX_VALUE;
      
      if(num1<num2) {
        arr3[k++] = num1;
        i++;
      } else {
        arr3[k++] = num2;
        j++;
      }
    }
 
    return arr3; 
  }
}
