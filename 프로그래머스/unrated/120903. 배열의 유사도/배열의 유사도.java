import java.util.*;
class Solution {
    public int solution(String[] s1, String[] s2) {
        Set<String> set1 = new HashSet<>(List.of(s1));
        Set<String> set2 = new HashSet<>(List.of(s2));
        set1.retainAll(set2);
        return set1.size();
    }
}