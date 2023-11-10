import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < arr.length; i++){
            if(list.isEmpty()) {
                list.add(arr[i]);
                continue;
            }
            if(arr[i] > list.get(list.size() - 1)) {
                list.add(arr[i]);
            }
            else {
                list.remove(list.size() - 1);
                i--;
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}