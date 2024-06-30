class Solution {
    public int solution(int[] numbers, int target) {
        return new NumberOfCases(numbers, target).calc();
    }
}

class NumberOfCases {
    private int[] numbers;
    private int target;
    
    public NumberOfCases(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
    }
    
    public int calc() {
        return calc(0, 0);
    }
    
    public int calc(int depth, int sum) {
        if ( depth == numbers.length ) return sum == target ? 1 : 0;
        
        return calc(depth + 1, sum + numbers[depth]) + calc(depth + 1, sum - numbers[depth]);
    }   
}