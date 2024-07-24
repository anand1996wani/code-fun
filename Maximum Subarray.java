class Solution {
    public int maxSubArray(int[] nums) {
        
        int sumSoFar = nums[0];
        int max = nums[0];

        for(int i = 1 ;i < nums.length;i++) {
            
            sumSoFar = Math.max(nums[i], nums[i] + sumSoFar);
            max = Math.max(max, sumSoFar);

        }

        return max;
    }
}
