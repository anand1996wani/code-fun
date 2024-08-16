/**
* Most Frequent Number Following Key In an Array 
* 
*/

class Solution {
    public int mostFrequent(int[] nums, int key) {
        int max = -1;

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for(int i = 0;i < (nums.length - 1);i++) {
            if(nums[i] == key){
                int target = nums[i + 1];
                if(hashMap.get(target) == null) {
                    hashMap.put(target, 1);
                } else {
                    hashMap.put(target, (int)hashMap.get(target) + 1);
                }
                if(max == -1) {
                    max = target;
                }else {
                    max = (int)hashMap.get(target) > (int)hashMap.get(max) ? target : max;
                } 
            }
        }

        return max;
    }
}
