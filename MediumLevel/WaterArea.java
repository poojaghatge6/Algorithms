import java.util.*;

class Program {
  public static int waterArea(int[] heights) {
    // Write your code here.
		int leftMax = 0, rightMax=0, total= 0;
		int [] maxes = new int[heights.length];
		for(int i=0;i<heights.length;i++) {
			maxes[i] = leftMax;
			leftMax = Math.max(leftMax, heights[i]);
		}
		
	  for(int i=heights.length - 1;i>=0;i--) {
			maxes[i] = Math.min(maxes[i], rightMax);
			rightMax = Math.max(rightMax, heights[i]);
			
			if(maxes[i] - heights[i] > 0)
					total = total + maxes[i] - heights[i];
		}
    return total;
  }
}
