import java.util.*;
class Solution {
    int[][] answer;
    int idx = 0;
    class Node{
        int num;
        int x;
        int y;
        Node left = null;
        Node right = null;
        Node(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        Node[] node = new Node[nodeinfo.length];
        answer = new int[2][nodeinfo.length];
        int index = 1;
        for(int[] info : nodeinfo){
            node[index - 1] = new Node(index, info[0], info[1]);
            index++;
        }
        
        Arrays.sort(node,(o1, o2) -> o1.y == o2.y ? o1.x - o2.x : o2.y - o1.y);
        Node root = node[0];
        
        for(int i = 1; i < node.length; i++){
            insertNode(root, node[i]);
        }
        idx = 0;
        preorder(root);
        idx = 0;
        postorder(root);
        
        return answer;
    }
    void insertNode(Node parent, Node child) {
        if(parent.x > child.x) {
            if(parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if(parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
    
    void preorder(Node root) {
        if(root != null) {
            answer[0][idx++] = root.num;
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    void postorder(Node root) {
        
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            answer[1][idx++] = root.num;
        }
    }
}