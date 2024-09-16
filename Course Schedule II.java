/**

Course Schedule II

https://leetcode.com/problems/course-schedule-ii/description/

*/

class Graph {
    ArrayList<ArrayList<Integer>> arrayList;
    int visited[];
    int n;
    int tempVisited[];
    Stack <Integer>stack;

    public Graph(int num) {
        this.n = num;
        this.arrayList = new ArrayList<ArrayList<Integer>>();
        this.visited = new int[num];
        stack = new Stack<Integer>();

        for(int i = 0; i< num;i++){
            this.arrayList.add(new ArrayList<Integer>());
        }

        this.tempVisited = new int[num];
    }

    public void addEdge(int u, int v) {
        this.arrayList.get(u).add(v);
    }

    public boolean dfs(int index) {
        visited[index] = 1;
        tempVisited[index] = 1;

        for(int j : this.arrayList.get(index)){
            if(visited[j] != 1){
                if(dfs(j)){
                    return true;
                }
            }else if(tempVisited[j] == 1){
                return true;
            }
        }
        tempVisited[index] = 0;
        stack.push(index);
        return false;
    }
}
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);

        for(int i = 0;i < prerequisites.length;i++){
            graph.addEdge(prerequisites[i][1], prerequisites[i][0]);
        }

        boolean flag = false;

        for(int i = 0;i < numCourses;i++){
            if(graph.visited[i] == 0){
                flag = flag | graph.dfs(i);
            }
        }
        int a[] = {};

        if(flag){
            return a;
        }else{
            int ans[] = new int[numCourses];
            int z = 0;
            while(graph.stack.size() > 0){
                ans[z++] = graph.stack.pop();
            }
            return ans;
        }
    }
}
