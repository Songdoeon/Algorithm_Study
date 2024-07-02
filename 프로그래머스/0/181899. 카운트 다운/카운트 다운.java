import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int start_num, int end_num) {
       return IntStream.rangeClosed(end_num, start_num).boxed().sorted(Collections.reverseOrder()).mapToInt(i -> i).toArray();
    }
}