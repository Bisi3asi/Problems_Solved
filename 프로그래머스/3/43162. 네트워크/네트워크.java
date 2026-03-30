import java.util.*;

// 프로그래머스 - 네트워크
// 연결된 컴퓨터 그룹(네트워크) 개수 찾기
// 핵심: DFS로 연결된 모든 컴퓨터 방문 → 한 번의 DFS = 네트워크 1개
class DFS {
    private int[][] computers; // 인접 행렬
    public boolean[] visited;  // 방문 여부

    DFS(int[][] computers, int n) {
        this.computers = computers;
        this.visited = new boolean[n];
    }

    // target에서 시작해서 연결된 모든 컴퓨터 방문
    public void calc(int target, int n) {
        visited[target] = true; // 현재 컴퓨터 방문 처리

        for (int i = 0; i < n; i++) {
            if (i == target) continue; // 자기 자신 제외
            // 아직 방문 안 했고 연결되어 있으면 재귀 탐색
            if (!visited[i] && computers[target][i] == 1) calc(i, n);
        }
    }
}

class Solution {
    public int solution(int n, int[][] computers) {
        DFS dfs = new DFS(computers, n);
        int answer = 0;

        for (int i = 0; i < n; i++) {
            // 아직 방문 안 한 컴퓨터 = 새로운 네트워크 발견
            if (!dfs.visited[i]) {
                dfs.calc(i, n); // 연결된 모든 컴퓨터 방문
                answer++;       // 네트워크 카운트
            }
        }

        return answer;
    }
}