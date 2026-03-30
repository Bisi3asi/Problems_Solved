import java.io.IOException;
import java.util.*;

class Main {
    private int solution(int n, int m, int[] blueray) {
        int lt = Arrays.stream(blueray).max().getAsInt(); // 미니멈: 블루레이에 강의 하나는 담겨야 함
        int rt = Arrays.stream(blueray).sum(); // 맥시멈 상정
        int answer = 0;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            int sum = 0, cnt = 0;
            for(int i = 0; i < n; i ++) {
                if (sum + blueray[i] > mid) {
                    ++cnt;
                    --i;
                    sum = 0;
                    continue;
                }
                else sum += blueray[i];
            }
            if(cnt >= m) lt = mid + 1;
            else {
                rt = mid - 1;
                answer = mid;
            }; 
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] blueray = new int[n];

        for(int i = 0; i < n; i++) {
            blueray[i] = sc.nextInt();          
        }

        System.out.println(T.solution(n, m, blueray));

        sc.close();
    }
}