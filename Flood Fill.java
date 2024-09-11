/**

Flood Fill

**/

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {

    public boolean isValid(int i, int j, int n, int m) {
        if(i >= 0 && i < n && j >= 0 && j < m){
            return true;
        }
        return false;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        
        //System.out.println(n + " " + m);

        int startingColor = image[sr][sc];
        boolean visited[][] = new boolean[n][m];
        for(boolean a[] : visited)
            Arrays.fill(a, false);

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(sr, sc));

        while(queue.size() > 0) {
            Node curr = queue.remove();
            int p = curr.x;
            int q = curr.y;
            image[p][q] = color;
            visited[p][q] = true;

            //System.out.println(p + " " + q);

            if(isValid(p + 1, q, n, m) && visited[p + 1][q] == false && image[p + 1][q] == startingColor) {
                queue.add(new Node(p + 1, q));
            }
            if(isValid(p - 1, q, n, m) && visited[p - 1][q] == false && image[p - 1][q] == startingColor) {
                queue.add(new Node(p - 1, q));
            }
            if(isValid(p, q + 1, n, m) && visited[p][q + 1] == false && image[p][q + 1] == startingColor) {
                queue.add(new Node(p, q + 1));
            }
            if(isValid(p, q - 1, n, m) && visited[p][q - 1] == false && image[p][q - 1] == startingColor) {
                queue.add(new Node(p, q - 1));
            }
            //System.out.println(queue.size());
        }
        return image;
    }
}
