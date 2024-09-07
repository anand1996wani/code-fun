/**

Longest Common Subsequence

*/

class Solution {
    public int helper(String t1, String t2, int index1, int index2, int dp[][]) {
        if(index1 < t1.length() && index2 < t2.length()) {
            if(dp[index1][index2] == -1){
                int take = 0, notTake1 = 0, notTake2 = 0, notTake3 = 0;

                //Take index1 & Take index2
                if(t1.charAt(index1) == t2.charAt(index2)) {
                    take = 1 + helper(t1, t2, index1 + 1, index2 + 1, dp);
                }

                //Not Taking index1 and index2
                notTake1 = helper(t1, t2, index1 + 1, index2 + 1, dp);
                notTake2 = helper(t1, t2, index1 + 1, index2, dp);
                notTake3 = helper(t1, t2, index1, index2 + 1, dp);

                int m = Math.max(notTake1, notTake2);
                m = Math.max(m, notTake3);

                return dp[index1][index2] = Math.max(take, m);
            }else{
                return dp[index1][index2];
            }
        } else{
            //Base Case
            return 0;
        }

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];
        
        for(int a[] : dp){
            Arrays.fill(a, -1);
        }

        return helper(text1, text2, 0, 0, dp);
    }
}
