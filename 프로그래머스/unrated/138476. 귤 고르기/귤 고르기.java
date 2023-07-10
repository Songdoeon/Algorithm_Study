import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : tangerine){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        entries.sort((o1, o2) -> o2.getValue() - o1.getValue());

        for(Map.Entry<Integer, Integer> entry : entries){
            sum += entry.getValue();
            answer++;
            if(sum>=k){
                break;
            }
            
        }
        return answer;
    }
}