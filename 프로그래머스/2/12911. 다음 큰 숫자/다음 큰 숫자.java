class Solution {
    public int calc(int n) {
        int cnt = 0;
        while (n != 0) {
            if ((n % 2) == 1) cnt++;
            n /= 2;
        }
        return cnt;
    }
    
    public int solution(int n) {
        int prevCnt = calc(n);
        
        for (int i = n + 1; i < Integer.MAX_VALUE; i++) {
            if (prevCnt == calc(i)) return i;
        }
        return Integer.MAX_VALUE;
    }
}