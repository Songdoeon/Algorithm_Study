class Solution {
    public int solution(int[] numbers, int k) {
        int num = (2 * k -1) % numbers.length;
        
        return num != 0 ? numbers[num - 1] : numbers[numbers.length - 1];
    }
}