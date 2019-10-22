package recursion;

public class RQueue<T> implements Recursion.CarlQueue<T> {
    private T front;
     RQueue<T> inside;
    private T rear;

    @Override
    public void enqueue(T item) {
        if (front == null) {
            front = item;
            return;
        }
        if (rear == null) {
            rear = item;
            return;
        }
        if (inside == null) {
            inside = new RQueue<>();
        }
        inside.enqueue(rear);
        rear = item;

    }

    @Override
    public T getFront() {
        return front;
    }

    @Override
    public T dequeue() {
        if(rear == null) {
            T temp = front;
            front = null;
            return temp;
        }
        if(inside == null) {
            T temp = front;
            front = rear;
            rear = null;
            return temp;
        }
        T temp = front;
        front = inside.dequeue();
        if(inside.front == null)
            inside = null;
        return temp;
    }

    @Override
    public void display() {

    }

    // This method is useful for us in testing your code. Do not modify it.
    public void showImmediateContents() {
        System.out.println("Front: " + front);
        System.out.println("Inside: " + inside);
        System.out.println("Rear: " + rear);
    }


}