import java.util.*;
class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        int len = todo_list.length;
        List<String> list = new ArrayList<>();
        for(int i = 0; i < len; i++){
            if(!finished[i])list.add(todo_list[i]);
        }
        return list.stream().toArray(String[]::new);
    }
}