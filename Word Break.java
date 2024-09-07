/**

Word Break.java

https://leetcode.com/problems/word-break/description/

*/

class Solution {
    public boolean wordBreak1(String s, List<String> wordDict) {
        HashSet<String> hashSet = new HashSet<String>();

        for(String t : wordDict){
            hashSet.add(t);
        }

        String curr = "";
        for(int i = 0; i < s.length();i++){
            curr = curr + s.charAt(i);
            if(hashSet.contains(curr)){
                curr = "";
            }
        }

        if(curr.equals("")){
            return true;
        }else{
            return false;
        }
    }

    public boolean helper2(String s, HashSet<String> hashSet, int index, String curr) {
        if(index < s.length()){
            for(int i = index; i < s.length();i++){
                curr = curr + s.charAt(i);
                if(hashSet.contains(curr)){
                    return helper2(s, hashSet, i + 1, curr) || helper2(s, hashSet, i + 1, "");
                }
            }
            return false;
        }else{
            if(curr.equals("")){
                return true; 
            }else{
                return false;
            }
        }
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        HashSet<String> hashSet = new HashSet<String>();

        for(String t : wordDict){
            hashSet.add(t);
        }
    
        return helper2(s, hashSet, 0, "");
    }

    public int helper(String s, HashSet<String> hashSet, int index, int dp[]) {
        if(index < s.length()){
            if(dp[index] == -1){
                String curr = "";
                for(int i = index; i < s.length();i++){
                    curr = curr + s.charAt(i);
                    if(hashSet.contains(curr)){
                        if(helper(s, hashSet, i + 1, dp) == 1){
                            return dp[index] = 1;
                        }
                    }
                }
                return dp[index] = 0;
            }else{
                return dp[index];
            }
        }else{
            return 1;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hashSet = new HashSet<String>();

        for(String t : wordDict){
            hashSet.add(t);
        }

        int []dp = new int[300];
        Arrays.fill(dp, -1);
        return helper(s, hashSet, 0, dp) == 1 ? true : false ;
    }
}
