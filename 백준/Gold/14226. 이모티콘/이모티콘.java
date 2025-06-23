import java.io.*;
import java.util.*;

class State {
    int screen;
    int clipboard;
    int time;

    public State(int screen, int clipboard, int time) {
        this.screen = screen;
        this.clipboard = clipboard;
        this.time = time;
    }
}

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        boolean[][] visited = new boolean[2001][2001]; // [화면][클립보드]
        Queue<State> queue = new LinkedList<>();

        queue.add(new State(1, 0, 0));
        visited[1][0] = true;

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.screen == N) {
                System.out.println(current.time);
                return;
            }
            
            if (!visited[current.screen][current.screen]) {
                visited[current.screen][current.screen] = true;
                queue.add(new State(current.screen, current.screen, current.time + 1));
            }
            
            if (current.clipboard > 0 && current.screen + current.clipboard <= 2000) {
                if (!visited[current.screen + current.clipboard][current.clipboard]) {
                    visited[current.screen + current.clipboard][current.clipboard] = true;
                    queue.add(new State(current.screen + current.clipboard, current.clipboard, current.time + 1));
                }
            }
            
            if (current.screen > 0) {
                if (!visited[current.screen - 1][current.clipboard]) {
                    visited[current.screen - 1][current.clipboard] = true;
                    queue.add(new State(current.screen - 1, current.clipboard, current.time + 1));
                }
            }
        }
    }
}
