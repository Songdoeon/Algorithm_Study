import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 전체 종류 수
        int kinds = new HashSet<>(Arrays.asList(gems)).size();

        Map<String, Integer> cnt = new HashMap<>();
        int n = gems.length;

        int bestLen = Integer.MAX_VALUE;
        int bestL = 0, bestR = 0;

        int l = 0;
        for (int r = 0; r < n; r++) {
            cnt.put(gems[r], cnt.getOrDefault(gems[r], 0) + 1);

            // 모든 종류를 포함했다면, 왼쪽을 최대한 줄이기
            while (cnt.size() == kinds) {
                // 최소 구간 갱신
                int curLen = r - l + 1;
                if (curLen < bestLen) {
                    bestLen = curLen;
                    bestL = l; bestR = r;
                }
                // 왼쪽 한 칸 줄여보기
                String leftGem = gems[l];
                int c = cnt.get(leftGem) - 1;
                if (c == 0) cnt.remove(leftGem);
                else cnt.put(leftGem, c);
                l++;
            }
        }
        return new int[] {bestL + 1, bestR + 1};
    }
}
