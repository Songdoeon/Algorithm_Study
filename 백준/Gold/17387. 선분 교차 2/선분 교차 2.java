import java.io.*;
import java.util.*;

class Pos{
    long x;
    long y;

    public Pos(long x, long y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static long ccw(Pos a, Pos b, Pos c){
        long flag = a.x * b.y + b.x * c.y + c.x * a.y - a.y * b.x - b.y * c.x - c.y * a.x;
        if(flag > 0) return 1;
        if(flag < 0) return -1;
        return 0;
    }
    static boolean isIn(Pos a, Pos b, Pos c){
        return (Math.abs(c.x - a.x) + Math.abs(c.x - b.x) == Math.abs(a.x - b.x)) && (Math.abs(c.y - a.y) + Math.abs(c.y - b.y) == Math.abs(a.y - b.y));
    }
    static boolean check(Pos p1, Pos p2, Pos p3, Pos p4){
        long ccw1 = ccw(p1, p2, p3);
        long ccw2 = ccw(p1, p2, p4);
        long ccw3 = ccw(p3, p4, p1);
        long ccw4 = ccw(p3, p4, p2);
        if(ccw1 * ccw2< 0 && ccw3 * ccw4 < 0) return true;
        if(ccw1 == 0 && isIn(p1, p2, p3)) return true;
        if(ccw2 == 0 && isIn(p1, p2, p4)) return true;
        if(ccw3 == 0 && isIn(p3, p4, p1)) return true;
        if(ccw4 == 0 && isIn(p3, p4, p2)) return true;
        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Pos p1 = new Pos(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Pos p2 = new Pos(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        Pos p3 = new Pos(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Pos p4 = new Pos(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        System.out.println(check(p1, p2, p3, p4) ? 1 : 0);
    }
}
