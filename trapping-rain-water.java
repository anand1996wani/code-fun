class Solution {
    public int trap(int[] height) {
        int left_max[] = new int[height.length];
        int right_max[] = new int[height.length];


        int max = 0;
        for(int i = 0;i < height.length;i++){
            max = Math.max(max, height[i]);
            left_max[i] = max;
        }

        max = 0;

        for(int j = height.length - 1;j >= 0;j--){
            max = Math.max(max, height[j]);
            right_max[j] = max;
        }

        int ans = 0;
        for(int i = 0;i < height.length;i++){            
            ans = ans + Math.min(left_max[i], right_max[i]) - height[i];
        }
      
        return ans;
    }
}
