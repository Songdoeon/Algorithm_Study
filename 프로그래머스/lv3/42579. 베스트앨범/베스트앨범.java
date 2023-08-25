import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int length = genres.length;
        int index;
        Map<String,Integer> genre = new HashMap<>();
        Map<String,Map<Integer,Integer>> list = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int idx = 0; idx < length; idx++){
            genre.put(genres[idx],genre.getOrDefault(genres[idx], 0) + plays[idx]);
            Map<Integer, Integer> tempMap = new HashMap<>();
            tempMap = list.getOrDefault(genres[idx], new HashMap<Integer, Integer>(Map.of(idx, plays[idx])));
            tempMap.put(idx,plays[idx]);
            list.put(genres[idx],tempMap);
        }
        
        List<String> keySet = new ArrayList(genre.keySet());
        Collections.sort(keySet, (s1, s2) -> genre.get(s2) - (genre.get(s1)));
        
        for(String key : keySet){
            Map<Integer, Integer> map = list.get(key);
            List<Integer> set = new ArrayList(map.keySet());
            Collections.sort(set, (s1, s2) -> map.get(s2) - (map.get(s1)));
            index = 0;
            for(int i : set){
                if(index > 1)break;
                answer.add(i);
                index++;
            }
        }
        // if(answer.isEmpty()) return 0
        return answer.stream().mapToInt(i -> i).toArray();
    }
}