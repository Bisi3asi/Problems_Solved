import java.util.*;

class BFS {
    private int[][] maps;
    private int MAX_X, MAX_Y;
    private int answer = Integer.MAX_VALUE;
    private int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    BFS (int[][] maps) {
        this.maps = maps;
        this.MAX_X = maps[0].length;
        this.MAX_Y = maps.length;
    }
    
    public int calc() {
        boolean[][] visitied = new boolean[MAX_Y][MAX_X];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1));
        visitied[0][0] = true;
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x, y = node.y, move = node.move;
            
            if (x == MAX_X - 1 && y == MAX_Y - 1) return move; // 도착하면 최단 거리 반환

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                if (nx >= 0 && nx < MAX_X && ny >= 0 && ny < MAX_Y) {
                    if (!visitied[ny][nx] && maps[ny][nx] == 1) {
                        q.add(new Node(nx, ny, move + 1));
                        visitied[ny][nx] = true;
                    }
                }
            }
        }
        return -1;
    }
}

class Node {
    int x, y, move;
    
    Node(int x, int y, int move) {
        this.x = x;
        this.y = y;
        this.move = move;
    }
}

class Solution {
    public int solution(int[][] maps) {
        return new BFS(maps).calc();
    }
}