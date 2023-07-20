class Solution {
    public int solution(int n) {
        int sum = 0;
        int count = 1;
        if(n==0) return 0;
        for(int Index = 1;Index < n/2 +1;Index++){
            for(int Index2 = Index;Index2 < n; Index2++){
                sum += Index2;
                if(sum == n) {
                    count++;
                    sum = 0;
                    break;
                }
                else if(sum>n){
                    sum = 0;
                    break;
                }
            }
        }
        return count;
    }
}