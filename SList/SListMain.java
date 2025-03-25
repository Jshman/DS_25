

public class SListMain{
    public static void main(String args[]) {
        SList<String> s = new SList<>(); // 연결리스트 객체 s 생성
        s.insert("orange");
        s.insertFront("apple");
        s.insertAfter("cherry", s.head.getNext());
        s.insertFront("pear");

        s.print();
    }
}
