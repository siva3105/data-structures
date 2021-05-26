package linkedlist;

import java.util.Objects;

public class SingleLinkedList implements Operations {

    private Node head;


    public Node createNode(int value) {
        Node node = new Node();
        node.setValue(value);
        return node;
    }

    @Override
    public void

    insert(int value) {
        Node newNode = createNode(value);
        if (head == null) {
            head = newNode;
        } else {
            Node node = head;
            while (node.getNextNode() != null) {
                node = node.getNextNode();
            }
            node.setNextNode(newNode);
        }
    }

    @Override
    public void insertAtStart(int value) {
        Node newNode = createNode(value);
        Node headnode = head;
        head = newNode;
        newNode.setNextNode(headnode);
    }

    @Override
    public void insertAt(int value, int position) {
        int size = 0;
        if (position == 0) {
            insertAtStart(value);
            return;
        }
        Node newNode = createNode(value);
        Node node = head;
        while (node.getNextNode() != null) {
            if (size == position - 1)
                break;
            node = node.getNextNode();
            size = size + 1;
        }
        if ((size == position - 1)) {
            newNode.setNextNode(node.getNextNode());
            node.setNextNode(newNode);
        } else if (size + 2 == position) {
            node.setNextNode(newNode);
        } else {
            System.out.println("enter a valid position, " + newNode.getValue() + " can't be added at " + position + " position as size of linked list is " + (size + 1));
        }
    }

    @Override
    public void deleteAt(int index) {
        if (index == 0) {
            head = head.getNextNode();
            return;
        }
        Node node = head;
        int size = 0;
        for (int i = 0; node.getNextNode() != null && i < index - 1; i++) {
            node = node.getNextNode();
            size++; // we will get actual size only when we get invalid index
        }
        if (node.getNextNode() == null)
            System.out.println("try valid index to delete, size of linked list is " + (size + 1));
        else if (node.getNextNode().getNextNode() == null)
            node.setNextNode(null);
        else
            node.setNextNode(node.getNextNode().getNextNode());

    }

    @Override
    public int get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNextNode();
        }
        return node.getValue();
    }

    @Override
    public void show() {
        if (Objects.isNull(head)) {
            System.out.println("linked list is empty");
            return;
        }
        Node node = head;
        while (node.getNextNode() != null) {
            System.out.print(node.getValue() + " --> ");
            node = node.getNextNode();
        }
        System.out.println(node.getValue());
    }
}
