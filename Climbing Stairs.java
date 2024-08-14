/**
* Climbing Stairs  https://leetcode.com/problems/climbing-stairs/description/
*/

class Solution {
    public static int array[] = new int[46]; 
    public int climbStairs(int n) {
        if(n == 1 || n == 2){
            return n;
        } else{
            if(array[n - 1] == 0){
                array[n - 1] = climbStairs(n - 1);
            }
            if(array[n - 2] == 0){
                array[n - 2] = climbStairs(n - 2);
            }
            array[n] = array[n - 1] + array[n - 2];
            return array[n];
        }
    }
}
