import java.util.*;
class Solution {
    String[] user_id;
    String[] banned_id;
    int answer = 0;
    Set<Set<String>> set = new HashSet<>();
    
    boolean check(String id, String ban){
        int len = ban.length();
        if(len != id.length()) return false;
        for(int i = 0; i < len; i++){
            if(id.charAt(i) != ban.charAt(i) && ban.charAt(i) != '*') return false;
        }
        return true;
    }
    void search(int depth, int count, boolean[] visited){
        if(count == banned_id.length){
            Set<String> tempSet = new HashSet<>();
            for(int i = 0; i < user_id.length; i++){
                if(visited[i]) {
                    tempSet.add(user_id[i]);
                }
            }
            set.add(tempSet);
            return ;
        }
        
        for(int i = depth; i < banned_id.length; i++){
            for(int j = 0; j < user_id.length; j++){
                if(!check(user_id[j], banned_id[i])) continue;
                if(!visited[j]){
                    visited[j] = true;
                    search(i + 1,count + 1, visited);
                    visited[j] = false;
                }
            }
        }
    }
        
    public int solution(String[] user_id, String[] banned_id) {
        boolean[] visited = new boolean[user_id.length];
        this.user_id = user_id;
        this.banned_id = banned_id;
        
        search(0,0,visited);
        
        return set.size();
    }
}