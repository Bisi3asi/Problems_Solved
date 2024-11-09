class Solution {
    public static long[] arr = new long[100001];
    
    public long fibo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (arr[n] != 0) return arr[n];
        else arr[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
        return arr[n];
    }    
    
    public long solution(int n) {
        return fibo(n);
    }
}