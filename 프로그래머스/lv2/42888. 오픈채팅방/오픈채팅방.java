import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String,String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        for(String str : record){
            String[] args = str.split(" ");
            if(args[0].equals("Enter")) {
                map.put(args[1], args[2]);
            }
            if(args[0].equals("Change")) {
                map.put(args[1], args[2]);
            }
        }
        for(String str : record){
            String[] args = str.split(" ");
            if(args[0].equals("Enter")) {
                list.add(map.get(args[1]) + "님이 들어왔습니다.");
            }
            if(args[0].equals("Leave")) {
                list.add(map.get(args[1]) + "님이 나갔습니다.");
            }
        }
        return list.toArray(new String[list.size()]);
    }
}