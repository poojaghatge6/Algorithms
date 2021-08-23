class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        if(matrix.length == 0) return new ArrayList<Integer>();
        
        List<Integer> list = new ArrayList<Integer>();
        
        int i=0, j=0, up=0, down = matrix.length - 1, 
        right = matrix[0].length -1, left = 0, len = matrix.length * matrix[0].length;
 
        
        boolean u = false, d = false, r = true, l = false;
        
        while(list.size() < len){
            
            for( j=left, i =up; r && j <=right; j++) {
                list.add(matrix[i][j]);
            }
            
            for(j=right, i =down; l && j>=left ; j--) {
                list.add(matrix[i][j]);
            }

            for( i=down, j =left;  u && i >=up ; i--) {
                list.add(matrix[i][j]);
            }

            for(i=up, j = right; d && i <=down; i++) {
                list.add(matrix[i][j]);
            }

            if(r == true) {
                r = false;
                up++;
                d = true;
            } else if( l == true) {
                down--;
                l= false;
                u = true;
            } else if(u == true) {
                u = false;
                left++;
                r = true;
            } else if(d == true) {
                d = false;
                l = true;
                right--;
            }  
        }
        
        return list;
        
    }
}
