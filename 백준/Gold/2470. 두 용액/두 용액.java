import java.util.*;
import java.io.IOException;

class Main{
    private int[] solution(int[] liquids) {
        int lt = 0;
        int rt = liquids.length - 1;
        int sum = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (lt < rt) {
            int current = liquids[lt] + liquids[rt];
            if (current == 0) return new int[]{lt, rt};
            if (Math.abs(sum) > Math.abs(current)) {
                sum = Math.abs(current);
                answer[0] = lt;
                answer[1] = rt;
            }
            if (current < 0) ++lt;  
            if (current > 0) --rt;
        }
        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] liquids = new int[n];

        for (int i = 0; i < n; i++) {
            liquids[i] = sc.nextInt();
        }

        Arrays.sort(liquids);
        int[] answer = T.solution(liquids);
        System.out.print(liquids[answer[0]] + " " + liquids[answer[1]]);

        sc.close();
    }
}