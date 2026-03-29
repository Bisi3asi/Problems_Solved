import java.util.*;

public class Main {
    static int[] dp;
    static int[] parent;

    private Queue<Integer> solution (List<Brick> bricks, int n) {

        // dp[i] = i 번째 블록을 맨 위에 쌓았을 때 최대 총 높이
        dp = new int[n];
        parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            dp[i] = bricks.get(i).h;

            for (int j = 0; j < i; j++) {
                // 정렬 기준이 밑면이므로 밑면은 배제, 무게만 본다.
                if (bricks.get(i).w < bricks.get(j).w) {
                    if (dp[i] < dp[j] + bricks.get(i).h) {
                        dp[i] = dp[j] + bricks.get(i).h;
                        parent[i] = j;
                    }
                }
            }
        }

        int maxHeight = 0;
        int answerIndex = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxHeight) {
                maxHeight = dp[i];
                answerIndex = i;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int cur = answerIndex;
        while (cur != -1) {
            q.offer(bricks.get(cur).index + 1);
            cur = parent[cur];
        }
        return q;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        List<Brick> bricks = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int b = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            bricks.add(new Brick(b, h, w, i));
        }

        Collections.sort(bricks);
        Queue<Integer> answer = T.solution(bricks, n);

        System.out.println(answer.size());
        while(!answer.isEmpty()) System.out.println(answer.poll());

        sc.close();
    }
}


class Brick implements Comparable<Brick> {
    int b;
    int h;
    int w;
    int index;

    Brick(int b, int h, int w, int i) {
        this.b = b;
        this.h = h;
        this.w = w;
        this.index = i;
    }

    // 밑면은 비교대상에서 배제
    @Override
    public int compareTo(Brick o) {
        return o.b - this.b;
    }
}
