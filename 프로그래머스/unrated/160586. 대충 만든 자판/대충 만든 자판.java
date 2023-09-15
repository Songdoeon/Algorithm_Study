import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        int len = targets.length;
        int[] answer = new int[len];
        for(String key : keymap){
            int length = key.length();
            
            for(int i = 0; i < length; i++){
                Character c = key.charAt(i);
                if(!map.containsKey(c)) map.put(c, i + 1);
                else{
                    map.put(c, Math.min(map.get(c), i + 1));
                }
            }
        }
        
        
        for(int i = 0; i < len; i++){
            int strLen = targets[i].length();
            int sum = 0;
            for(int j = 0; j < strLen; j++){
                Character c = targets[i].charAt(j);
                if(!map.containsKey(c)) {
                    sum = 0;
                    break;
                }
                sum += map.get(c);
            }
            answer[i] = sum == 0 ? -1 : sum;
        }
        
        return answer;
    }
}