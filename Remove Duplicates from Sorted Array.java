/**
* Remove Duplicates from Sorted Array  
* 
* https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = nums[0];
        int prevCount = 1;
        int validIndex = 0;

        for(int i = 1;i < nums.length;i++) {
            if(nums[i] == prev){
                prevCount++;
            }else{
                nums[validIndex + 1] = nums[i];
                prevCount = 1;
                prev = nums[i];
                validIndex = validIndex + 1;
            }
        }
        return validIndex + 1;
    }
}
