class Solution {
    int[] answer = new int[2];
    int[][] arr;
    boolean check(int x, int y, int size){
        int host = arr[x][y];
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(host != arr[i][j]) return false;
            }
        }
        return true;
    }
    void dfs(int x, int y, int size){
        if(check(x, y, size)) {
            answer[arr[x][y]]++;
            return ;
        }
        size = size / 2;
        
        dfs(x, y, size);
        dfs(x + size, y, size);
        dfs(x, y + size, size);
        dfs(x + size, y + size, size);
    }
    public int[] solution(int[][] arr) {
        this.arr = arr;
        dfs(0,0,arr.length);
        return answer;
    }
}