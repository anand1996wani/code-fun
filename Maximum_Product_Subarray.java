/**
* https://leetcode.com/problems/maximum-product-subarray/
* 
*/

class Solution {
    public int maxProduct(int[] nums) {
        long max = nums[0];

        for (int n : nums) {
            max = Math.max(max, n);
        }

        long maxSoFar = 1;
        long minSoFar = 1;

        for(int i = 0;i < nums.length;i++) {
            if(nums[i] == 0){
                maxSoFar = 1;
                minSoFar = 1;
            }else{
                long tempMaxSoFar = maxSoFar;

                maxSoFar = Math.max(Math.max(maxSoFar * nums[i], minSoFar * nums[i]), nums[i]);
                minSoFar = Math.min(Math.min(tempMaxSoFar * nums[i], minSoFar * nums[i]), nums[i]);

                max = Math.max(Math.max(maxSoFar, minSoFar), max);
            }

            //System.out.println("Count " + i + " MinSoFar " + minSoFar + " MaxSoFar " + maxSoFar);
        }

        return (int)max;
    }
}
