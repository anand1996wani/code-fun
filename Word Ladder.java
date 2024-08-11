/*
* Word Ladder    https://leetcode.com/problems/word-ladder/description/?source=submission-noac
*/

class Solution {
    
    public boolean checkEdge(String u, String v) {
        int count = 0;

        for(int i = 0;i < u.length();i++){
            if(u.charAt(i) == v.charAt(i)) { 
                continue;
            }else{
                count++;
            }
        }

        if(count == 1) {
            return true;
        }else {
            return false;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        int count = 0;
        hashMap.put(beginWord, count);
        count = count + 1;
        for(String s : wordList){
            if(hashMap.get(s) == null){
                hashMap.put(s, count);
                count = count + 1;
            }
        }

        if(hashMap.get(endWord) == null) { 
            return 0;
        }else{
            ArrayList<ArrayList<Integer>> adjList  = new ArrayList<ArrayList<Integer>>();
            int n = hashMap.size();
            for(int i = 0;i < n;i++){
                adjList.add(new ArrayList<Integer>());
            }

            for(int i = 0;i < wordList.size();i++){
                for(int j = i + 1;j < wordList.size();j++) {
                    if(this.checkEdge(wordList.get(i), wordList.get(j))){

                        int u = hashMap.get(wordList.get(i));
                        int v = hashMap.get(wordList.get(j));

                        adjList.get(u).add(v);
                        adjList.get(v).add(u);
                    }
                }
            }

            for(int z = 0;z < wordList.size();z++){
                if(this.checkEdge(wordList.get(z), beginWord)) {

                    int u = hashMap.get(wordList.get(z));
                    int v = hashMap.get(beginWord);

                    adjList.get(u).add(v);
                    adjList.get(v).add(u);
                }
            }

            int start = 0;
            int end = hashMap.get(endWord);
            int visited[] = new int[hashMap.size()];
            int ans = 0;
            Queue<Integer> queue = new LinkedList<Integer>();
            int marker = -1;
            queue.add(start);
            visited[start] = 1;
            queue.add(marker);
            boolean ansValid = false;

            while(queue.size() > 0){
                int curr = queue.remove();
                if(curr == end){
                    return ans + 1;
                }
                if(curr == marker){
                    if(queue.size() == 0){
                        break;
                    }else{
                        ans++;
                        queue.add(marker);
                        continue;
                    }
                }else{
                    for(int v : adjList.get(curr)){
                        if(visited[v] != 1){
                            visited[v] = 1;
                            queue.add(v);
                        }
                    }
                }
            }

            return 0;
        }
    }
}
