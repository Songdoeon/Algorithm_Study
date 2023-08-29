import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int answer = 0;
        int car = routes.length;
        int lastCamera = -30001;
        for(int idx = 0; idx < car; idx++){
            if(lastCamera < routes[idx][0]) {
                answer++;
                lastCamera = routes[idx][1];
            }
        }
        return answer;
    }
}