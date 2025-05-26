public class Node<Key extends Comparable<Key>, Value> {
    private Key id;
    private Value name;
    private Node left, right;

    private int height;     // BST에선 없는 변수

    public Node(Key newId, Value newName, int height){
        id = newId;
        name = newName;
        left = right = null;
        this.height = height;
    }

    public Key getKey() {return id;}
    public Value getValue() {return name;}
    public Node getLeft() {return left;}
    public Node getRight() {return right;}
    public int getHeight() {return height;}

    public void setKey(Key newId) {id = newId;}
    public void setValue(Value newName) {name = newName;}
    public void setLeft(Node newLeft) {left = newLeft;}
    public void setRight(Node newRight) {right = newRight;}
    public void setHeight(int newHeight) {height = newHeight;}
}
