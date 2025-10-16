import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Coin implements Comparable<Coin> {
	int price;
	int cnt;

	Coin(int price, int cnt) {
		this.price = price;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Coin o) {
		return this.price - o.price; // 동전 가격별 오름차순 정렬
	}
}

public class Main {
	// dy[i] 각 i라는 금액을 만들 수 있는 가지수
	static int[] dy;

	public static int solution(List<Coin> coins) {
		dy[0] = 1; // index 1 기반으로 0 미사용

		for (Coin coin : coins) {
			for (int i = dy.length - 1; i >= 1; i--) {
				for (int c = 1; c <= coin.cnt; c++) {
					if (i - c * coin.price >= 0) {
						dy[i] += dy[i - c * coin.price]; // i원을 만드는 모든 방법 + price원 c개
					}
				}
			}
		}
		return dy[dy.length-1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Coin> coins = new ArrayList<>();

		// 금액
		int amount = sc.nextInt();
		dy = new int[amount + 1];

		// 동전 개수
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int price = sc.nextInt();
			int cnt = sc.nextInt();
			coins.add(new Coin(price, cnt));
		}
		Collections.sort(coins); // 오름차순 정렬
		System.out.println(solution(coins));
		sc.close();
	}
}