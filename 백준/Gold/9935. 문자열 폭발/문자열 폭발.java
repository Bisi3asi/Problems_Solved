import java.util.*;
import java.io.IOException;

class Main{
    private String solution(String str, String trigger) {
        char[] arr = str.toCharArray();
        int tLen = trigger.length();
        char[] stack = new char[str.length()];
        int top = 0;

        for (char c : arr) {
            stack[top++] = c;

            if (top >= tLen && stack[top-1] == trigger.charAt(tLen-1)) {
                boolean match = true;
                for (int i = 0; i < tLen; i++) {
                    if (stack[top - tLen + i] != trigger.charAt(i)) {
                        match = false;
                        break;
                    }
                }
                if (match) top -= tLen;
            }
        }

        if (top == 0) return "FRULA";
        return new String(stack, 0, top);
    }


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String trigger = sc.nextLine();

        System.out.print(T.solution(str, trigger));

        sc.close();
    }
}