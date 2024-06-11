import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ST implements Iterable<String>{

    private Node root;

    private static class Node{
        private String key;
        private int val;
        private Node left, right;
        public Node(String key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public void put(String key, int val){
        root = put(root, key, val);
    }
    private Node put(Node x, String key, int val){
        if(x == null){return new Node(key, val);}
        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            x.left = put(x.left, key, val);
        }else if(cmp > 0){
            x.right = put(x.right, key, val);
        }else if(cmp == 0){x.val = val;}
        return x;
    }

// Must modify - come back later
    public Integer get(String key){
        Node x = root;
        while (x != null){
            int cmp = key.compareTo(x.key);
            if (cmp < 0){x = x.left;}
            if (cmp > 0){x = x.right;}
            if (cmp == 0){return x.val;}
        }
        return null;
    }
    public boolean contains(String key){
        return get(key) != null;
    }

    @Override
    public Iterator<String> iterator() {
        Queue<String> q = new LinkedList<>();
        inorder(root, q);
        return q.iterator();
    }
    private void inorder(Node x, Queue<String> q) {
        if (x != null) {
            inorder(x.left, q);
            q.add(x.key);
            inorder(x.right, q);
        }
    }
}
