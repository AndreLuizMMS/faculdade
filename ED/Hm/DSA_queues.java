package Hm;
import java.util.LinkedList;
import java.util.Queue;

public class DSA_queues {
  public static void main(String[] args) {

    // FIFO First-in-First-out

    // add() = queue, offer()
    // remove() - dequeue, poll()

    Queue<Integer> queue = new LinkedList<Integer>();
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);
    queue.offer(4);
    queue.offer(5);
    
    // First-in-First-out
    
    queue.poll();// removes 1
    queue.poll();// removes 2
    queue.poll();// removes 3
    queue.poll();// removes 4
    queue.poll();// removes 5
  }
}
