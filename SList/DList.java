import java.util.NoSuchElementException;

// Doubly Linked List
public class DList<E extends Comparable<E>>{
    protected Node head;
    protected Node tail;
    private int size;
    public DList() {
        head = new Node(null, null, null);
        tail = new Node(null, head, null);
        head.setNext(tail);
        size = 0;
    }

    public int size() {return size;}
    public boolean isEmpty() {return size == 0;}

    public void insertFront(E newItem){
        head = new Node(newItem, head, tail);
        size++;
    }

    // exsitingNode 뒤에 새 노드를 삽입한다.
    public void insertAfter(E newItem, Node exsitingNode){
        Node newNode = new Node(newItem, exsitingNode, exsitingNode.getNext());
        exsitingNode.getNext().setPrevious(newNode);
        exsitingNode.setNext(newNode);
        size++;
    }

    // exsitingNode 앞에 새 노드를 삽입한다.
    public void insertBefore(E newItem, Node exsitingNode){
        Node newNode = new Node(newItem, exsitingNode.getPrevious(), exsitingNode);
        exsitingNode.getPrevious().setNext(newNode);
        exsitingNode.setPrevious(newNode);
        size++;
    }


    /* target을 삽입한다. */
    public void insert(E target){
        System.out.println("삽입할 항목 = " + target);
        Node p = head;
        Node q = null;

        while (p != null) {
            // 삽입할 위치를 찾았다면
            if(((Comparable<E>)p.getItem()).compareTo(target) >= 0) {
                insertAfter(target, p);
                break;
            }
            // 찾지 못했다면 다음 노드로 이동
            q = p;
            p = p.getNext();
        }
        // 만약 빈 리스트라면
        if (q == null) { // head가 null이거나 head만 있는 경우, 즉 list 길이가 0 또는 1일 때
            insertAfter(target, q);
        }
        if (size() == 0) {
            insertFront(target);
        } else if (size() == 1){
            insertAfter(target, head);
        }

//        while(p != null){
//            if(((Comparable<E>)p.getItem()).compareTo(target) >= 0){
//                if(p != head){
//                    q.setNext(new Node(target, p));
//                    break;
//                }
//            }
//            q = p;
//            p = p.getNext();
//        }
//        if(q == null){
//            head = new Node(target, head);
//
//        }
//        else if(p == null){
//            q.setNext(new Node(target, null));
//        }
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

    public void delete(Node<E> target) {
        delete(target.getItem());
    }

    public void delete(E target){
        if(size == 0) throw new NoSuchElementException();

        Node cur = head;
//        if (cur.getItem() == target) {deleteFront(); return;}

        while (cur.getNext().getItem() != null && cur.getItem() != target) {
            if (cur.getNext().getItem() == target) {
                deleteAfter(cur);
                return;
            }
            cur = cur.getNext();
        }
        System.out.println(target+"이(가) 연결 리스트에 없다.");
    }

    public void deleteFront(){
        if(size == 0) throw new NoSuchElementException();
        deleteAfter(this.head.getNext());
        size--;
    }


    // 기존 노드 뒤에를 삭제한다.
    public void deleteAfter(Node<E> exisit){
        if(exisit == null) throw new NoSuchElementException();

        Node<E> exisitNext = exisit.getNext();
        exisitNext.getNext().setPrevious(exisit);
        exisit.setNext(exisitNext.getNext());
        size--;
    }

    public void print(){
        if (size() == 0) throw new NoSuchElementException();
        Node p = head.getNext();
        while (p.getItem() != null) {
            System.out.printf("%s ", p.getItem());
            p = p.getNext();
        }
        System.out.println();
    }

//    public int compareList(DList<E> p1, DList<E> q1) {
//        Node<E> h1 = p1.head;
//        Node<E> h2 = q1.head;
//        int sum=0;
//
//        while (h1 != null) {
//            if (h1.getItem().compareTo(h2.getItem()) == 0) {
//                sum += (int) h1.getItem();
//            }
//            if(h2 != null) h2 = h1.getNext();
//            if (h2 == null) { // h1과 h2가 더이상 같은 값이 없어 끝까지 갔을 때
//                h2 = q1.head;
//                h1 = h1.getNext();
//            }
//        }
//        return sum;
//    }

}
