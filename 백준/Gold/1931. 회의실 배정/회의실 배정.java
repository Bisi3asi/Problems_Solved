import java.util.*;
import java.io.IOException;

class Consen implements Comparable<Consen> {
    int st;
    int et;

    Consen (int st, int et) {
        this.st = st;
        this.et = et;
    }

    @Override
    public int compareTo(Consen c) {
        return this.et == c.et ? this.st - c.st : this.et - c.et;
    }
}

class Main{
    private int solution(int n, List<Consen> consens) {
        // 종료시간 오름차순, 같으면 시작시간 오름차순 정렬
        Collections.sort(consens);

        int count = 0;
        int lastEnd = 0;  // 마지막으로 선택한 회의의 종료시간

        for (Consen c : consens) {
            // 현재 회의 시작시간이 lastEnd 이상이면 선택 가능
            if (c.st >= lastEnd) {
                count++;
                lastEnd = c.et;
            }
        }

        return count;
    }


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Consen> consens = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            consens.add(new Consen(sc.nextInt(), sc.nextInt()));
        }

        System.out.print(T.solution(n, consens));

        sc.close();
    }
}