package recursion;

public class QueueTester {
    public static void main(String[] args) {
        RQueue<String> rq = new RQueue<>();
        rq.enqueue("1");
        rq.enqueue("2");
        rq.enqueue("3");
        System.out.println(rq.dequeue());
        rq.enqueue("4");
        rq.enqueue("5");
        rq.enqueue("6");
        rq.enqueue("7");

        System.out.println("Contents:");
        rq.showImmediateContents();
        System.out.println("End Contents.");


       // System.out.println("Dequeing");
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        rq.enqueue("8");
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        rq.enqueue("9");
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());

        System.out.println("Sample case.");
        rq = new RQueue<>();
        rq.enqueue("First");
        rq.enqueue("Second");
        rq.enqueue("Third");
        rq.showImmediateContents();

    }
}
