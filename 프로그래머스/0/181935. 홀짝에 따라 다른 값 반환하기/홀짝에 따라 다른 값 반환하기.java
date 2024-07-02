class Solution {
    int calcEven(int n){
        int ret = 0;
        for(int i = 2; i <= n; i += 2){
            ret += i * i;
        }
        return ret;
    }
    int calcOdd(int n){
        int ret = 0;
        for(int i = 1; i <= n; i += 2){
            ret += i;
        }
        return ret;
    }
    public int solution(int n) {
        if(n % 2 == 0) return calcEven(n);
        return calcOdd(n);
    }
}