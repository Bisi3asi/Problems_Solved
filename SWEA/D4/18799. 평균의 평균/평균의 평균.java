
import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class Solution {
	public ArrayList<ArrayList<Integer>> calc(int n, int[] arr) {
		ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
		for(int i = 1; i < (1 << n); i++) {
			ArrayList<Integer> current = new ArrayList<>();
			for(int j = 0; j < n; j++) {
				if((i & ( 1 << j)) > 0) {
					current.add(arr[j]);
				}
			}
			answer.add(current);
		}
		
		return answer;
	}
	

	public static void main(String[] args) throws Exception {
		 Solution solution = new Solution();
		 Scanner sc = new Scanner(System.in);
		 int t = Integer.parseInt(sc.nextLine());
		 for(int i = 1; i <= t; i++) {
			 int n = Integer.parseInt(sc.nextLine());
			 int[] arr = new int[n];
			 for(int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			 }
			 sc.nextLine();
			 
			 ArrayList<Double> midCalc = new ArrayList<>();
			 for (ArrayList<Integer> subset : solution.calc(n, arr)) {
				 double sum = 0.0;
				 for(int element : subset) {
					 sum += element;
				 }
				 midCalc.add(sum / subset.size());
			 }
			 
			 double sum = 0.0;
			 for(double element : midCalc) {
				 sum += element;
			 }
			 double avg = sum / midCalc.size();
			 DecimalFormat dcf = new DecimalFormat("#.####################");
			 String formatValue = dcf.format(avg);
			 System.out.println("#"+i+" "+formatValue);
		 }
	}
}
