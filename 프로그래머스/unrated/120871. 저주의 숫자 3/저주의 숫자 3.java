class Solution {
    boolean check(int x){
        String num = String.valueOf(x);
        if(num.contains("3")) return false;
        return true;
    }
    public int solution(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for(int i = 1; i <= n; i++){
            int num = arr[i - 1] + 1;
            while(num % 3 == 0 || !check(num)){
                num++;
            }
            arr[i] = num;
        }
        
        return arr[n];
    }
}