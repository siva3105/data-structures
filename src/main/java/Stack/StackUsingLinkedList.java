package Stack;

import linkedlist.DoubleLinkedList;

public class StackUsingLinkedList {
    private DoubleLinkedList stack;

    public StackUsingLinkedList() {
        stack = new DoubleLinkedList();
    }

    public void push(int data) {
        stack.insertAtStart(data);
    }

    public int pop() {
        int removedData = stack.get(0);
        stack.deleteAt(0);
        System.out.println(removedData + " is popped from stack");
        return removedData;
    }

    public int peek() {
        return stack.get(0);
    }

    public int size() {
        return stack.size();
    }

    public void show(){
        stack.show();
    }
}
