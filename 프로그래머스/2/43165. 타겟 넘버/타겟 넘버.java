class DFS {
    private int target; 
    private int[] numbers;
    public int sum;
    
    public DFS(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        this.sum = 0;
    }
    
    public int calc(int depth, int sum) {
        if (depth == numbers.length) return sum == target ? 1 : 0;
        return calc(depth + 1, sum + numbers[depth]) + calc(depth + 1, sum - numbers[depth]);
    }
}

class Solution {
    public int solution(int[] numbers, int target) {
        DFS dfs = new DFS(numbers, target);
        return dfs.calc(0, 0);
    }
}