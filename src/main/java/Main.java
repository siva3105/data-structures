import Stack.DijkstraInterpreter;
import Stack.StackUsingArrays;
import Stack.StackUsingLinkedList;
import bst.AvlTree;
import bst.BinarySearchTree;
import heap.MaxHeap;
import linkedlist.*;
import queue.QueueWithLinkedList;
import tries.Trie;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        //factory impementation for linked list
        Operations linkedList = LinkedListFactory.getInstance("singleLinkedList");
        if (Objects.isNull(linkedList))
            System.out.println("try valid type either singleLinkedList or doubleLinkedList");
        else {
            linkedList.insert(2);
            linkedList.insertAtStart(3);
            linkedList.insertAt(4,1);
            linkedList.show();
            linkedList.deleteAt(1);
            linkedList.show();
            System.out.println("value at index 1 is " + linkedList.get(1));
        }

        System.out.println("````````````````````````````````````````````````````````````````");

        Operations doubleLinkedList = LinkedListFactory.getInstance("doubleLinkedList");
        if (Objects.isNull(linkedList))
            System.out.println("try valid type either singleLinkedList or doubleLinkedList");
        else {
            doubleLinkedList.insert(2);
            doubleLinkedList.insertAtStart(3);
            doubleLinkedList.insertAt(4,1);
            doubleLinkedList.show();
            doubleLinkedList.deleteAt(1);
            doubleLinkedList.show();
            System.out.println("value at index 0 is " + doubleLinkedList.get(0));

        }

        System.out.println("````````````````````````````````````````````````````````````````");

        Operations invalidEntry = LinkedListFactory.getInstance("stack");
        if (Objects.isNull(invalidEntry))
            System.out.println("try valid type either singleLinkedList or doubleLinkedList");
        else {
            invalidEntry.insert(2);
            invalidEntry.insertAtStart(3);
            invalidEntry.insertAt(4,1);
            invalidEntry.show();
            invalidEntry.deleteAt(1);
            invalidEntry.show();
        }

        System.out.println("````````````````````````````````````````````````````````````````");
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(2);
        stack.push(6);
        stack.push(7);
        stack.show();
        stack.pop();
        stack.show();
        stack.push(8);
        stack.show();
        System.out.println("peek of stack is "+stack.peek());
        System.out.println("size of stack is "+ stack.size());

        System.out.println("````````````````````````````````````````````````````````````````");

        StackUsingArrays<Integer> genericStack = new StackUsingArrays<>();
        genericStack.push(10);
        genericStack.push(100);
        genericStack.push(1000);
        System.out.println(genericStack.peek());
        System.out.println(genericStack.pop());
        System.out.println(genericStack.pop());
        System.out.println(genericStack.pop());
        System.out.println(genericStack.isEmpty());


        System.out.println("````````````````````````````````````````````````````````````````");

        DijkstraInterpreter dijkstraInterpreter = new DijkstraInterpreter();
        System.out.println(dijkstraInterpreter.evalutate("2 + 5 * 6 + 8 / 2"));
        System.out.println(dijkstraInterpreter.evalutate("2 + 5 * ( 6 + 8 ) / 2"));

        System.out.println("````````````````````````````````````````````````````````````````");

        QueueWithLinkedList<Integer> queue = new QueueWithLinkedList<>();
        queue.enqueue(25);
        queue.enqueue(35);
        System.out.println("peek element is "+ queue.peek());
        System.out.println("dequeued data is "+ queue.dequeue());
        System.out.println("dequeued data is "+ queue.dequeue());
        System.out.println(queue.isEmpty());

        System.out.println("````````````````````````````````````````````````````````````````");

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(45);
        bst.insert(30);
        bst.insert(50);
        bst.insert(20);
        bst.insert(35);
        bst.insert(47);
        bst.insert(60);
        bst.insert(15);
        bst.insert(65);
        bst.insert(10);
        bst.insert(17);
        bst.delete(47);
        bst.delete(20);
        bst.delete(60);
        bst.delete(30);
        bst.traversal();

        System.out.println("````````````````````````````````````````````````````````````````");

        AvlTree<Integer> avl = new AvlTree<>();
//        avl.insert(1);
//        avl.insert(2);
//        avl.insert(6);
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(6);
        avl.delete(3);

        System.out.println("````````````````````````````````````````````````````````````````");

        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(5);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(2);
        maxHeap.insert(8);
        System.out.println(maxHeap.getMax());
        maxHeap.remove();
        System.out.println(maxHeap.getMax());

        System.out.println("````````````````````````````````````````````````````````````````");

        Trie trie = new Trie();
        trie.put("arjunsiva",1);
        trie.put("arjsivkumar",2);
        trie.put("arjun",3);
        trie.put("arxcsf",4);
        trie.put("arcsf",4);
        System.out.println(trie.containsKey("ar"));
        System.out.println(trie.containsKey("sivaki"));
        System.out.println(trie.get("arjunsiva"));
        System.out.println(trie.get("arjsivkumar"));
        trie.delete("arjunsiva");
        System.out.println(trie.get("arjunsiva"));
        System.out.println(trie.get("ar"));
        System.out.println(trie.get("siv"));
        System.out.println(trie.sortKeys());
        System.out.println(trie.getLongestCommonPrefix());

    }

}
