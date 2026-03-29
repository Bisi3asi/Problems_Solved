import java.util.*;
import java.io.IOException;

class Main {

    static int[] dp;

    private int solution(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(T.solution(nums));
        sc.close();
    }
}