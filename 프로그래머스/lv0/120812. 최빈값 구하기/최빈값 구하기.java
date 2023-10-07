import java.util.*;
class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < array.length; i++){
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>(map.values());
        
        int answer = result.stream().mapToInt(i -> i).max().getAsInt();
        
        int count = (int) result.stream().filter(i -> i == answer).count();
        if(count != 1) return -1;
        for(int i : map.keySet()){
            if(map.get(i) == answer) return i;
        }
        return answer;
    }
}