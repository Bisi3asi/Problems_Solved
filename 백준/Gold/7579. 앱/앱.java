import java.util.*;
import java.io.IOException;

class Main {

    static int[] dp;

    private int solution(int[] memorys, int[] costs, int n, int m, int maxM) {
        
        // index = 줄일 메모리 dp[last] = m만큼 줄일 때 최소 비용)
        // 그렇기 때문에 메모리는 전체 합으로 잡아야함.
        // dp[i] = 메모리별 최소 비용 
        dp = new int[maxM + 1];        
        for (int i = 1; i < maxM + 1; i++) {
            dp[i] = 10_000_000;
        };

        // 앱 하나씩 순회하며
        for (int i = 0; i < n; i++) {
            // 메모리만큼 줄인다.
            for (int j = maxM; j >= memorys[i]; j--) {
                dp[j] = Math.min(dp[j], dp[j - memorys[i]] + costs[i]);
            }
        }

        int answer = dp[m];
        for (int i = m + 1; i < maxM + 1; i++) answer = Math.min(answer, dp[i]);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] memorys = new int[n];
        int[] costs = new int[n];
        int maxM = 0;
        
        for (int i = 0; i < n; i++) {
            memorys[i] = sc.nextInt();
            maxM += memorys[i];
        }
        for (int i = 0; i < n; i++) {
            costs[i] = sc.nextInt();
        }

        System.out.println(T.solution(memorys, costs, n, m, maxM));
        sc.close();
    }
}