

public class DListMain {
    public static void main(String args[]) {
        DList<String> s = new DList<String>();
        s.insertAfter("apple", s.head);
        s.insertBefore("orange", s.tail);
        s.insertBefore("cherry", s.tail);
        s.insertAfter("pear", s.head.getNext());
        s.print();
        System.out.println();
        s.delete("cherry");
        s.print();
        s.delete("grape");

    }
}
