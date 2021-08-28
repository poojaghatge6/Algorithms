import java.util.*;

class Program {
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    // Write your code here.
	Arrays.sort(array);
	ArrayList<Integer[]> list = new ArrayList<Integer[]>();
	for(int i=0;i<array.length-2;i++) {
		int left = i+1, right = array.length-1, sum = targetSum - array[i];
		while(left<right) {

			if(array[left] + array[right] > sum) {
				right--;
			} else if(array[left] + array[right] < sum) {
				left++;
			} else {
				list.add(new Integer[]{array[i], array[left], array[right] });
				left++;
				right--;
			}

		}
	}
    	return list;
  }
}
