import java.util.*;

class BFS {
    private String[] words;
    private String begin, target;
    
    BFS (String begin, String target, String[] words) {
        this.words = words;
        this.begin = begin;
        this.target = target;
    }
    
    public int calc() {
        // suedo code
        // if (!words.contains(target)) return 0;
        
        boolean[] converted = new boolean[words.length];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.word.equals(target)) return node.move;

            for (int i = 0; i < words.length; i++) {
                String now = words[i];
                int diffCnt = 0;
                
                for (int j = 0; j < now.length(); j++) {
                    if (diffCnt > 1) break;
                    if (now.charAt(j) != node.alphabets[j]) 
                        diffCnt++;
                }
                if (diffCnt == 1 && !converted[i]) {
                    converted[i] = true;
                    q.offer(new Node(now, ++node.move));
                }
            }
        }
        return 0;
    }
}

class Node {
    String word;
    char[] alphabets;
    int move;
    
    Node(String word, int move) {
        this.word = word;
        this.move = move;
        this.alphabets = word.toCharArray();
    } 
}
    
class Solution {
    public int solution(String begin, String target, String[] words) {
        return new BFS(begin, target, words).calc();
    }
}