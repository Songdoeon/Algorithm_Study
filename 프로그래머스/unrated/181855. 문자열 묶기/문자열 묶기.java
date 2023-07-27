import java.util.*;
class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int length = strArr.length;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0;i < length;i++){
            int size = strArr[i].length();
            map.put(size,map.getOrDefault(size,0)+1);
        }
        int[] arr = map.values().stream().sorted().mapToInt(i -> i).toArray();
        return arr[arr.length-1];
    }
}