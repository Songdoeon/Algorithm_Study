import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        int length = numbers.length;
        for(int i = 0; i < length; i++){
            for(int j = i+1; j < length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        int[] arr = set.stream().sorted().mapToInt(i -> i).toArray();
        Arrays.sort(arr);
        return arr;
    }
}