// 4 : 10
class Solution {
    int[] diffs, times;
    long limit;
    boolean check(int mid){
        int len = diffs.length;
        long time = 0;
        if(diffs[0] <= mid){
            time += times[0];
        }
        else {
            time += (diffs[0] - mid) * times[0];
        }
        for(int i = 1; i < len; i++){
            if(diffs[i] <= mid) time += times[i];
            else time += (times[i - 1] + times[i]) * (diffs[i] - mid) + times[i];

            if(time > limit) return false;
        }

        if(time > limit) return false;
        return true;
    }
    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        int ans = 300_001;
        int s = 1;
        int e = 300_001;
        while(s < e){
            int mid = (s + e) / 2;
            if(check(mid)){
                e = mid;
                ans = Math.min(ans, e);
            }
            else s = mid + 1;
        }
        return ans;
    }
}