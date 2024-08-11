/**
* https://leetcode.com/problems/3sum/
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> hashSet = new HashSet<List<Integer>>();

        for(int i = 0; i < nums.length;i++){
            HashSet<Integer> innerHashSet = new HashSet<Integer>();
            for(int j = i + 1;j < nums.length;j++){
                int k = -1*(nums[i] + nums[j]);
                if(innerHashSet.contains(k) == false){
                    innerHashSet.add(nums[j]);
                }else{
                    ArrayList<Integer> a = new ArrayList<Integer>();
                    a.add(nums[i]);
                    a.add(nums[j]);
                    a.add(k);
                    Collections.sort(a);
                    if(hashSet.contains(a) == false){
                        ans.add(a);
                        
                        hashSet.add(a);
                    }
                }
            }
        }
        return ans;
    }
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> hashSet = new HashSet<List<Integer>>();
        HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
        for(int i = 0;i < nums.length;i++){
            if(hashMap.get(nums[i]) == null) {
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(i);
                hashMap.put(nums[i], a);
            }else{
                List<Integer> a = hashMap.get(nums[i]);
                a.add(i);
                hashMap.put(nums[i], a);
            }
        }

        for(int i = 0; i < nums.length;i++){
            for(int j = i + 1;j < nums.length;j++){
                int k = -1*(nums[i] + nums[j]);
                if(hashMap.get(k) != null){
                    List<Integer> p = hashMap.get(k);
                    for(int z : p){
                        if(z != i && z!= j) {
                            ArrayList<Integer> a = new ArrayList<Integer>();
                            a.add(nums[i]);
                            a.add(nums[j]);
                            a.add(nums[z]);
                            Collections.sort(a);
                            if(hashSet.contains(a) == false){
                                ans.add(a);
                                hashSet.add(a);
                            }
                        } 
                    }
                }  
            }
        }
        return ans;
    }
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> hashSet = new HashSet<List<Integer>>();
        

        for(int i = 0; i < nums.length;i++){
            for(int j = i + 1;j < nums.length;j++){
                for(int k = j + 1;k < nums.length;k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        ArrayList<Integer> a = new ArrayList<Integer>();
                        a.add(nums[i]);
                        a.add(nums[j]);
                        a.add(nums[k]);
                        Collections.sort(a);
                        if(hashSet.contains(a) == false){
                            ans.add(a);
                            hashSet.add(a);
                        }   
                    }
                }
            }
        }
        return ans;
    }
}
