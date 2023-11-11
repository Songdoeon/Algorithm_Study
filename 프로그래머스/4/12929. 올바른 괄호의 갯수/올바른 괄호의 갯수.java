class Solution {
    int check(int[] arr, int num){
        int sum = 0;
        for(int i = 0; i <= num; i++){
            sum += arr[i] * arr[num - i];
        }
        return sum;
    }
    public int solution(int n) {
        int[] arr = new int[n + 1]; 
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i <= n; i++){
            arr[i] = check(arr, i - 1);
        }
        return arr[n];
    }
}