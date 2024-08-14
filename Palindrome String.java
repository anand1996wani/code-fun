/**
* Palindrome String https://www.geeksforgeeks.org/problems/palindrome-string0817/1
*/


class Solution {
    int helper(String s, int src, int des) {
        if(src >= des) {
            return 1;
        }else{
            if(s.charAt(src) == s.charAt(des)) {
                return helper(s, src + 1, des - 1);
            }else{
                return 0;
            }
        }
    }
    
    int isPalindrome(String S) {
        // code here
        if(S.length() <= 1){
            return 1;
        }else{
            return helper(S, 0, S.length() - 1);
        }
    }
};
