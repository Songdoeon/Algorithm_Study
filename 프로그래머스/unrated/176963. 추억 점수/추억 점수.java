import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int score = 0;
        int count = 0;
        int[] answer = new int[photo.length];
        HashMap<String,Integer> map = new HashMap<>();
        
        
        for(int i=0;i<name.length;i++){
            map.put(name[i],yearning[i]);
        }
        for(String[] picture : photo){
            for(String person : picture){
                score += map.getOrDefault(person,0);
            }
            answer[count++] = score;
            score = 0;
        }
        
        return answer;
    }
}