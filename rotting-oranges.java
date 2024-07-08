class Solution {
    class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public boolean areAllOrangesRotten(int[][] grid){
        boolean flag = true;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 1)
                flag = false;
            }
        }
        return flag;
    }

    public int orangesRotting(int[][] grid) {
        Queue<Node> queue = new LinkedList<Node>();
        int maxTime = 0;
        int fresh = 0;
        //int [][]visited = new int[grid.length][grid[0].length];
        
        //Pre-Process
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 2){
                    //System.out.println(i + " " + j);
                    queue.add(new Node(i, j));
                    //visited[i][j] = 1;
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        Node marker = new Node(-1, -1);
        queue.add(marker);

        while(queue.size() > 0){
            Node curr = queue.remove();
            if(curr.x == -1 && curr.y == -1){
                if(queue.size() == 0){
                    break;
                }else{
                    maxTime++;
                    queue.add(curr);
                }
            }else{
                //Normal node
                //System.out.println(curr.x + " " + curr.y);

                if((curr.x - 1) >= 0 && grid[curr.x - 1][curr.y] == 1){
                    grid[curr.x - 1][curr.y] = 2;
                    queue.add(new Node(curr.x - 1, curr.y));
                }
                if((curr.x + 1) < grid.length && grid[curr.x + 1][curr.y] == 1){
                    grid[curr.x + 1][curr.y] = 2;
                    queue.add(new Node(curr.x + 1, curr.y));
                }
                if((curr.y - 1) >= 0 && grid[curr.x][curr.y - 1] == 1){
                    grid[curr.x][curr.y - 1] = 2;
                    queue.add(new Node(curr.x, curr.y - 1));
                }
                if((curr.y + 1) < grid[0].length && grid[curr.x][curr.y + 1] == 1){
                    grid[curr.x][curr.y + 1] = 2;
                    queue.add(new Node(curr.x, curr.y + 1));
                }
            }
        }

        return areAllOrangesRotten(grid) ? maxTime : -1;
    }
}
