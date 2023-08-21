class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int low = Math.min(n,m);
        int low2 = Math.max(n,m);
        int high = n * m;
        
        for(int i = 1; i <= low; i++){
            if(n % i == 0 && m % i == 0) answer[0] = i;
        }
        
        for(int i = low2; i <= high; i++){
            if(i % n == 0 && i % m == 0) {
                answer[1] = i;
                break;
            }
        }
        
        return answer;
    }
}