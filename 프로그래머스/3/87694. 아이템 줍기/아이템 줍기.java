import java.util.*;

class Node {
    int posX, posY, move;
    
    Node (int x, int y, int move) {
        this.posX = x;
        this.posY = y;
        this.move = move;
    }
}

class BFS {
    private int[][] rectangle;
    private int characterX, characterY, itemX, itemY;
    private boolean[][] canVisit;
    private final int MAX = 100;
    
    BFS (int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        this.rectangle = rectangle;
        this.characterX = characterX * 2;
        this.characterY = characterY * 2;
        this.itemX = itemX * 2;
        this.itemY = itemY * 2;
        
        canVisit = new boolean[MAX + 1][MAX + 1];
        defineAvailableArea();
    }
    
    private void defineAvailableArea() {
        for (int[] r : rectangle) { // 테두리 포함 전부 칠하기
            for (int x = r[0] * 2; x <= r[2] * 2; x++) {
                for (int y = r[1] * 2; y <= r[3] * 2; y++) {
                    canVisit[x][y] = true;
                }
            }      
        }
        for (int[] r : rectangle) { // 테두리 빼고 전부 다시 없애기
            for (int x = r[0] * 2 + 1; x < r[2] * 2; x++) { 
                for (int y = r[1] * 2 + 1; y < r[3] * 2; y++) {
                    canVisit[x][y] = false;
                }
            }
        }
    }
    
    public int calc() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(characterX, characterY, 0));
            
        while (!q.isEmpty()) {
            Node node = q.poll();
            canVisit[node.posX][node.posY] = false;
            
            if (node.posX == itemX && node.posY == itemY)
                return node.move / 2;
            
            for(int[] dir : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                int nx = node.posX + dir[0], ny = node.posY + dir[1];
                if (nx >= 0 && ny >= 0 && nx < 101 && ny < 101 && canVisit[nx][ny])
                    q.add(new Node(nx, ny, ++node.move));
            }
        }
        return -1;
    }      
}

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        return new BFS(rectangle, characterX, characterY, itemX, itemY).calc(); 
    }
}