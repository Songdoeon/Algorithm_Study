import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(!str.startsWith("\"") || !str.endsWith("\"") || str.length() == 1) {
            System.out.println("CE");
            return ;
        }
        str = str.substring(1, str.length() - 1);
        if(str.isEmpty())System.out.println("CE");
        else System.out.println(str);
    }
}