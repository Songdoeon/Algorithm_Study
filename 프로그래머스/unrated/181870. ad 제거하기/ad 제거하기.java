import java.util.*;
import static java.util.stream.Collectors.toList;
class Solution {
    public String[] solution(String[] strArr) {
        List<String> list = Arrays.stream(strArr).filter(s -> !s.contains("ad")).collect(toList());
        String[] answer = new String[list.size()];
        list.toArray(answer);
        return answer;
    }
}