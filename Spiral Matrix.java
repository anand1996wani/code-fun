/**

Spiral Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.


*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> arrayList = new ArrayList<Integer>();

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;

        while(left <= right && top <= bottom) {
            for(int i = left;i <= right;i++)
                arrayList.add(matrix[top][i]);

            top++;

            for(int i = top;i <= bottom;i++)
                arrayList.add(matrix[i][right]);

            right--;

            if(top <= bottom){
                for(int i = right;i >= left;i--)
                    arrayList.add(matrix[bottom][i]);
                bottom--;
            }

            if(left <= right){
                for(int i = bottom;i >= top;i--)
                    arrayList.add(matrix[i][left]);
                left++;
            }
        }
        return arrayList;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> arrayList = new ArrayList<Integer>();

        int p = 0;
        int q = 0;

        while(m > 0 && n > 0) {
            int i = p;
            int j = q;

            for(;j < m;j++)
                arrayList.add(matrix[i][j]);
            j = j - 1;
            i = i + 1;
            for(;i < n;i++)
                arrayList.add(matrix[i][j]);
            i = i - 1;
            j = j - 1;
            for(;j >= q;j--)
                arrayList.add(matrix[i][j]);
            j = j + 1;
            i = i - 1;
            for(;i >= (p + 1);i--)
                arrayList.add(matrix[i][j]);
            i = i + 1;

            n = n - 1;
            m = m - 1;
            p = p + 1;
            q = q + 1;

            System.out.println("p" + " -> " + p);
            System.out.println("q" + " -> " + q);
        }

        return arrayList;
    }
}
