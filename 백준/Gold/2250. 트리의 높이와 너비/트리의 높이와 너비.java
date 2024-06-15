import java.io.DataInputStream;
import java.io.DataOutputStream;

class Node{
    int left, right;
    int no;

    public Node(int no, int left, int right) {
        this.no = no;
        this.left = left;
        this.right = right;
    }
}
class Main {
    static int N;
    static Node root;
    static int idx;
    static int[][] width;
    static Node[] nodes;
    static void search(Node node, int dep){
        if(node.left != -1) search(nodes[node.left], dep + 1);
        width[dep][0] = Math.min(width[dep][0], idx);
        width[dep][1] = Math.max(width[dep][1], idx);
        idx++;
        if(node.right != -1) search(nodes[node.right], dep + 1);
    }
    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        N = in.nextInt();
        int[] candidate = new int[N + 1];
        nodes = new Node[N + 1];
        idx = 0;
        for (int i = 1; i <= N; i++) {
            int parent = in.nextInt();
            int left = in.nextInt();
            int right = in.nextInt();
            if(left != -1)candidate[left]++;
            if(right != -1)candidate[right]++;
            nodes[parent] = new Node(parent, left, right);
        }
        for (int i = 1; i <= N; i++) {
            if(candidate[i] == 0) {
                root = nodes[i];
                break;
            }
        }
        width = new int[N][2];
        for (int i = 0; i < N; i++) {
            width[i][0] = N + 1;
        }
        search(root, 0);
        int ans = 0;
        int ans1 = 0;
        for (int i = 0; i < N; i++) {
            int wid = width[i][1] - width[i][0];
            if(ans1 < wid){
                ans = i;
                ans1 = wid;
            }
        }
        System.out.println(ans + 1 + " " + (ans1 + 1));
    }
    private static class Reader {
        private static final int EOF = -1;

        private static final byte ASCII_space = 32;
        private static final byte ASCII_minus = 45;
        private static final byte ASCII_0 = 48;
        private static final byte ASCII_9 = 57;

        private final DataInputStream din;
        private final DataOutputStream dout;

        private byte[] inbuffer;
        private int inbufferpointer, bytesread;
        private byte[] outbuffer;
        private int outbufferpointer;

        private byte[] bytebuffer;

        private Reader() {
            this.din = new DataInputStream(System.in);
            this.dout = new DataOutputStream(System.out);

            this.inbuffer = new byte[65536];
            this.inbufferpointer = 0;
            this.bytesread = 0;
            this.outbuffer = new byte[65536];
            this.outbufferpointer = 0;

            this.bytebuffer = new byte[20];
        }

        private Reader(DataInputStream din, DataOutputStream dout) {
            this.din = din;
            this.dout = dout;
        }

        private byte read() {
            if (inbufferpointer == bytesread)
                fillbuffer();
            return bytesread == EOF ? EOF : inbuffer[inbufferpointer++];
        }

        private void fillbuffer() {
            try {
                bytesread = din.read(inbuffer, inbufferpointer = 0, inbuffer.length);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private void write(byte b) {
            if (outbufferpointer == outbuffer.length)
                flushbuffer();
            outbuffer[outbufferpointer++] = b;
        }

        private void flushbuffer() {
            if (outbufferpointer != 0) {
                try {
                    dout.write(outbuffer, 0, outbufferpointer);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                outbufferpointer = 0;
            }
        }

        private int nextInt() {
            byte b;
            while(isSpace(b = read()))
                ;
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = read();
            }
            int result = b - '0';
            while (isDigit(b = read()))
                result = result * 10 + b - '0';
            return negative ? -result : result;
        }

        private void print(int i) {
            if (i == 0) {
                write(ASCII_0);
            } else {
                if (i < 0) {
                    write(ASCII_minus);
                    i = -i;
                }
                int index = 0;
                while (i > 0) {
                    bytebuffer[index++] = (byte) ((i % 10) + ASCII_0);
                    i /= 10;
                }
                while (index-- > 0) {
                    write(bytebuffer[index]);
                }
            }
        }

        private void printls(int i, int j) {
            print(i);
            write(ASCII_space);
            print(j);
        }

        private boolean isSpace(byte b) {
            return b <= ASCII_space && b >= 0;
        }

        private boolean isDigit(byte b) {
            return b >= ASCII_0 && b <= ASCII_9;
        }
    }
}