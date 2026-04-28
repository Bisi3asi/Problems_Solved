import java.util.*;


class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0, lt = 0, rt = people.length - 1;
        Arrays.sort(people);
        
        while (lt <= rt) {
            if (people[lt] + people[rt] <= limit) lt++;
            rt--;
            answer++;
        }
        return answer;
    }
}