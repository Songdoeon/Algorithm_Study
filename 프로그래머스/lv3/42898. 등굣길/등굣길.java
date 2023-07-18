class Solution {
    static int mod = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[m+1][n+1];
        int waterCount = puddles.length;
        for(int i=0; i<waterCount;i++){
            int x = puddles[i][0];
            int y = puddles[i][1];
            map[x][y] = -1;
            // System.out.println("x : "+x+" y : "+y + " = "+map[x][y]);
        }
        map[1][1]=1;
        for(int x = 1;x <= m;x++){
            for(int y = 1;y <= n;y++){
                if(x==1 && y==1 || map[x][y]==-1)continue;
                if(map[x][y-1]==-1) map[x][y] = map[x-1][y] %mod ;
                else if(map[x-1][y]==-1) map[x][y] = map[x][y-1] % mod;
                else map[x][y] = (map[x-1][y]+map[x][y-1]) %mod;
            }
        }
        return map[m][n]%mod;
    }
}