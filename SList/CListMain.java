

public class CListMain {
    public static void main(String args[]) {
        CList<String> s = new CList<>(); // 연결리스트 객체 s 생성
        s.insert("apple");
        s.insert("orange");
        s.insert("cherry");
        s.insert("pear");

        s.print();

        s.delete("apple");
        s.print();
    }
}
