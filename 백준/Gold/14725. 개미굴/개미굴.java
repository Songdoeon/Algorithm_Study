import java.io.*;
import java.util.*;

class Room{
    String name;
    TreeMap<String, Room> map;

    public Room(String name) {
        this.name = name;
        this.map = new TreeMap<>();
    }
}
public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Room root = new Room("root");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            Room parent = root;
            for (int j = 0; j < idx; j++) {
                String name = st.nextToken();
                if(!parent.map.containsKey(name)){
                    TreeMap<String, Room> map = parent.map;
                    map.put(name, new Room(name));
                    parent.map = map;
                }
                parent = parent.map.get(name);
            }
        }
        search(root.map, 0);
        System.out.println(sb);
    }

    static void search(Map<String, Room> map, int depth) {
        for (String s : map.keySet()) {
            for (int i = 0; i < depth; i++) {
                sb.append("--");
            }
            sb.append(s).append("\n");
            search(map.get(s).map, depth + 1);
        }
    }
}


