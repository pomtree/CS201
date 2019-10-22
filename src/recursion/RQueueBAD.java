package recursion;

public class RQueueBAD<T> implements Recursion.CarlQueue<T> {
    private T front;
    private RQueueBAD<T> inside;
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
            inside = new RQueueBAD<>();
        }
        inside.enqueue(item);
    }

    @Override
    public T getFront() {
        return front;
    }

    @Override
    public T dequeue() {

        if (inside != null) {
            T temp = rear;
            rear = inside.dequeue(); //recursive call happens here.
            T temp2 = front;
            front = temp;
            if (inside.front == null)
                inside = null; //clean up - size reduction occuring - one fewer RQueue in structure.
            return temp2;
        }
        if (rear != null) { // base case 1. (2 items in RQueue.)
            T temp = front;
            front = rear;
            rear = null;
            return temp;
        }
        T temp = front;  //base case 2. (1 item in RQueue.)
        front = null;
        return temp;

    }

    @Override
    public void display() {
        if (front != null) System.out.println(front);
        if (rear != null) System.out.println(rear);
        if (inside != null) inside.display();
    }

    @Override
    public String toString() {
        String str = "RQueue of contents:\n";
        if (front != null)
            str += "\tFront:" + front.toString();
        else
            str += "\tFront: null";
        if (rear != null)
            str += "\n\tRear:" + rear.toString();
        else
            str += "\n\t" + "Rear: null";
        if (inside != null)
            str += "\n\tInside:" + inside.toString();
        else
            str += "\n\t" + "Inside: null";

        return str;
    }

    // This method is useful for us in testing your code. Do not modify it.
    public void showImmediateContents() {
        System.out.println("Front: " + front);
        System.out.println("Inside: " + inside);
        System.out.println("Rear: " + rear);
    }


}