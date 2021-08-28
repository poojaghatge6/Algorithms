import java.util.*;

class Program {
  public static int shiftedBinarySearch(int[] array, int target) {
    // Write your code here.
    int left=0, right=array.length-1;
		while(left <= right) {
			int mid = left +(right-left)/2;
			
			if(array[mid] == target) return mid;
			
			if(array[mid] <= array[right]) {
				if(target >= array[mid] && target <= array[right]) {
					left = mid +1;
				} else {
					right = mid - 1;
				}
				
			} else {
				if(target <= array[mid] && target >= array[left]) {
					right = mid -1;
				} else {
					left = mid + 1;
				}
			}
		}
		
		return -1;
  }
}
