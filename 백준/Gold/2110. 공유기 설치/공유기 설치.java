import java.util.*;
import java.io.IOException;

class Main{
    private int solution(int n, int c, int[] pos) {
        int lt = 1; // 최소 거리 최솟값 (사실 구해야하지만 귀찮다)
        int rt = pos[n - 1] - pos[0]; // 최대 집 거리 차이나는 값 (끝에서 끝까지)
        int mid = 0;
        int quota = 0;
        int answer = 0;

        while(lt <= rt) {
            mid = (lt + rt) / 2;
            // 맨 첫번째에 무조건 공유기를 먼저 설치해야 한다. 
            int last = pos[0];
            quota = c - 1;
            for (int i = 1; i < n; i++) {
                if (pos[i] - last >= mid) {
                    quota--;
                    last = pos[i];
                }
            }

            if(quota <= 0) {
                answer = mid;
                lt = mid + 1;
            };
            if(quota > 0) rt = mid - 1;
        }

        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[i] = sc.nextInt();
        }

        Arrays.sort(pos);
        System.out.print(T.solution(n, c, pos));

        sc.close();
    }
}