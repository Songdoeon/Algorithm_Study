import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination){
        int[] answer = new int[sources.length];
        int index;
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n+1; i++) list.add(new ArrayList<>());
        
        for(int[] road : roads){
            list.get(road[0]).add(road[1]);
            list.get(road[1]).add(road[0]);
        }
        dis[destination] = 0;
        queue.add(destination);
        index = 1;
        while(!queue.isEmpty()){
            int point = queue.poll();

            List<Integer> roadList = list.get(point);
            for(int i = 0; i < roadList.size(); i++){
                int num = roadList.get(i);
                if(dis[num] > dis[point]){
                    dis[num] = dis[point] + 1;
                    queue.add(num);
                }
            }
            // for(int road : roadList){
            //     if(dis[road] >= index){
            //         dis[road] = index;
            //         queue.add(road);
            //     }
            // }
        }

        for(int i = 0; i < sources.length; i++){
            if(dis[sources[i]] == Integer.MAX_VALUE) answer[i] = -1;
            else answer[i] = dis[sources[i]];
        }
        
        return answer;
    }
}