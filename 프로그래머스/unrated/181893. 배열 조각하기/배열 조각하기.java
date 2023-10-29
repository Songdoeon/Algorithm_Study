import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] query) {
        List<Integer> list = new ArrayList<>();
        
        for(int i : arr){
            list.add(i);
        }
        
        
        for(int i = 0; i < query.length; i++){
            if(i % 2 == 1){
                int num = query[i];
                for(int j = 0; j < num; j++){
                    list.remove(0);
                }
            }
            else{
                int num = query[i];
                while(list.size() != num + 1){
                    list.remove(num + 1);
                }
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}