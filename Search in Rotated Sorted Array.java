/**
* Search in Rotated Sorted Array : 
* There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
*/ 

class Solution {
    public int searchPivot(int[] nums, int low, int high) {
        while(low < high) {
            int mid = (low + high) / 2;
            if(nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }else if(nums[mid] < nums[high]) {
                high = mid;
            }else{
                low = mid;
            }
        }
        return nums.length;
    }

    public int binarySearch(int[] nums, int low, int high, int target) {
        while(low <= high) {
            int mid = (low + high)/2;
            //System.out.println("Low " + low + " High " + high + "  mid " + mid);
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else{
                low = mid + 1; 
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int pivot = searchPivot(nums, 0, nums.length - 1);
        //System.out.println(pivot);
        int left = binarySearch(nums, 0, pivot - 1, target);
        //System.out.println(left);
        int right = binarySearch(nums, pivot, nums.length - 1, target);
        //System.out.println(right);

        if(left == -1 && right == -1) {
            return -1;
        }else if(left == -1){
            return right;
        }else {
            return left;
        }
    }
}
