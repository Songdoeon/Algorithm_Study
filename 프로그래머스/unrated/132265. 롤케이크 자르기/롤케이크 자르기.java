import java.util.*;
class Solution {
    public int solution(int[] topping) {
        Set<Integer> set = new HashSet<>();

        int length = topping.length;
        int[] dp1 = new int[length];
        int[] dp2 = new int[length];
        
        int answer = 0;
        for(int idx = 0; idx < length; idx++){
            set.add(topping[idx]);
            dp1[idx] = set.size();
        }
        set.clear();
        for(int idx = length-1; idx > 0; idx--){
            set.add(topping[idx]);
            dp2[idx] = set.size();
        }
        for(int idx = 0; idx < length-1; idx++){
            if(dp1[idx] == dp2[idx+1]) answer++;
        }

        return answer;
    }
}