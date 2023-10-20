import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {

        numlist = Arrays.stream(numlist).boxed()
            .sorted((o1, o2) -> Math.abs(n - o1) == Math.abs(n - o2) ? o2 - o1 : Math.abs(n - o1) - Math.abs(n - o2))
            .mapToInt(i -> i)
            .toArray();

        return numlist;
    }
}