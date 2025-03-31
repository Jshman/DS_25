
public class Node<E> {
    private E item;
    private Node<E> previous;
    private Node<E> next;

    public Node(E newItem, Node<E> previous, Node<E> next){
        item = newItem;
        this.previous = previous;
        this.next = next;
    }

    public E getItem() {return item;}
    public Node<E> getPrevious() {return previous;}
    public Node<E> getNext() {return next;}
    public void setItem(E newItem) {item = newItem;}
    public void setPrevious(Node<E> newPrevious) {previous = newPrevious;}
    public void setNext(Node<E> newNext) {next = newNext;}
}