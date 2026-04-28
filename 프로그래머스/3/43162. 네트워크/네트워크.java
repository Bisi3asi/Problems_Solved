class DFS {
    boolean[] visited;
    int[][] computers;
    
    DFS(int n, int[][] computers) {
        this.visited = new boolean[n];
        this.computers = computers;
    }
    
    void calc(int node) {
        visited[node] = true;
        for (int i = 0; i < computers[node].length; i++) {
            if (computers[node][i] == 1 && !visited[i]) calc(i);
        }
    }
}

class Solution {
    public int solution(int n, int[][] computers) {
        DFS dfs = new DFS(n, computers);
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!dfs.visited[i]) {
                dfs.calc(i);
                answer++;
            }
        }
        return answer;
    }
}