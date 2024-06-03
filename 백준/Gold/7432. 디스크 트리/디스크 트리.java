import java.util.*;
import java.io.*;

class Folder{
    Map<String, Folder> map;

    public Folder(Map<String, Folder> map) {
        this.map = map;
    }
}
public class Main {
    static void search(int depth, Folder folder){
        for (String string : folder.map.keySet()) {
            for (int i = 0; i < depth; i++) {
                sb.append(' ');
            }
            sb.append(string).append('\n');
            if(!folder.map.containsKey(string)) continue;
            search(depth + 1, folder.map.get(string));
        }
    }
    static Folder root = new Folder(new TreeMap<>());
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Folder folder = root;
        for (int i = 0; i < N; i++) {
            String[] url = br.readLine().split("\\\\");
            folder = root;
            for (String s : url) {
                if(folder.map.containsKey(s)) {
                    folder = folder.map.get(s);
                }
                else{
                    Folder temp = new Folder(new TreeMap<>());
                    folder.map.put(s, temp);
                    folder = temp;
                }
            }
        }
        for (String s : root.map.keySet()) {
            sb.append(s).append("\n");
            search(1, root.map.get(s));
        }
        System.out.println(sb);
    }
}
