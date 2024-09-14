import java.io.*;
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int read() throws Exception {
        return Integer.parseInt(br.readLine());
    }
    public static void main(String[] args) throws Exception {
        System.out.println((Math.min(Math.min(read(), read()), read()) + Math.min(read(), read())) - 50);
    }
}