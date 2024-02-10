import java.io.*;
import java.util.*;

class Node{
    int num;
    Node left = null;
    Node right = null;
    public Node(int num) {
        this.num = num;
    }
}
public class Main {
    static StringBuilder sb = new StringBuilder();
    static void insert(Node root, int n){
        if(root.num < n){
            if(root.right == null){
                root.right = new Node(n);
            }
            else insert(root.right, n);
        }
        else{
            if(root.left == null){
                root.left = new Node(n);
            }
            else{
                insert(root.left, n);
            }
        }
    }
    static void printNode(Node node){
        if(node == null) return ;

        printNode(node.left);
        printNode(node.right);
        sb.append(node.num).append('\n');
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String num;
        while(((num = br.readLine()) != null)){
            if(num.equals(""))break;
            insert(root, Integer.parseInt(num));
        }
        printNode(root);
        System.out.println(sb);
    }
}
