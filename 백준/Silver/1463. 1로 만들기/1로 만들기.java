import java.io.IOException;
import java.util.*;

class Main {
    private static int[] dp;

    private int solution(int x) {
        dp = new int[x + 1];

        // Bottom-Up
        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);

        }
        return dp[x];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        System.out.println(T.solution(x));
        sc.close();
    }
}