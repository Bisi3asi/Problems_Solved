import java.util.*;

class Main {
    public ArrayList<Integer> solution(int[][] map) {

        ArrayList<Integer> result = new ArrayList<>();
        
        int[] mx = new int[]{-1, 1, 0, 0};
        int[] my = new int[]{0, 0, -1, 1};
        
        int h = map.length;
        int w = map[0].length;


        int total = 0, cnt = 0;
        boolean visited[][] = new boolean[h][w];

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if(map[y][x] == 1 && !visited[y][x]) {
                    Queue<int[]> q = new LinkedList<>();
                    total++;
                    cnt = 1;
                    
                    visited[y][x] = true;
                    q.offer(new int[]{x, y, cnt});
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        
                        for (int i = 0; i < 4; i++) {
                            int aX = now[0] + mx[i];
                            int aY = now[1] + my[i];
                                if(aX >= 0 && aX < w && aY >= 0 && aY < h) {
                                    if(map[aY][aX] == 1 && !visited[aY][aX]) {
                                        visited[aY][aX] = true;
                                        q.offer(new int[]{aX, aY, cnt++});
                                    }
                                }
                            }
                    }
                    result.add(cnt);
                }
            }
        }
        result.add(total);
        return result;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] map = new int[n][n];

        for(int y = 0; y < n; y++) {
            String line = sc.next();
            String[] tokens = line.split("");        
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(tokens[x]);
            }
        }

        ArrayList<Integer> answer = T.solution(map);
        System.out.println(answer.remove(answer.size() -1));
        Collections.sort(answer);
        for(int i : answer) {
            System.out.println(i);
        }
        sc.close();
    }
}
