import java.util.*;
class Solution {
    public int[] parent;
    public int get_parent(int a) {
        if(a == parent[a])
            return parent[a];
        else
            return parent[a] = get_parent(parent[a]);
    }
    public void union(int a, int b) {
        a = get_parent(a);
        b = get_parent(b);
        if(a > b)
            parent[a] = b;
        else
            parent[b] = a;
    }
    public int solution(int n, int[][] costs) {
        int answer = 0, i, j;
        int line = costs.length;
        parent = new int[n];
        
        for(i = 0; i < n; i++) parent[i] = i;
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        for(i = 0; i < line; i++) {
            if(get_parent(costs[i][0]) == get_parent(costs[i][1]))
                continue;
            union(costs[i][0], costs[i][1]);
            answer += costs[i][2];
        }
        return answer;
    }
}