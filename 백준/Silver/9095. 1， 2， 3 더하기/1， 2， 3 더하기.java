import java.io.IOException;
import java.util.*;

class Main {
    private static int[] dp;

    private int solution(int x) {
        dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // Bottom-Up
        for (int i = 4; i <= x; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[x];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        
        Scanner sc = new Scanner(System.in);
        
        
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            System.out.println(T.solution(x));
        }

        sc.close();
    }
}