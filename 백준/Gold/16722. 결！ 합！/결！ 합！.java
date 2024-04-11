
import java.util.*;
import java.io.*;

class Ans{
    int[] arr = new int[3];
    public Ans(int n1, int n2, int n3) {
        arr[0] = n1;
        arr[1] = n2;
        arr[2] = n3;
        Arrays.sort(arr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ans ans = (Ans) o;
        if(this.arr[0] != ans.arr[0]) return false;
        if(this.arr[1] != ans.arr[1]) return false;
        if(this.arr[2] != ans.arr[2]) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(arr[0], arr[1], arr[2]);
    }

    @Override
    public String toString() {
        return "Ans{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
class Obj{
    String shape, color, background;

    public Obj(String shape, String color, String background) {
        this.shape = shape;
        this.color = color;
        this.background = background;
    }
}
class Main {
    static int N;
    static Obj[] arr;
    static int[] tgt = new int[3];
    static int[][] checkArr = new int[3][3];
    static Set<Ans> set = new HashSet<>();
    static boolean[] visited;
    static void colorCheck(int idx, boolean action){
        Obj o = arr[idx];
        if(action){
            if(o.color.equals("YELLOW")) checkArr[1][0]++;
            else if(o.color.equals("RED")) checkArr[1][1]++;
            else if(o.color.equals("BLUE")) checkArr[1][2]++;
        }
        else{
            if(o.color.equals("YELLOW")) checkArr[1][0]--;
            else if(o.color.equals("RED")) checkArr[1][1]--;
            else if(o.color.equals("BLUE")) checkArr[1][2]--;
        }
    }
    static void backCheck(int idx, boolean action){
        Obj o = arr[idx];
        if(action){
            if(o.background.equals("GRAY")) checkArr[2][0]++;
            else if(o.background.equals("WHITE")) checkArr[2][1]++;
            else checkArr[2][2]++;
        }
        else{
            if(o.background.equals("GRAY")) checkArr[2][0]--;
            else if(o.background.equals("WHITE")) checkArr[2][1]--;
            else checkArr[2][2]--;
        }
    }
    static void shapeCheck(int idx, boolean action){
        Obj o = arr[idx];
        if(action){
            if(o.shape.equals("CIRCLE")) checkArr[0][0]++;
            else if(o.shape.equals("TRIANGLE")) checkArr[0][1]++;
            else checkArr[0][2]++;
        }
        else{
            if(o.shape.equals("CIRCLE")) checkArr[0][0]--;
            else if(o.shape.equals("TRIANGLE")) checkArr[0][1]--;
            else checkArr[0][2]--;
        }
    }
    static void redo(int idx){
        shapeCheck(idx, false);
        colorCheck(idx, false);
        backCheck(idx, false);
    }
    static void action(int idx){
        shapeCheck(idx, true);
        colorCheck(idx, true);
        backCheck(idx, true);
    }
    static boolean check(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (checkArr[i][j] == 2){
                    return false;
                }
            }
        }
        return true;
    }
    static void search(int depth, int idx){
        if(depth == 3){
            if(!check()) return ;
            set.add(new Ans(tgt[0], tgt[1], tgt[2]));
            return ;
        }

        for (int i = idx; i <= 9; i++) {
            if(visited[i])continue;
            visited[i] = true;
            action(i);
            tgt[depth] = i;
            search(depth + 1, i + 1);
            visited[i] = false;
            redo(i);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        visited = new boolean[10];
        arr = new Obj[10];
        for (int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Obj(st.nextToken(), st.nextToken(), st.nextToken());
        }
        N = Integer.parseInt(br.readLine());

        search(0, 1);
        int result = 0;
        boolean find = false;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String exec = st.nextToken();
            if(exec.equals("H")){
                Ans ans = new Ans(Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()));
//                System.out.println(ans);
//                System.out.print(result + " -> ");
                if(set.contains(ans)){
                    set.remove(ans);
                    result++;
                }
                else result--;

//                System.out.println(result);
            }
            else{
                if(set.isEmpty() && !find){
                    result += 3;
                    find = true;
                }
                else if(!set.isEmpty()) result--;
                else result--;
            }
        }

        System.out.println(result);
    }
}