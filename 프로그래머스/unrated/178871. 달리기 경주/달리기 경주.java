import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        int count=0;
        HashMap<String,Integer> playerMap = new HashMap<>();
        HashMap<Integer,String> rankMap = new HashMap<>();
        for(int i=0;i<players.length;i++){
            playerMap.put(players[i],i+1);
            rankMap.put(i+1,players[i]);
        }
        for(String call : callings){
            int rank = playerMap.get(call);
            String player = rankMap.get(rank-1);
            playerMap.put(call,rank-1);
            playerMap.put(player,rank);
            rankMap.put(rank-1,call);
            rankMap.put(rank,player);
        }
        for(String s : rankMap.values()){
            answer[count++] = s;
        }
        return answer;
    }
}