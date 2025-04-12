public class QueueMain {
    public static void main(String args[]) {
        Queue q = new Queue();
        String[] strs = {"Apple", "Orange", "Grape", "Pear", "Cherry", "Melon", "Banana"};

        q.add("Apple");
        q.add("Grape");
        q.add("Pear");
        q.add("Melon");
        q.add("Banana");

//        System.out.println(q.remove()); // Apple
        q.printArr();
        q.printQueue();
        q.remove(); //Apple
        q.remove(); //Grape
        q.remove(); //Pear
        q.printQueue();
        q.remove(); // Melon
        q.printQueue();
        q.remove(); // Banana
        q.printQueue();
    }

}
