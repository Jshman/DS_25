import java.util.NoSuchElementException;

public class Queue<E> {
    private E[] queue;
    private int front, rear, size;

    public Queue() {
        queue = (E[]) new Object[2];
        front = 0;
        rear = 1;
        size = 1;
    }

    public int size() {return size-1;}
    public boolean isEmpty() {return size-1 == 0;}

    private void resize(int newSize) {
        E[] t = (E[]) new Object[newSize];
        for (int idx = 0; idx < size; idx++) {
            t[idx+1] = queue[(front+idx+1)%queue.length];
        }
        front = 0;
        rear = size-1;
        queue = t;
    }

    public void add(E item) {
        if ((rear+1)% queue.length == front) {resize(queue.length * 2);}
        rear = (rear+1)% queue.length;
        queue[rear] = item;
        size++;
    }

    public E remove() {
        if (isEmpty()) {throw new NoSuchElementException();}
        E retItem = queue[front+1];
        queue[front+1] = null;
        front = (front+1) % queue.length;
        size--;
        if (size>0 && size == queue.length/4) {resize(queue.length/2);}
        return retItem;
    }

    public void printArr() {
        if (isEmpty()) {System.out.println("빈 Queue 입니다.");}
        for (int i=0; i< queue.length; i++) {
            System.out.printf(queue[(front+i) % queue.length]+" ");
        }
        System.out.println();
    }

    public void printQueue() {
        if (isEmpty()) {System.out.println("빈 Queue 입니다.");}
        for (int i=0; i<size(); i++) {
            System.out.printf(queue[(front+1+i)%queue.length]+" ");
        }
        System.out.println();
    }
}
