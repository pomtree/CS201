package recursion;

public class RQueueTester2 {
    public static void main(String[] args) {
        RQueue<String> rq = new RQueue<String>();
        rq.enqueue("1");
        rq.enqueue("2");
        rq.enqueue("3");
        rq.enqueue("4");
        rq.enqueue("5");
        rq.showImmediateContents();
        rq.display();
        rq.inside.showImmediateContents();
        rq.inside.inside.showImmediateContents();

        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        rq.enqueue("6");
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());

    }
}
