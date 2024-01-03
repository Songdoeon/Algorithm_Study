import java.util.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> list = new ArrayList<>();
        int len = num_list.length;
        for(int i = n; i < len + n; i++){
            if(i < len) list.add(num_list[i]);
            else list.add(num_list[i - len]);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}