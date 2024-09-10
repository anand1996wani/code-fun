/**

Spiral Matrix II

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

*/

class Solution {
    public int[][] generateMatrix(int n) {
        int c = 1;
        int matrix[][] = new int[n][n];

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        while(left <= right && top <= bottom){
            for(int i = left;i <= right;i++)
                matrix[top][i] = c++;

            top++;

            for(int i = top;i <= bottom;i++)
                matrix[i][right] = c++;

            right--;

            for(int i = right; i >= left;i--)
                matrix[bottom][i] = c++;

            bottom--;

            for(int i = bottom; i >= top;i--)
                matrix[i][left] = c++;
            
            left++;
        }

        return matrix;
    }
}
