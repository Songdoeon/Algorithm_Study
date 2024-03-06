import java.util.*;
import java.io.*;

class Room {
    int no;
    Queue<Player> list;

    public Room(int no) {
        this.no = no;
        list = new PriorityQueue<>(Comparator.comparing(o -> o.name));
    }
}
class Player{
    int level;
    String name;

    public Player(int level, String name) {
        this.level = level;
        this.name = name;
    }

    @Override
    public String toString() {
        return level + " " + name;
    }
}
public class Main {
    static int N, M;
    static final String start = "Started!";
    static final String wait = "Waiting!";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<Room> rooms = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
//        sb.append(start).append('\n');
        boolean found = false;
        while (N-- > 0){
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            if(rooms.isEmpty()){
                Room room = new Room(level);
                room.list.add(new Player(level, name));
                rooms.add(room);
            }
            else{
                for (Room room : rooms) {
                    found = false;
                    if(room.no >= level - 10 && room.no <= level + 10 && room.list.size() < M){
                        room.list.add(new Player(level, name));

                        found = true;
                        break;
                    }
                }
                if(!found){
                    Room room = new Room(level);
                    room.list.add(new Player(level, name));
                    rooms.add(room);
                }
            }
        }

        for (Room room : rooms) {
            if(room.list.size() == M){
                sb.append(start).append('\n');
                while (!room.list.isEmpty()){
                    sb.append(room.list.poll()).append('\n');
                }
            }
            else{
                sb.append(wait).append('\n');
                while (!room.list.isEmpty()){
                    sb.append(room.list.poll()).append('\n');
                }
            }
        }

        System.out.println(sb);
    }
}
