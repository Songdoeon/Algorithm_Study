import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = l; i <= r; i++){
            String str = String.valueOf(i);
            str = str.replaceAll("[05]","");
            if(str.length() == 0) list.add(i);
        }
        return list.size() == 0 ? new int[] {-1} : list.stream().mapToInt(i ->i).toArray();
    }
}