/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example:
Input: m = 3, n = 7
Output: 28

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

- (1, 1) => 1
- (2, 2) => 2
- (3, 3) => 6 

  0 1 2 3
0 0 0 0 0
1 0 1 1 1
2 0 1 2 3
3 0 1 3 6


- base case at 1 x 1 = 1
- for each location we land
  - we take sum of our top and left

- return m[3][3]


Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

- for each row perform binary search

mlog(n)




1   down
  
10  11 14 
    m  t ==13
  
 23  target = 13, top


2]

[[1]]

1

*/



public boolean searchMatrix(int[][] matrix, int target) {
      int top = 0, down = matrix.length - 1 , row = 0;
  
       while(top <= down) {
         int mid = top + ( down - top ) / 2; 

         if( matrix[mid][0] == target) {
            return true;
         } else if (matrix[mid][0] > target) {
           down = mid - 1;
         } else if (matrix[mid][0] < target) {
           row = mid;
           top = mid + 1;

         }
       }

       int left  = 0, right = matrix[row].length - 1, col = -1;

       while(left <= right) {
         int mid = left + ( right - left ) / 2;
         System.out.println(row + " "+ mid + " "+right);
         if( matrix[row][mid] == target) {
            return true;
         } else if (matrix[row][mid] > target) {
           right = mid - 1;
         } else if (matrix[row][mid] < target) {

           left = mid + 1;

         }


       }

       return false;

   

}

/**

[[1],[3]], t= 3


1
3
**/

















