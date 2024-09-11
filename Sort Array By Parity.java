/**

Sort Array By Parity



*/

class Solution {
    public void swapElements(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] sortArrayByParity(int[] nums) {
        int j = -1;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] % 2 == 0){
                swapElements(nums, j + 1, i);
                j = j + 1;
            }
        }
        return nums;
    }
}
