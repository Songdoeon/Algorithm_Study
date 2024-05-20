import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while(!(line = br.readLine()).equals("0")){
            int N = Integer.parseInt(line);
            for(int i = 1;i <= N; i++){
                sb.append("*".repeat(i)).append('\n');
            }
        }
        System.out.println(sb);
    }
}