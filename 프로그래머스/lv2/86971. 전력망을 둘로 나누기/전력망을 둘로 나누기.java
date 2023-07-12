import java.util.*;
class Solution {
    int[][] arr;
    int bfs(int left, int n) {
        int cnt = 1;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(left);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            visited[temp] = true;
            for (int i = 1; i < n + 1; i++) {
                if (arr[temp][i] == 1 && !visited[i]) {
                    System.out.println(temp+" : "+i+" "+cnt);
                    queue.add(i);
                    cnt++;
                }
            }
        }
        return Math.abs(n-(2*cnt));
    }
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        // 인접 행렬 만들기
        arr = new int[n + 1][n + 1];
        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }

        // 선 하나씩 끊으면서 bfs 탐색
        for (int i = 0; i < wires.length; i++) {
            int left = wires[i][0];
            int right = wires[i][1];

            // 선 끊기
            arr[left][right] = 0;
            arr[right][left] = 0;

            // bfs
            answer = Math.min(answer, bfs(left, n));

            // 끊었던 선 복구
            arr[left][right] = 1;
            arr[right][left] = 1;
        }

        return answer;
    
    }
}