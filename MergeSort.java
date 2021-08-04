class MergeSort {
  public static void main(String[] args) {
    int arr[] = new int[] {-10, 1, 3, 8, -13, 32, 9, 5};
    
    int [] sorted = mergeSort(arr, 0 , arr.length-1);
    display(sorted);
    
 } 
  
 public static int [] mergeSort(int [] arr, int start , int end) {
    
    if(arr.length == 0) return new int[]{};
    
    if(end - start == 0) return new int[] {arr[start]};
    
    int mid = start + (end-start)/2;
    
    int [] arr1 = mergeSort(arr, start, mid);
    int [] arr2 = mergeSort(arr, mid+1, end);
   
    return merge(arr, arr1, arr2);
    
  }
  
  public static int [] merge(int [] arr, int [] arr1, int [] arr2){

    int i= 0, j= 0;
    int len = arr1.length + arr2.length;
    int[] arr3 = new int[len];
    int k=0;
    
    while(i< arr1.length && j < arr2.length) {
      if(arr1[i]<= arr2[j]) {
        arr3[k]= arr1[i];
        i++;
        k++;
      } else {
        arr3[k]= arr2[j];
        j++;
        k++;
      }
    }
    
    while(i< arr1.length ) {
        arr3[k]= arr1[i];
        i++;
        k++;
    }
    while(j < arr1.length ) {
        arr3[k]= arr2[j];
        j++;
        k++;
    }
    return arr3; 
  }
}
