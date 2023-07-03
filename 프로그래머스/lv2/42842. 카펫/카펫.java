class Solution {
    public int[] solution(int brown, int yellow) {
        int j=0;
        int sum = yellow+brown;
        for(int i=1;i<=yellow;i++){
            j = yellow/i;
            if((i*2)+(j*2)==brown-4 && i*j==yellow){
                return new int[] {j+2,i+2};
            }
        }
        return null;
    }
}