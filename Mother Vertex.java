
/**
 * 
 * Given a Directed Graph, find a Mother Vertex in the Graph (if present). A Mother Vertex is a vertex through which we can reach all the other vertices of the Graph.
 * 
 */
class Solution
{
    int motherVertex;
    
    public void DFSMotherVertex(int currVertex, int[] visited, ArrayList<ArrayList<Integer>>adj){
        visited[currVertex] = 1;
        for(int j : adj.get(currVertex)){
            if(visited[j] == 0){
                this.DFSMotherVertex(j, visited, adj);
            }
        }
        this.motherVertex = currVertex;
    }
    
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        //Approach One -> O(V * (V + E))
        
        /*for(int i = 0;i < adj.size();i++){
            int visited[] = new int[adj.size()];
            //Call DFS for each vertex
            this.DFSMotherVertex(i, visited, adj);
            
            int count = 0;
            for(int c : visited){
                if(c == 1)
                    count++;
            }
            if(count == adj.size()){
                return i;
            }
        }
        
        return -1;//No Mother Vertex
        */
        
        //Approach Two -> O(V + E)
        int visited[] = new int[adj.size()];
        //DFS in Graph
        for(int i = 0;i < adj.size();i++){
            if(visited[i] == 0){
                this.DFSMotherVertex(i, visited, adj);
            }
        }
        
        //check if vertex is acctually a mother vertex
        visited = new int[adj.size()];
        DFSMotherVertex(this.motherVertex, visited, adj);
        int count = 0;
        for(int j : visited){
            if(j == 1)
                count++;
        }
        if(count == adj.size()){
            return this.motherVertex;
        }else{
            return -1;
        }
    }
}
