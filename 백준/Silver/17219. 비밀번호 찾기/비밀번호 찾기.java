import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
        Reader in = new Reader();
    	StringBuilder sb = new StringBuilder();
        int N = in.nextInt();
    	int M = in.nextInt();
    	Hashtable<String, String> ht = new Hashtable<>(2 * N);
    	for(int i = 0 ; i < N ; i++){
    	    ht.put(in.next(), in.next());
    	}
    	for(int i = 0 ; i < M ; i++){
            sb.append(ht.get(in.next())).append("\n");
    	}
    	System.out.println(sb);
	}
    static class Reader {
        static final int BUFFER_SIZE = 1 << 14;
        static final int MAX_SITE_LENGTH = 20;

        byte[] buffer;
        byte[] site;
        int index, len, siteIndex;

        Reader() {
            buffer = new byte[BUFFER_SIZE];
            site = new byte[MAX_SITE_LENGTH];
        }

        int nextInt() throws Exception {
            int n = 0;
            byte c;

            while ((c = read()) <= 32);

            do n = (n << 3) + (n << 1) + (c & 15);
            while (isNumber(c = read()));

            return n;
        }

        String next() throws Exception {
            byte c;
            while ((c = read()) <= 32);

            siteIndex = 0;
            do site[siteIndex++] = c;
            while ((c = read()) > 32);

            return new String(site, 0, siteIndex);
        }

        boolean isNumber(byte c) {
            return 47 < c && c < 58;
        }

        byte read() throws Exception {
            if (index == len) {
                len = System.in.read(buffer, index = 0, BUFFER_SIZE);
                if (len == -1) buffer[0] = -1;
            }
            return buffer[index++];
        }
    }
}