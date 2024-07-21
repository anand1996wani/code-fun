/*
House Robber.java

*/

class Solution {
    public int helper(int[] nums, int i, int profit) {
        int profit1, profit2 = 0;
        if(i < nums.length) { 
            //take index i
            int temp = 0;
            
            temp = profit + nums[i];
            profit1 = this.helper(nums, i + 2, temp);
            
            //dont take profit of i
            profit2 = this.helper(nums, i + 1, profit);
            return Math.max(profit1, profit2);
        }else {
            return profit;
        }
    }

    public int helper2(int[] nums, int i, int dp[]) {
        if(i >= nums.length){
            return 0;
        }
        if(nums.length == 0){
            return nums[0];
        }

        if(dp[i] != -1)
            return dp[i];

        int one = helper2(nums, i + 2, dp) + nums[i];
        int two = helper2(nums, i + 1, dp) + 0;

        dp[i] = Math.max(one, two);

        return dp[i];
    }

    public int rob(int[] nums) {
        /*
        int odd = 0, even = 0;
        //wrong answer
        for(int i = 0; i < nums.length;i++){
            if(i % 2 == 0){
                //even
                even = even + nums[i];
            }else{
                //odd
                odd = odd + nums[i];
            }
        }
        */

        //int sum = helper(nums, 0, 0);
        // int dp[] = new int[nums.length];
        // for(int i = 0;i < nums.length;i++)
        //     dp[i] = -1;
        // return helper2(nums, 0, dp);

        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1;i < nums.length;i++) {
            int first = 0;
            if((i - 2) < 0){ 
                first = nums[i];
            }else{
                first = dp[i - 2]  + nums[i];
            }
            int second = dp[i - 1] + 0;
            dp[i] = Math.max(first, second);
        }
        return dp[nums.length - 1];
    }
}
