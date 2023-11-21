class Solution {
    int answer = 0;
    void search(int[] arr,int depth, int n){
        if (depth == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[depth] = i;

            if (isPromising(depth, arr)){
                search(arr, depth + 1, n);
            }
        }
    }
    
    static boolean isPromising(int next, int[] row) {
        for (int i = 0; i < next; i++) {
            if (row[i] == row[next] || Math.abs(row[i]-row[next]) == next - i) return false;
        }
        return true;
    }
    
    public int solution(int n) {
        int[] arr = new int[n];
        
        search(arr, 0, n);
        return answer;
    }
}