import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int len = numbers.length - 1;
        Arrays.sort(numbers);
        return numbers[len] * numbers[len - 1];
    }
}