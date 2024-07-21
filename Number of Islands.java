/*

200. Number of Islands


*/

class Solution {

    public boolean isValid(int i, int j, int n, int m) {
        if(i >= 0 && i < n && j >= 0 && j < m){
            return true;
        }else
            return false;
    }

    public void dfs(char[][] grid, int visited[][], int i, int j, int n, int m) {
        visited[i][j] = 1;

        if(isValid(i + 1, j, n, m) && visited[i + 1][j] == 0 && grid[i + 1][j] == '1') {
            dfs(grid, visited, i + 1, j, n, m);
        }
        if(isValid(i - 1, j, n, m) && visited[i - 1][j] == 0 && grid[i - 1][j] == '1') {
            dfs(grid, visited, i - 1, j, n, m);
        }
        if(isValid(i, j - 1, n, m) && visited[i][j - 1] == 0 && grid[i][j - 1] == '1') {
            dfs(grid, visited, i, j - 1 , n, m);
        }
        if(isValid(i, j + 1, n, m) && visited[i][j + 1] == 0 && grid[i][j + 1] == '1') {
            dfs(grid, visited, i, j + 1 , n, m);      
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];

        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    dfs(grid, visited, i, j, n, m);
                    count = count + 1;
                }
            }
        }

        return count;
    }
}

// class Solution {
//     int n;
//     int m;

//     public boolean isValid(int i, int j) {
//         if(i >= 0 && i < n && j >=0 && j < m){
//             return true;
//         }else{
//             return false;
//         }
//     }

//     public void DFS(char[][] grid, int x, int y, boolean visited[][]) {
        
//         visited[x][y] = true;

//         if(isValid(x + 1, y) && visited[x + 1][y] == false && grid[x + 1][y] == '1'){
//             DFS(grid, x + 1, y, visited);
//         }
//         if(isValid(x - 1, y) && visited[x - 1][y] == false && grid[x - 1][y] == '1'){
//             DFS(grid, x - 1, y, visited);
//         }
//         if(isValid(x, y + 1) && visited[x][y + 1] == false && grid[x][y + 1] == '1'){
//             DFS(grid, x , y + 1, visited);
//         }
//         if(isValid(x, y - 1) && visited[x][y - 1] == false && grid[x][y - 1] == '1'){
//             DFS(grid, x, y - 1, visited);
//         }
//     }

//     public int numIslands(char[][] grid) {

//         n = grid.length;
//         m = grid[0].length;

//         boolean visited[][] = new boolean[n][m];

//         //System.out.println("n :" + n);

//         //System.out.println("m :" + m);

//         int count = 0;

//         for(int i = 0;i < n;i++){
//             for(int j = 0;j < m;j++){
//                 if(grid[i][j] == '1' && visited[i][j] == false){
//                     DFS(grid, i, j, visited);
//                     count = count + 1;
//                 }
//             }
//         }

//         return count;
//     }
// }
