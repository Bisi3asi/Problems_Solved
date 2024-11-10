class Solution {
    public int[] solution(int brown, int yellow) {
        int width, height;
        
        for (int i = 1; i < brown + yellow; i++) {
            if ((brown + yellow) % i == 0) {
                width = Math.max((brown + yellow) / i, i);
                height = Math.min((brown + yellow) / i, i);
                if ((width - 2) * (height - 2) == yellow) return new int[]{width, height};
            }
        }
        return new int[]{-1, -1};
    }   
}