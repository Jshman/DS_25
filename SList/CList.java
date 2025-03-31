import java.util.NoSuchElementException;

public class CList<E extends Comparable<E>>{
    protected Node last;
    private int size;

    public CList() {
        last = null;
        size = 0;
    }

    public int size() {return size;}
    public boolean isEmpty() {return size == 0;}

    public void insertAfter(E newItem, Node exisit) {
        Node newNode = new Node(newItem, null);

        if (last == null) {
            System.out.println("잘못된 입력, 빈 리스트임");
            return;
        }

        newNode.setNext(exisit.getNext());
        exisit.setNext(newNode);

        size++;
    }

    /* target을 삽입한다. */
    public void insert(E target){
        System.out.println("삽입할 항목 = " + target);
        Node newNode = new Node(target, null);
        if (last == null) {
            last = newNode;
            newNode.setNext(last);
        } else {
            newNode.setNext(last.getNext());
            last.setNext(newNode);
        }
        size++;
    }

    public int search(E target){
        Node p = last.getNext();
        for(int k = 0; k < size; k++){
            if(target == p.getItem()) return k;
            p = p.getNext();
        }
        return -1;
    }


    public void delete(E target){
        if(size == 0) throw new NoSuchElementException();

        Node cur = last;
        for (int loop=0; loop < size(); loop++){
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
        last.setNext(last.getNext().getNext());
        size--;
    }


    public void deleteAfter(Node p){
        if(p == null) throw new NoSuchElementException();
        Node target = p.getNext();
        if (target == last) {last = p;}
        p.setNext(target.getNext());
        target.setNext(null);
        size--;
    }

    public void print(){
        if (size() == 0) throw new NoSuchElementException("빈 리스트입니다.");
        Node p = last.getNext();
        for (int i=0; i<size; i++){
            System.out.printf("%s ", p.getItem());
            p = p.getNext();
        }
        System.out.println();
    }

}
