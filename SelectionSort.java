class SelectionSort{
  public static void main(String[] args) {
    int arr[] = new int[] {-10, 1, 3, 8, -13, 32, 9, 5};
    
    int [] sorted = selectionSort(arr, 0 , arr.length-1);
    display(sorted);
    
  } 

  public static void display(int [] arr) {
    for(int i =0; i< arr.length ; i++) {
      System.out.print(arr[i]+ " ");
    }
  }

   public static int[] selectionSort(int [] arr) {
    int i = 0;
    for( i = 0; i<arr.length-1; i++) {
      int min = arr[i];
      int pos = i;
      for(int j=i+1; j<arr.length; j++) {
        if(arr[j] < min) {
          min = arr[j];
          pos = j;
        }
      }
      int temp = arr[i];
      arr[i] = arr[pos];
      arr[pos] = temp; 
    }
    return arr;
  }

}
