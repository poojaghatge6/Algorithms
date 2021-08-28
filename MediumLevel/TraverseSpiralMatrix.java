class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    
        List<Integer> list = new ArrayList<Integer>();
        
        int i=0, j=0, up=0, down = matrix.length - 1, 
        right = matrix[0].length -1, left = 0, len = matrix.length * matrix[0].length;
 
        
        boolean u = false, d = false, r = true, l = false;
        
        while(list.size() < len){
            
            
            for( j=left; r && j <=right; j++) {
                list.add(matrix[up][j]);
            }
            
            for(j=right; l && j>=left ; j--) {
                list.add(matrix[down][j]);
            }

            for( i=down;  u && i >=up ; i--) {
                list.add(matrix[i][left]);
            }

            for(i=up; d && i <=down; i++) {
                list.add(matrix[i][right]);
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
