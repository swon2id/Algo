class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(0, 0, numbers, target);
    }
    
    private int dfs(int index, int sum, int[] numbers, int target) {
        // 종료 조건: 모든 숫자를 사용했을 때
        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        }
        
        // 현재 숫자를 더하거나 빼는 두 가지 경우
        int plus = dfs(index + 1, sum + numbers[index], numbers, target);
        int minus = dfs(index + 1, sum - numbers[index], numbers, target);
        
        return plus + minus;
    }
}