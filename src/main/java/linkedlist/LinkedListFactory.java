package linkedlist;

public class LinkedListFactory {
    private static final String SINGLE_LINKED_LIST = "singleLinkedList";
    private static final String DOUBLE_LINKED_LIST = "doubleLinkedList";

    public static Operations getInstance(String type){
        if (type.equalsIgnoreCase(SINGLE_LINKED_LIST))
            return new SingleLinkedList();
        else if (type.equalsIgnoreCase(DOUBLE_LINKED_LIST))
            return new DoubleLinkedList();
        else
            return null;
    }
}
