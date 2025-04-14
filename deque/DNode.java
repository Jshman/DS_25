
public class DNode<E> {
    private E item;
    private DNode<E> previous;
    private DNode<E> next;

    public DNode(E newItem, DNode<E> previous, DNode<E> next){
        item = newItem;
        this.previous = previous;
        this.next = next;
    }

    public E getItem() {return item;}
    public DNode<E> getPrevious() {return previous;}
    public DNode<E> getNext() {return next;}
    public void setItem(E newItem) {item = newItem;}
    public void setPrevious(DNode<E> newPrevious) {previous = newPrevious;}
    public void setNext(DNode<E> newNext) {next = newNext;}
}