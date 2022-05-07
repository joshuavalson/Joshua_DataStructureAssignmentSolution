package com.ArchitectConsultant.service;

import java.util.Queue;

public class QueueSort {
    public static void sortQueue(Queue<Integer> q) {
        if (q.size() == 0 || q.size() == 1)
            return;

        int n = q.size();
        int count = 0;
        int x = q.poll();
        sortQueue(q); // returns sorted queue
        while (q.peek() < x && count < n) // while elements are smaller than the curr elt, pop them and insert them at the end
        {
            q.add(q.poll());
            count++;
        }
        q.add(x); // once an elt greater of equal is found at the front of the queue, insert the curr elt
        if (count == n) // if curr elt is the greatest, we return at this point
            return;

        count = 0;
        while (q.peek() >= x && count < n) // now we push all the elts greater than the curr elts at the end of the queue
        {
            q.add(q.poll());
            count++;
        }
    }
    
}
