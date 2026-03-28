import java.io.IOException;
import java.util.*;

class Main {
    private static int[] dp;

    private int solution(int[] stairs) {
        dp = new int[stairs.length];
        dp[1] = stairs[1];
        if (stairs.length - 1 == 1) return dp[1]; 
        dp[2] = stairs[1] + stairs[2];
        if (stairs.length - 1 == 2) return dp[2];

        // Bottom-Up
        for (int i = 3; i < stairs.length; i++) {
            dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
        }
        return dp[stairs.length - 1];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] stairs = new int[n + 1];

        for (int i = 1; i <= n; i++) stairs[i] = sc.nextInt();
        System.out.println(T.solution(stairs));

        sc.close();
    }
}