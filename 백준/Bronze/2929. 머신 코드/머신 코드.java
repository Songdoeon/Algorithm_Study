import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

interface Main{
    static void main(String[]a) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        String regex = "([A-Z][a-z]*)";
        Pattern pattern = Pattern.compile(regex);
        int NOPcnt = 0, start;
        str = br.readLine();
        Matcher matcher = pattern.matcher(str);
        
        while(matcher.find()) {
          start = matcher.start();
          start += NOPcnt;
          
          if(start%4 != 0) {
            NOPcnt += 4-start%4;
          }
        }
        bw.write(NOPcnt+"");
        bw.flush();
    }
}