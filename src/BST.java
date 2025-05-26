
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    public Node getRoot() {return root;}
    protected void setRoot(Node newRoot) {this.root = newRoot;}

    public BST(Key newId, Value newName, int height) {
        root = new Node(newId, newName, height);
    }
    // get, put, min, deleteMin, delete
    // 메소드들 선언

    public Value get(Key k) {return get(getRoot(), k);}
    private Value get(Node node, Key k){
        if (node == null) return null;
        int t = node.getKey().compareTo(k);
        if (t > 0) {return get(node.getLeft(), k);}
        else if (t < 0) {return get(node.getRight(), k);}
        else {return (Value) node.getValue();}
    }

    public void put(Key k, Value v) {root = put(root, k, v);}
    private Node<Key, Value> put(Node node, Key k, Value v) {
        if (node == null) return new Node(k, v, 1);
        int c = node.getKey().compareTo(k);

        if (c > 0) {node.setLeft(put(node.getLeft(), k, v));}
        else if (c < 0) {node.setRight(put(node.getRight(), k, v));}
        else if (c == 0) {node.setValue(v);} // key가 같으면 삽입하지 않고 Value를 업데이트
        return node;
    }

    public Key min() {
        if (root == null) return null;
        return (Key) min(root).getKey();
    }
    private Node min(Node node){
        if (node == null) return null;
        if (node.getLeft() == null) return node;
        return min(node.getLeft());
    }

    public void deleteMin() {
        if (root == null) System.out.println("empty tree!");
        root = deleteMin(root);
    }
    private Node deleteMin(Node node) {
        if (node == null) return null;
        if (node.getLeft() == null) {return node.getRight();}
        node.setLeft(deleteMin(node.getLeft()));
        return node;
    }
}
