import java.util.NoSuchElementException;

public class SList<E extends Comparable<E>>{
    protected Node head;
    private int size;
    public SList() {
        head = null;
        size = 0;
    }

    public int size() {return size;}
    public boolean isEmpty() {return size == 0;}
    public void insertFront(E newItem){
        head = new Node(newItem, head);
        size++;
    }


    public void insertAfter(E newItem, Node p){
        Node t = new Node(newItem, p.getNext());
        p.setNext(t);
        size++;
    }

    /* target을 삽입한다. */
    public void insert(E target){
        System.out.println("삽입할 항목 = " + target);
        Node p = head;
        Node q = null;
        while(p != null){
            if(((Comparable<E>)p.getItem()).compareTo(target) >= 0){
                if(p != head){
                    q.setNext(new Node(target, p));
                    break;
                }
            }
            q = p;
            p = p.getNext();
        }
        if(q == null){
            head = new Node(target, head);

        }
        else if(p == null){
            q.setNext(new Node(target, null));
        }
        size++;
    }


    public int search(E target){
        Node p = head;
        for(int k = 0; k < size; k++){
            if(target == p.getItem()) return k;
            p = p.getNext();
        }
        return -1;
    }


    // TODO 202202590 박종현 delete 메서드 제출
    public void delete(E target){
        if(size == 0) throw new NoSuchElementException();

        Node cur = head;
        if (cur.getItem() == target) {deleteFront(); return;}
        while (cur != null && cur.getItem() != target) {
            if (cur.getNext().getItem() == target) {
                deleteAfter(cur);
                return;
            }
            cur = cur.getNext();
        }
        System.out.println("target이 연결 리스트에 없다.");
    }

    public void deleteFront(){
        if(size == 0) throw new NoSuchElementException();
        head = head.getNext();
        size--;
    }


    public void deleteAfter(Node p){
        if(p == null) throw new NoSuchElementException();
        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null);
        size--;
    }

    public void print(){
        if (head == null) throw new NoSuchElementException();
        Node p = head;
        while (p != null) {
            System.out.printf("%s ", p.getItem());
            p = p.getNext();
        }
        System.out.println();
    }

}
