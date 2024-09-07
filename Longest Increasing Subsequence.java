/**

300. Longest Increasing Subsequence

https://leetcode.com/problems/longest-increasing-subsequence/description/

*/

class Solution {
    public int helper1(int []nums, int index, int prevIndex) {
        int take = 0, notTake = 0;
        if(index < nums.length) {
            //Take Index
            if(prevIndex == -1 || nums[prevIndex] < nums[index]){
                take = 1 + helper1(nums, index + 1, index);
            }
            //Dont Take Index
            notTake = helper1(nums, index + 1, prevIndex);
            return Math.max(take, notTake);
        }else {
            return 0;
        }
    }

    public int lengthOfLIS1(int[] nums) {
        return helper1(nums, 0, -1);
    }

    public int helper(int []nums, int index, int prevIndex, int dp[][]) {
        if(index < nums.length) {
            if(dp[index][prevIndex + 1] == -1){
                int take = 0, notTake = 0;
                //Take Index
                if(prevIndex == -1 || nums[prevIndex] < nums[index]){
                    take = 1 + helper(nums, index + 1, index, dp);
                }
                //Dont Take Index
                notTake = helper(nums, index + 1, prevIndex, dp);
                return dp[index][prevIndex + 1] = Math.max(take, notTake);
            } else{
                return dp[index][prevIndex + 1];
            }
        }else {
            return 0;
        }
    }

    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length + 1][nums.length + 1];

        for(int ar[] : dp){
            Arrays.fill(ar, -1);
        }

        return helper(nums, 0, -1, dp);
    }
}
