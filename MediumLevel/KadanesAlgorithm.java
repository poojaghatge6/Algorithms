import java.util.*;

class Program {
  public static int kadanesAlgorithm(int[] array) {
		
    	// Write your code here.
    	int maxEndingHere = array[0];
	int max = maxEndingHere ;

	for(int i=1; i<array.length; i++) {
		maxEndingHere = Math.max(array[i], array[i] + maxEndingHere);
		if(maxEndingHere > max) {
			max = maxEndingHere;
		}
	}


	return max;
  }
}
