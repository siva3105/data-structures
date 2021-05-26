package linkedlist;

import java.util.Objects;

public class DoubleLinkedList implements Operations {
    private DoubleRefNode head;
    private DoubleRefNode tail;
    private int size;

    public DoubleLinkedList() {
        size = 0;
    }

    public int size() {
        return size;
    }

    private DoubleRefNode createNode(int data) {
        return new DoubleRefNode(data);
    }

    @Override
    public void insert(int value) {
        DoubleRefNode newNode = createNode(value);
        if (head == null) {
            head = newNode;
        } else {
            tail.setNextNode(newNode);
            newNode.setPrevNode(tail);
        }
        tail = newNode;
        size++;
    }

    @Override
    public void insertAtStart(int value) {
        DoubleRefNode newNode = createNode(value);
        if (head == null) {
            tail = newNode;
        } else {
            head.setPrevNode(newNode);
            newNode.setNextNode(head);
        }
        head = newNode;
        size++;
    }

    @Override
    public void insertAt(int value, int position) {
        if (position >= size + 1) {
            System.out.println("enter a valid position, " + value + " can't be added at " + position + " position as size of linked list is " + size);
            return;
        }
        if (position == 0)
            insertAtStart(value);
        else if (position == size) {
            insert(value);
        } else {
            DoubleRefNode newNode = createNode(value);
            DoubleRefNode node = head;
            for (int i = 0; i < position - 1; i++) {
                node = node.getNextNode();
            }
            node.getNextNode().setPrevNode(newNode);
            newNode.setNextNode(node.getNextNode());
            node.setNextNode(newNode);
            newNode.setPrevNode(node);
            size++;
        }
    }

    @Override
    public void deleteAt(int index) {
        if (index >= size) {
            System.out.println("try valid index to delete, size of linked list is " + size);
            return;
        }
        if (index == 0) {
            head = head.getNextNode();
        } else if (index == size - 1) {
            tail = tail.getPrevNode();
            tail.setNextNode(null);
        } else {
            DoubleRefNode node = head;
            for (int i = 0; i < index; i++) {
                node = node.getNextNode();
            }
            node.getPrevNode().setNextNode(node.getNextNode());
            node.getNextNode().setPrevNode(node.getPrevNode());
        }
        size--;

    }

    @Override
    public int get(int index) {
        DoubleRefNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNextNode();
        }
        return node.getData();
    }

    @Override
    public void show() {
        if (size == 0){
            System.out.println("linked list is empty");
            return;
        }
        DoubleRefNode node = head;
        while (node.getNextNode() != null) {
            System.out.print(node.getData() + " --> ");
            node = node.getNextNode();
        }
        System.out.println(node.getData());
    }
}
