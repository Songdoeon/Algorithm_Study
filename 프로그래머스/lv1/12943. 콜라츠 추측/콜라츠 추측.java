class Solution {
    public int solution(int num) {
        int answer = 0;
        long nums = Long.valueOf(num);
        if(check(nums)) return 0;
        
        while(true){
            if(answer > 500) return -1;
            if(nums%2==0){
                nums /= 2;
                answer +=1;
            }
            if(check(nums)) return answer;
            if(nums%2==1){
                nums *= 3;
                nums +=1;
                answer +=1;
            }
        }
    }
    boolean check(long num){
        if(num==1) return true;
        return false;
    }
}