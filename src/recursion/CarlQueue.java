package Recursion;

public interface CarlQueue<T>
{
    // Add item to the queue
    void enqueue(T item);

    // Return next item to come out of queue, without changing it.
    // If the queue is empty, return null
    T getFront();

    // Remove the next item from the queue. If the queue is empty, return null.
    T dequeue();

    // Print the entire contents of the queue to the screen to help you in
    // debugging and us in grading. If the integers 1, 2, 3, 4, 5 were enqueued
    // in that order, this method should print out "1 2 3 4 5".
    void display();

    // Display just the contents of this particular object for grading and
    // debugging purposes. (This is essentially a non-recursive version of the
    // display method.
    void showImmediateContents();

}