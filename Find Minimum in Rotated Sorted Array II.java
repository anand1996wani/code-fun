/**

Find Minimum in Rotated Sorted Array II


**/

class Solution {

    public int findPivot(int[] nums, int start, int end) {
        int mid = 0;
        while(start < end) {
            mid = start + (end - start)/2;
            if(nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }else if(nums[mid] >= nums[start]) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        
        int ans = nums[0];
        for(int t : nums){
            ans = Math.min(ans, t);
        }
        return ans;
    }

    public int findMin(int[] nums) {
        return findPivot(nums, 0, nums.length - 1);
    }
}
