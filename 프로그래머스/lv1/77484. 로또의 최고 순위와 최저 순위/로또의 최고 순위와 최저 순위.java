class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero = 0;
        for(int idx = 0;idx < 6;idx++){
            if(lottos[idx]==0){
                zero++;
            }
        }
        for(int num : win_nums){
            for(int idx=0;idx<6;idx++){
                if(num==lottos[idx]){
                    System.out.println(num);
                    answer[0]++;
                    break;
                }
            }
        }
        answer[1] =7-answer[0];
        answer[0] =7-(answer[0]+zero);
        if(answer[0]==7) answer[0]=6;
        if(answer[1]==7) answer[1]=6;
        return answer;
    }
}