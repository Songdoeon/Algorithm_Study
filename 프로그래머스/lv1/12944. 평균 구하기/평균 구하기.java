class Solution {
    public double solution(int[] arr) {
        double sum = 0;
        for(int i : arr){
            sum += i;
        }
        sum = sum / (double) arr.length;
        return sum;
    }
}