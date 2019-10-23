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
        T temp = front;
        if (rear == null) {
            front = null;
            return temp;
        }
        if (inside == null) {
            front = rear;
            rear = null;
            return temp;
        }
        front = inside.dequeue();
        if (inside.front == null)
            inside = null;
        return temp;
    }

    @Override
    public void display() {
        System.out.println(toString());
    }

    public String toString() {
        String str = "";
        if (front != null) {
            str += front.toString();
        }
        if (inside != null) {
            str += inside.toString();
        }
        if (rear != null) {
            str += rear.toString();
        }
        return str;
    }

    // This method is useful for us in testing your code. Do not modify it.
    public void showImmediateContents() {
        System.out.println("Front: " + front);
        System.out.println("Inside: " + inside);
        System.out.println("Rear: " + rear);
    }


}