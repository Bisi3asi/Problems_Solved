class Solution {
    static int dp[][];
    
    public int solution(int[][] triangle) {
        dp = new int[triangle.length][triangle[triangle.length - 1].length];
        
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int lt = j > 0 ? dp[i - 1][j - 1] : 0;
                int rt = j < i ? dp[i - 1][j] : 0;
                dp[i][j] = triangle[i][j] + Math.max(lt,rt);
            }
        }
        
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < triangle[triangle.length - 1].length - 1; i++) 
            if (answer < dp[triangle.length - 1][i]) answer = dp[triangle.length - 1][i];
        return answer;
    }
}