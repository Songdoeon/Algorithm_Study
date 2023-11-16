import java.util.*;
import static java.util.stream.Collectors.toList;
class Solution {
    public String[] solution(String[] strArr) {
        List<String> list = Arrays.stream(strArr).filter(s -> !s.contains("ad")).collect(toList());
        String[] answer = new String[list.size()];
        int index = 0;
        for(String str : list){
            answer[index] = list.get(index++);
        }
        return answer;
    }
}