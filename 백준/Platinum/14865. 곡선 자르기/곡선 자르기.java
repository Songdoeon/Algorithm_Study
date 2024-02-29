import java.util.*;
import java.io.*;

class Pos{
    boolean isUp;
    long x, no;
    boolean hasChild = false;
    boolean hasParent = true;
    public Pos(long x, int no, boolean up) {
        this.x = x;
        this.no = no;
        this.isUp = up;
    }
}
public class Main {

    static int N;
    static List<Pos> list = new ArrayList<>();
    static Deque<Pos> stack = new ArrayDeque<>();
    static final int MAX = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());


        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        long startY = y;
        boolean isUp = false, isDown = false;
        int first = MAX;
        int idx = 1;
        for(int i = 1; i < N; i++) {
            isUp = false;
            isDown = false;
            st = new StringTokenizer(br.readLine());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());

            if(ny > 0 && y < 0)isUp = true;
            else if(ny < 0 && y > 0) isDown = true;
            if(isUp){
                list.add(new Pos(nx, idx, isUp));
            }
            else if(isDown){
                list.add(new Pos(nx, idx++, isUp));
            }
            x = nx;
            y = ny;
        }
        if(!list.get(0).isUp) list.get(0).no = idx;

        isUp = false;
        isDown = false;

        if(startY > 0 && y < 0)isUp = true;
        else if(startY < 0 && y > 0) isDown = true;

        if(isUp){
            list.add(new Pos(x, idx, isUp));
        }

        else if(isDown){
            list.add(new Pos(x, idx, isUp));
        }
        int size = list.size();
        list.sort(Comparator.comparingLong(o -> o.x));
        long ans1 = 0;
        long ans2 = 0;
        for (int i = 0; i < size; i++) {
            Pos p = list.get(i);
            if(stack.isEmpty()) {
                p.hasParent = false;
                stack.push(p);
            }
            else if(stack.peek().no == p.no) {
                if(!stack.peek().hasParent) ans1++;
                if(!stack.peek().hasChild) ans2++;
                stack.pop();
            }
            else {
                stack.peek().hasChild = true;
                stack.push(p);
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
}
