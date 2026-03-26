import java.util.*;

public class Main {
	private int solution(int[][] map) {
		int h = map.length;
		int w = map[0].length;

		int[] mx = new int[]{1, -1, 0, 0};
		int[] my = new int[]{0, 0, -1, 1}; 

		Queue<int[]> queue = new LinkedList<>();

		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				if (map[y][x] == 1) {
					queue.offer(new int[]{y, x, 0});
				}
			}
		}

		int maxDay = 0;

		while(!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int d = 0; d < 4; d++) {
				int ay = now[0] + my[d];
				int ax = now[1] + mx[d];

				if(ax >= 0 && ay >= 0 && ax < w && ay < h && map[ay][ax] == 0) {
					map[ay][ax] = 1;
					queue.offer(new int[]{ay, ax, now[2] + 1});
					maxDay = Math.max(maxDay, now[2] + 1);
				}
			}
		}

		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				if (map[y][x] == 0) {
					return -1;
				}
			}
		}

		return maxDay;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main T = new Main();

		int w = sc.nextInt();   // 가로
		int h = sc.nextInt();   // 세로
		int[][] map = new int[h][w];

		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				map[y][x] = sc.nextInt();
			}
		}

		System.out.println(T.solution(map));
		sc.close();
	}
}