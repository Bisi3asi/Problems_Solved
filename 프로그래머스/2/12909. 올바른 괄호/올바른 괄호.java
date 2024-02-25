import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Queue<Character> q = new LinkedList<>();
        
        char[] sArr = s.toCharArray();
        for(char c : sArr){
            if(q.isEmpty() && c == ')'){
                answer = false;
                break;
            }
            if(c == '(') q.offer(c);
            else q.poll();
        }
        
        if (!q.isEmpty()) answer = false;
        return answer;
    }
}