import java.util.*;

public class Main {
	private int solution(int[][] map) {
		int h = map.length;
		int w = map[0].length;

		int[] mx = new int[]{1, -1, 0, 0};
		int[] my = new int[]{0, 0, -1, 1}; 

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0,0,1});
		boolean[][] visited = new boolean[h][w];
		visited[0][0] = true;

		while(!queue.isEmpty()) {
			int[] now = queue.poll();

			int y = now[0];
			int x = now[1];
			int cnt = now[2];

			if ((x == w-1) && (y == h-1)) return cnt;

			for (int d = 0; d < 4; d++) {
				int ax = x + mx[d];
				int ay = y + my[d];

				if(ax >= 0 && ay >= 0 && ax < w && ay < h) {
					if(map[ay][ax] == 1 && !visited[ay][ax]) {
						visited[ay][ax] = true;
						queue.offer(new int[]{ay, ax, cnt + 1});
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main T = new Main();

		int h = sc.nextInt();
		int w = sc.nextInt();
		int[][] map = new int[h][w];

		for (int y = 0; y < h; y++) {
			String line = sc.next();
			for (int x = 0; x < w; x++) {
				map[y][x] = line.charAt(x) - '0';
			}
		}
		System.out.println(T.solution(map));

		sc.close();
	}
}