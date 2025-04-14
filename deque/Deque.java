import java.util.NoSuchElementException;

public class Deque<E> {
    private DNode<E> head, tail;
    private int size;

    Deque() {
        head = new DNode<E>(null, null, null);
        tail = new DNode<E>(null, head, null);
        head.setNext(tail);
        size = 0;
        System.out.println("초기화 완료");
    }

    public int size() {return size;}
    public boolean isEmpty() {return size==0;}

    public void insertFront(E newItem) {
        DNode t = head.getNext();
        DNode newNode = new DNode(newItem, head, t);
        t.setPrevious(newNode);
        head.setNext(newNode);
        size++;
    }

    public void insertLast(E newItem) {
        DNode t = tail.getPrevious();
        DNode newNode = new DNode(newItem, t, tail);
        t.setNext(newNode);
        tail.setPrevious(newNode);
        size++;
    }

    public E deleteFront() {
        if (isEmpty()) {throw new NoSuchElementException("빈 Deque");}
        DNode target = head.getNext();
        E item = (E) target.getItem();

        target.getNext().setPrevious(head);
        head.setNext(target.getNext());
        target = null; //명시적으로 target이 가비지 컬렉터로 넘어감을 알림

        size--;
        return item;
    }

    public E deleteLast() {
        if (isEmpty()) {throw new NoSuchElementException("빈 Deque");}
        DNode target = tail.getPrevious();
        E item = (E) target.getItem();
        target.getPrevious().setNext(tail);
        tail.setPrevious(target.getPrevious());
        target = null;

        size--;
        return item;
    }

    public void printDeque() {
        if (isEmpty()) {
            System.out.println("빈 Deque 입니다.");
            return;
        }
        for (DNode cur = head.getNext(); cur!=tail; cur=cur.getNext()) {
            System.out.printf(cur.getItem()+" ");
        }
        System.out.println();
    }
}
