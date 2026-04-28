class Solution {
    static int dp[][];
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n][m];
        boolean[][] block = new boolean[n][m];
        for (int[] p : puddles) block[p[1] - 1][p[0] - 1] = true;
        
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                    continue;
                }
                if (block[i][j]) continue;
                int up = (i > 0) ? dp[i - 1][j] : 0;
                int left = (j > 0) ? dp[i][j -1] : 0;
                dp[i][j] = (up + left) % 1_000_000_007;
            }
        }
        
        return dp[n-1][m-1];
    }
}