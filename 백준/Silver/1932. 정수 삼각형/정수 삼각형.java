import java.util.*;
import java.io.IOException;

class Main {
    private int solution(int[][] triangle) {

        int[][] dp = new int[triangle.length][triangle[0].length];
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[0].length; j++) {
                if(j == 0) dp[i][j] = dp[i-1][j] + triangle[i][j];
                else if(j == triangle[0].length - 1) dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                else dp[i][j] += Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
            }
        }
        
        int answer = 0;
        for (int i = 0; i < dp[0].length; i++) {
            answer = Math.max(answer, dp[dp.length - 1][i]);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] triangle = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++) triangle[i][j] = sc.nextInt();
        }

        System.out.println(T.solution(triangle));
        sc.close();
    }
}