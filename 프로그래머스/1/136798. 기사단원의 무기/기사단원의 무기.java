class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int num = 1; num <= number; num++){
            int attack = 0;
            for(int i = 1; i <= (int) Math.sqrt(num); i++){
                if(num % i == 0){
                    if(i == Math.sqrt(num)) attack++;
                    else attack += 2;
                }
            }
            if(attack > limit) answer += power;
            else answer += attack;
            
        }
        return answer;
    }
}