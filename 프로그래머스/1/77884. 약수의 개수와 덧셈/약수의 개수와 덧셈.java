class Solution {
    int search(int num){
        int count = 0;
        double len = Math.sqrt(num);
        for(int i = 1; i < len; i++){
            if(num % i == 0) count += 2;
        }
        if(num % len == 0) count++;
        return count;
    }
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            int num = search(i);
            System.out.println(num);
            if(num % 2 == 0) answer += i;
            else answer -= i;
        }
        return answer;
    }
}