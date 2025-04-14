public class DequeMain {
    public static void main(String args[]) {
        Deque<String> dq = new Deque();
        dq.insertFront("Apple");
        dq.insertFront("Banana");
        dq.printDeque();
        dq.insertFront("Kiwi");
        dq.insertLast("Mango");
        dq.printDeque();
        dq.insertFront("Orange");
        dq.insertLast("Pear");
        dq.insertFront("WaterMelon");
        dq.printDeque();

        dq.deleteFront();
        dq.deleteLast();
        dq.printDeque();
    }

}
