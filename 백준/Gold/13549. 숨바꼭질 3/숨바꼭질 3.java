import java.io.IOException;
import java.util.*;

class Main {
    private int solution(int n, int k) {

        Deque<int[]> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];

        dq.add(new int[]{n, 0});

        while (!dq.isEmpty()) {

            int[] now = dq.pollFirst();
            int x = now[0];
            int time = now[1];

            if (visited[x]) continue;
            visited[x] = true;

            if (x == k) return time;

            if (x * 2 <= 100000 && !visited[x * 2]) {
                dq.addFirst(new int[]{x * 2, time});   // cost 0
            }

            if (x - 1 >= 0 && !visited[x - 1]) {
                dq.addLast(new int[]{x - 1, time + 1}); // cost 1
            }

            if (x + 1 <= 100000 && !visited[x + 1]) {
                dq.addLast(new int[]{x + 1, time + 1}); // cost 1
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(T.solution(n, k));

        sc.close();
    }
}