import java.util.*;

class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static void dfs(int node) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) dfs(next);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer>[] temp = new ArrayList[n + 1];
        graph = temp;
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[n + 1];
        int count = 0;
    
        dfs(1);
        for(int i = 1; i <= n; i++) {
            if(visited[i]) count++;
        }

        System.out.print(count - 1);
        sc.close();
    }
}
