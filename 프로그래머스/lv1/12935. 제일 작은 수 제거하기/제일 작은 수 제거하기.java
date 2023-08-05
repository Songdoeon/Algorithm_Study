import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[] {-1};
        // Integer[] answer = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        List<Integer> list = new ArrayList<>();
        int num = Arrays.stream(arr).min().getAsInt();
        for(int i : arr){
            if(i == num) continue;
            list.add(i);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}