import java.util.*;

public class Main {
	private int solution(int[][] map) {
		int h = map.length;
		int w = map[0].length;

		boolean[][] visited = new boolean[h][w];

		// 8방위 (대각선)
		int[] mx = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] my = {-1, 0, 1, -1, 1, -1, 0, 1};

		int count = 0;
		Queue<int[]> queue = new LinkedList<>();

		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				if (map[y][x] == 1 && !visited[y][x]) {
					count++;

					queue.offer(new int[]{y, x});
					visited[y][x] = true;

					while(!queue.isEmpty()) {
						int[] now = queue.poll();

						for (int d = 0; d < 8; d++) {
							int afterX = now[1] + mx[d];
							int afterY = now[0] + my[d];

							if(afterX >= 0 && afterY >= 0 && afterX < w && afterY < h) {
								if(map[afterY][afterX] == 1 && !visited[afterY][afterX]) {
									visited[afterY][afterX] = true;
									queue.offer(new int[]{afterY, afterX});
								}
							}
						}
					}
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main T = new Main();

		while (true) {
			int w = sc.nextInt();
			int h = sc.nextInt();

			if (w == 0 && h == 0) {
				break;
			}

			int map[][] = new int[h][w];
			for (int y = 0; y < h; y++) {
				for (int x = 0; x < w; x++) {
					map[y][x] = sc.nextInt();
				}
			}
			System.out.println(T.solution(map));
		}
		sc.close();
	}
}