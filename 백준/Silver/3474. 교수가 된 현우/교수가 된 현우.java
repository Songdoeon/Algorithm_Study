import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());
        for(int t=0;t<tc;t++){
            int answer=0;
            int n=Integer.parseInt(br.readLine());

            for(int i=1;i<n;i++){
                long k=(long)Math.pow(5,i);
                if(k>n){
                    break;
                }else{
                    answer+=(long)(n/k);   
                }
            }
            System.out.println(answer);
        }
        
    }
}