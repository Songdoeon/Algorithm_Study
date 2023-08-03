class Solution {
    public int[] solution(String[] wallpaper) {
        int length = wallpaper.length;
        int wallLength = wallpaper[0].length();
        int lux,luy,rdx,rdy;
        lux = luy = Math.max(wallLength+1,length+1);
        rdx = rdy = 0;
        
        for(int idx = 0; idx < length; idx++){
            String wall = wallpaper[idx];
            for(int j = 0; j < wallLength; j++){
                char c = wall.charAt(j);
                if(c =='#'){
                    lux = Math.min(lux,idx);
                    luy = Math.min(luy,j);
                    rdx = Math.max(rdx,idx);
                    rdy = Math.max(rdy,j);
                }
            }
        }
        return new int[] {lux,luy,rdx+1,rdy+1};
    }
}