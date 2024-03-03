class Solution {
    public int solution(int n) {
        
        int answer = 0;
        
        for (int i = n; i >= 1; i--) {
            if (i % 2 == 1) {
                if (n % i == 0) {
                    int t = n / i;
                    if (i / 2 < t) {
                        answer ++;
                    }
                } 
            }
            if (i % 2 == 0) {
                double a = (double) n / (double) i;
                if ((a * 2) % 1 == 0 && (a % 1 != 0)) {
                    int t = n / i;
                    if(i / 2 <= t) {
                        answer ++; 
                    }
                }
            }
        }
        return answer;
    }
}