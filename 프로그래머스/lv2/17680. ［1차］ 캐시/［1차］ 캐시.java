import java.util.*;
class Solution {
    
    public int solution(int cacheSize, String[] cities) {
        Queue<String> queue = new LinkedList<>();    
        int answer = 0;
        
        if(cacheSize == 0) return cities.length * 5; 
        for(String citys : cities){
            String city = citys.toLowerCase();
            if(queue.contains(city)){
                queue.remove(city);
                queue.add(city);
                answer++;
            }
            else{
                if(queue.size() < cacheSize){
                    queue.add(city);
                }
                else{
                    queue.poll();
                    queue.add(city);
                }
                answer += 5; 
            }
        }
        
        
        return answer;
    }
}