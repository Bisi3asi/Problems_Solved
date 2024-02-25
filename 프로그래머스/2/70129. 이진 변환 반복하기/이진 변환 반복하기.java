import java.util.*;

class Solution {
    public int[] solution(String s) {
       
        int trial = 0, cnt = 0;
        PriorityQueue<Character> q;
        StringBuilder sb = new StringBuilder(s);
        char[] sbArr;
        
        while(!sb.toString().contentEquals("1")){
            trial++;
            int zeroSum = 0;
            
            sbArr = sb.toString().toCharArray();
            Arrays.sort(sbArr);

            for(int i = 0; i < sbArr.length; i++) {
                if (sbArr[i] == '1') {
                    zeroSum = i;
                    cnt += zeroSum;
                    break;
                }
            }
        
            sb = new StringBuilder(Integer.toBinaryString(sbArr.length - zeroSum));
        }
        
        return new int[]{trial, cnt};
    }
        
        
}