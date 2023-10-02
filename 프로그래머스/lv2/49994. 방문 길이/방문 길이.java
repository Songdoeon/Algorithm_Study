import java.util.*;
class Solution {
    class Point{
        int x1, y1;
        int x2, y2;
        
        Point(int x1, int y1, int x2, int y2){
            this.x1 = Math.min(x1, x2);
            this.x2 = Math.max(x1, x2);
            this.y1 = Math.min(y1, y2);
            this.y2 = Math.max(y1, y2);
        }
        
        @Override
        public boolean equals(Object obj) {
            if(obj == this) return true;
            if(!(obj instanceof Point)) return false;
            Point p = (Point) obj;

            return x1 == p.x1 && y1 == p.y1 &&
                    x2 == p.x2 && y2 == p.y2;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2);
        }
    }
    boolean outOfMap(int x, int y){
        if(x < -5 || x > 5 || y < -5 || y > 5) return true;
        return false;
    }
    int[] direction(String point){
        switch(point){
            case "U" : return new int[] {0, 1};
            case "D" : return new int[] {0, -1};
            case "R" : return new int[] {1, 0};
            case "L" : return new int[] {-1, 0};
        }
        return new int[] {0, 0};
    }
    public int solution(String dirs) {
        Set<Point> set = new HashSet<>();
        
        int[] location = new int[] {0, 0};
        boolean zero = true;
        int answer = 0;
        String[] directions = dirs.split("");
        for(String dir : directions){
            int[] point = direction(dir);
            if(outOfMap(location[0] + point[0], location[1] + point[1])) continue;
            set.add(new Point(location[0], location[1], location[0] + point[0], location[1] + point[1]));
            location[0] += point[0];
            location[1] += point[1];
        }
        
        
        return set.size();
    }
}