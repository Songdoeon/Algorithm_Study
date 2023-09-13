class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        int denom = denom1 * denom2;
        int numer = (numer1 * denom2) + (numer2 * denom1);
        
        int max = 1;
        int len = Math.min(numer, denom);
        System.out.println(numer + " / " +denom);
        
        for(int i = 1; i <= len; i++){
            if(numer % i == 0 && denom % i == 0) max = i;
        }
        return new int[] {(numer / max), (denom / max)};
    }
}