class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];
        int length = num_list.length;
        int idx = 0;
        for(int Index = 0;Index < length;Index++){
            // if(Index == 0) answer[0][Index%3] = num_list[Index];
            answer[Index/n][Index%n] = num_list[Index];
        }
        return answer;
    }
}