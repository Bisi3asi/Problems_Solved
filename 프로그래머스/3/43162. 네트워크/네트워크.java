import java.util.*;

class DFS {
    private int[][] computers;
    public boolean[] visited;
    
    DFS(int[][] computers, int n) {
        this.computers = computers;
        this.visited = new boolean[n];
    }

    public void calc(int target, int n){
        visited[target] = true;
        
        for (int i = 0; i < n; i++) {
            if (i == target) continue;
            if (!visited[i] && computers[target][i] == 1) calc(i, n);
        } 
    }
}

class Solution {
    public int solution(int n, int[][] computers) {
        DFS dfs = new DFS(computers, n);
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!dfs.visited[i]) {
                dfs.calc(i, n);
                answer++;
            }
        }
        
        return answer;
    }
}