class Solution {
    int[][] scores;
    int employeeNum;
    boolean check(int[] score){
        for(int idx = 0; idx < employeeNum; idx++){
            if(score[0] < scores[idx][0] && score[1] < scores[idx][1]) return false;
        }
        return true;
    }
    public int solution(int[][] scores) {
        this.scores = scores;
        employeeNum = scores.length;
        int rank = 1;
        int hostScore = scores[0][0] + scores[0][1];
        if(!check(scores[0])) return -1;
        for(int idx = 1; idx < employeeNum; idx++){
            int score = scores[idx][0] + scores[idx][1];
            if(score > hostScore && check(scores[idx])) rank++;
            // if(score > hostScore) 
        }
        return rank;
    }
}