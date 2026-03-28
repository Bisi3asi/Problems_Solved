import java.util.*;
import java.io.IOException;

class Main {

    static int[] dp;

    private int solution(int[] w, int[] p, int n, int k) {
        
        // index = 무게, dp[i] = 무게별 가치의 최대값 
        dp = new int[k + 1];

        // i = 물건 번호
        // j = 무게 한도

        // 물건 순서대로 순회
        for (int i = 0; i < n; i++) { 
            // 무게 한도 k부터, i번째 물건을 넣을 수 있는 최소 무게까지 줄여가며
            for (int j = k; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + p[i]);
            }
        }

        return dp[k];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] w = new int[n];
        int[] p = new int[n];
        
        for (int i = 0; i < n; i++){
            w[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        System.out.println(T.solution(w, p, n, k));
        sc.close();
    }
}