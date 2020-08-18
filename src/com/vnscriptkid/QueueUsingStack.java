package com.vnscriptkid;

import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public QueueUsingStack() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    public void enqueue(int value) {
       enqueueStack.push(value);
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        if (dequeueStack.isEmpty()) {
            moveFromEnqueueToDequeue();
        }

        return dequeueStack.pop();
    }

    public boolean isEmpty() {
         return dequeueStack.isEmpty() && enqueueStack.isEmpty();
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        if (!dequeueStack.isEmpty())
            return dequeueStack.peek();

        moveFromEnqueueToDequeue();

        return dequeueStack.peek();
    }

    private void moveFromEnqueueToDequeue() {
        while (!enqueueStack.isEmpty()) {
            dequeueStack.push(enqueueStack.pop());
        }
    }
}
