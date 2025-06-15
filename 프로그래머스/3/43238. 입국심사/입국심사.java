import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long lt = 1; // 최소 시간
        // 최대 시간(가장 느린 심사관이 모든 n명을 처리하는 시간)
        long rt = (long) Arrays.stream(times).max().getAsInt() * n;
        long answer = rt;

        // mid : 시간을 기준으로 탐색
        while (lt <= rt) {
            long mid = (lt + rt) / 2;

            long total = 0;
            for (int time : times)
                // 모든 심사관별 시간 원소를 순회하며 주어진 시간 내 처리 가능한 사람 수를 더함
                total += mid / time; 
            
            // 처리 가능할 경우 해당 시간을 리턴값으로 조정 
            if (total >= n) {
                answer = mid;
                // 해당 리턴값을 최대값으로 조정 후 재탐색하며 최대값을 줄여나감
                rt = mid - 1;
            } else {
                // 처리 불가능할 경우 최소값을 mid + 1로 조정해 재탐색
                lt = mid + 1;
            }
        }

        return answer;
    }
}