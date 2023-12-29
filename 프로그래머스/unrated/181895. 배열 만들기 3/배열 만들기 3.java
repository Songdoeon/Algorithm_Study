import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        
        for(int[] interval : intervals){
            for(int idx = interval[0]; idx <= interval[1]; idx++){
                list.add(arr[idx]);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}