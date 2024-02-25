import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int lt = 0, rt = A.length-1;
        int answer = 0; 
        for (int cnt = 1; cnt <= A.length; cnt++) {
            answer += A[lt] * B[rt];
            lt++;
            rt--;
        }
        
        return answer;
    }
}