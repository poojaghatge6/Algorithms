class Solution {
    public void sortColors(int[] nums) {
        
        int curr=0, po=0, p2=nums.length-1;
        
        while(curr<=p2) {
            if(nums[curr] == 0) {
                int temp = nums[po];
                nums[po] = nums[curr];
                nums[curr] = temp;
                po++;
                curr++;
            } else if(nums[curr] == 2) {
                 int temp = nums[p2];
                nums[p2] = nums[curr];
                nums[curr] = temp;
                p2--;
            } else {
                curr++;
            }
        }
        
        
        
    }
}
