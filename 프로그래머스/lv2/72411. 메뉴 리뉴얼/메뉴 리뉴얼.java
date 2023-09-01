import java.util.*;
import java.util.stream.*;
class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    void select(int index, String menus, String[] menuArr , int[] visited){
        for(int idx = index; idx < menuArr.length; idx++){
            if(visited[idx] != 1){
                String menu = menus + menuArr[idx];
                if(menu.length() != 1){
                    map.put(menu, map.getOrDefault(menu, 0) + 1);
                }
                visited[idx] = 1;
                select(idx+1, menu, menuArr, visited);
                visited[idx] = 0;
            }
        }
    }
    public String[] solution(String[] orders, int[] course) {
        for(String order : orders){
            int[] visited = new int[order.length()];
            String[] arr = order.split("");
            Arrays.sort(arr);
            select(0, "", arr, visited);
        }
        List<String> keySet = new ArrayList(map.keySet());
        List<String> answer = new ArrayList<>();
        List<Integer> menuSet = Arrays.stream(course).boxed().collect(Collectors.toList());
        Map<Integer, Integer> answerMap = new HashMap<>();
        for(String key : keySet){
            if(answerMap.getOrDefault(key.length(),0) < map.get(key)){
                answerMap.put(key.length(), map.get(key));
            }
        }
        for(String key : keySet){
            // System.out.println(key + " : " + map.get(key));
            if(map.get(key) > 1 && menuSet.contains(key.length()) && answerMap.get(key.length()) == map.get(key))answer.add(key);
        }
        answer.sort((o1, o2) -> o1.compareTo(o2));
        return answer.toArray(new String[answer.size()]);
    }
}