class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        
        for(int Index = 3; Index <= n ; Index++){
            arr[Index] = (arr[Index-1] + arr[Index-2])%1000000007;
        }
        return arr[n];
    }
}