import java.util.*;
import java.io.*;

class Node{
    int no, floor;

    public Node(int no, int floor) {
        this.no = no;
        this.floor = floor;
    }
}
class Main{
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();
        list.add(new Node(0, 0));
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int floor1 = Integer.parseInt(st.nextToken());
            int floor2 = Integer.parseInt(st.nextToken());
            list.add(new Node(i, floor1));
            list.add(new Node(i, floor2));
        }
        Collections.sort(list, Comparator.comparingInt(o -> o.floor));
        System.out.println(N % (2 * M) == 0 ? list.get(2 * M).no : list.get(N % (2 * M)).no);
    }
}