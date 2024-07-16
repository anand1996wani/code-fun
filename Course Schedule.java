//207. Course Schedule

class Graph{

    int num;
    int visited[];
    int helper[];
    ArrayList<ArrayList<Integer>> adjList;

    public Graph(int n){
        this.num = n;
        this.visited = new int[n];
        this.helper = new int[n];

        this.adjList = new ArrayList<ArrayList<Integer>>();

        for(int i = 0;i < n;i++){
            this.adjList.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int i, int j){
        this.adjList.get(i).add(j);
    }

    public boolean DFS(int curr){
        this.visited[curr] = 1;
        this.helper[curr] = 1;

        for(int n : this.adjList.get(curr)){
            if(this.visited[n] == 0){
                if(this.helper[n] == 0)
                    if(this.DFS(n)){
                        return true;
                    }
            }else{
                if(this.helper[n] == 1){
                    return true;
                }
            }
        }
        this.helper[curr]  = 0;
        return false;
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Graph graph = new Graph(numCourses);

        for(int i = 0;i < prerequisites.length;i++){
            graph.addEdge(prerequisites[i][1], prerequisites[i][0]);
        }

        boolean isCycle = false;

        //Normal DFS call
        for(int i = 0;i < numCourses;i++){
            if(graph.visited[i] == 0){
                isCycle = isCycle || graph.DFS(i);
            }
        }
        
        return !isCycle;
    }
}
