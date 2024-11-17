import java.util.*;

public class Solution {
        public static int solution(int n) {
        
        int batteryUsed = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                batteryUsed++;
                n--;
            }
            n /= 2;
        }
        return batteryUsed;
    }
}