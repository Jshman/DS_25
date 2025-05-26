public class AVL<Key extends Comparable<Key>, Value> extends BST{

    AVL(Key newId, Value value) {
        super(newId, value, 1);
    }

    public void add(Key k, Value v) {
        Node newRoot = add(super.getRoot(), k, v);
        super.setRoot(newRoot);
    }

    private Node add(Node<Key, Value> n, Key k, Value v) {
        if (n == null) return new Node(k, v, 1);
        int t = k.compareTo(n.getKey());
        if (t<0) n.setLeft(add(n.getLeft(), k, v));
        else if (t>0) n.setRight(add(n.getRight(), k, v));
        else {
            n.setValue(v);
            return n;
        }
        n.setHeight(Math.max(height(n.getLeft()), height(n.getRight())));
        return balance(n);
    }

    // 회전에 관한 메서드들 정의
    private Node balance(Node node) {
        int bf = BF(node);
        if (bf > 1) {
            if (BF(node.getLeft()) < 0) { //LR 회전
                node.setLeft(rotateLeft(node.getLeft()));
            }
            node = rotateRight(node); // LL회전
        }
        else if (bf < -1) {
            if (BF(node.getRight()) < 0) { //RL 회전
                node.setRight(rotateRight(node.getRight()));
            }
            node = rotateLeft(node);
        }
        return node;
    }

    // Balance Factor 계산
    private int BF(Node node) {
        return height(node.getLeft()) - height(node.getRight());
    }

    private int height(Node node) {
        if (node == null) return 0;
        return node.getHeight();
    }

    private int tallerHeight(int x, int y) {return x>y ? x : y;}

    // LL 회전 - rotateRight
    private Node rotateRight(Node z) {
        if (z == null) return null;
        Node y = z.getLeft();
        z.setLeft(y.getRight());
        y.setRight(z);

        //높이 갱신
        z.setHeight(Math.max(z.getLeft().getHeight(), z.getRight().getHeight()));
        y.setHeight(Math.max(y.getLeft().getHeight(), y.getRight().getHeight()));
        return y;
    }

    // RR 회전 - rotateLeft
    private Node rotateLeft(Node z) {
        if (z == null) return null;
        Node y = z.getRight();
        z.setRight(y.getLeft());
        y.setLeft(z);

        //높이 갱신
        z.setHeight(Math.max(z.getLeft().getHeight(), z.getRight().getHeight()));
        y.setHeight(Math.max(y.getLeft().getHeight(), y.getRight().getHeight()));
        return y;
    }



}
