/*

https://leetcode.com/problems/two-sum/description/

*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for(int i = 0;i < nums.length;i++) {
            int toFind = target - nums[i];

            if(hashMap.get(toFind) != null){
                ans[0] = i;
                ans[1] = (int)hashMap.get(toFind);
                break;
            }

            hashMap.put(nums[i], i);
        }

        return ans;
    }
}
