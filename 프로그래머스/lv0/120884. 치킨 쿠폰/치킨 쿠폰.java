class Solution {
    int sum = 0;
    int coupon = 0;
    void search(int chicken){
        int n = chicken / 10;
        sum += n;
        coupon -= n * 10;
        coupon += n;
    }
    public int solution(int chicken) {
        coupon = chicken;
        while(coupon >= 10){
            search(coupon);
        }
        return sum;
    }
}