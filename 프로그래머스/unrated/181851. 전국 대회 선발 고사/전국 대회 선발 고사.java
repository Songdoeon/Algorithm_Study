import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int len = rank.length;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int idx = 0 ;idx < len; idx++){
            if(attendance[idx]) map.put(rank[idx], idx);
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        
        keySet.sort((o1, o2) -> o1 - o2);
        
        return 10000 * map.get(keySet.get(0)) + 100 * map.get(keySet.get(1)) + map.get(keySet.get(2));
    }
}