class Solution {
    public String[] solution(String[] quiz) {
        int quizs = quiz.length;
        
        String[] answer = new String[quizs];
        
        for(int idx = 0; idx < quizs; idx++){
            String[] args = quiz[idx].split(" ");
            int x = Integer.valueOf(args[0]);
            int y = Integer.valueOf(args[2]);
            int result = Integer.valueOf(args[4]);
            if(args[1].equals("+")) answer[idx] = (x + y) == result ? "O" : "X";
            else answer[idx] = (x - y) == result ? "O" : "X";
        }
        return answer;
    }
}