import java.util.*;
class Solution {
    Map<String, Integer> wish = new HashMap<>();
    Map<String, Integer> sale = new HashMap<>();
    boolean check(){
        for(String str : wish.keySet()){
            if(!sale.containsKey(str) || wish.get(str) > sale.get(str)) return false;
        }
        return true;
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int len = discount.length;
        for(int idx = 0; idx < want.length; idx++){
            wish.put(want[idx], number[idx]);
        }
        for(int i = 0; i <= discount.length - 10; i++){
            for(int j = i; j < 10 + i; j++){
                sale.put(discount[j], sale.getOrDefault(discount[j], 0) + 1);
            }
            if(check()) answer++;
            sale.clear();
        }
        return answer;
    }
}