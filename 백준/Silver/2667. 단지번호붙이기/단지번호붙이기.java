import java.util.*;

public class Main {
	private ArrayList<Integer> solution(int[][] map) {
		int h = map.length;
		int w = map[0].length;

		int[] mx = new int[]{1, -1, 0, 0};
		int[] my = new int[]{0, 0, -1, 1}; 
        
        ArrayList<Integer> arr = new ArrayList<>();
        int total = 0, cnt = 0;
		boolean[][] visited = new boolean[h][w];
        
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if(map[y][x] == 1 && !visited[y][x]) {
                    total++;
                    cnt = 1;
                    Queue<int[]> queue = new LinkedList<>();
                    
                    visited[y][x] = true;
                    queue.offer(new int[]{x,y, cnt});

                    while(!queue.isEmpty()) {
                        int[] now = queue.poll();

                        for (int d = 0; d < 4; d++) {
                            int ax = now[0] + mx[d];
                            int ay = now[1] + my[d];

                            if(ax >= 0 && ay >= 0 && ax < w && ay < h) {
                                if(map[ay][ax] == 1 && !visited[ay][ax]) {
                                    visited[ay][ax] = true;
                                    queue.offer(new int[]{ax, ay, ++cnt});
                                }
                            }
                        }
                    }
                    arr.add(cnt);
                }
            }
        }
        arr.add(total);
        return arr;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main T = new Main();

		int n = sc.nextInt();
		int[][] map = new int[n][n];

		for (int y = 0; y < n; y++) {
			String line = sc.next();
			for (int x = 0; x < n; x++) {
				map[y][x] = line.charAt(x) - '0';
			}
		}
		ArrayList<Integer> answer = (T.solution(map));
        
        System.out.println(answer.remove(answer.size()-1));
        Collections.sort(answer);
        
        for (int i : answer) {
            System.out.println(i);
        }

		sc.close();
	}
}