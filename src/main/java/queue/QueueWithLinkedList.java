package queue;

public class QueueWithLinkedList<T extends Comparable<T>> {

    private QueueNode<T> firstNode;
    private QueueNode<T> lastNode;
    private int size;

    public boolean isEmpty() {
        return firstNode == null;
    }

    public int size() {
        return this.size;
    }

    public void enqueue(T data) {
        QueueNode<T> oldNode = this.lastNode;
        this.lastNode = createNode(data);

        if (isEmpty()) {
            this.firstNode = this.lastNode;
        } else {
            oldNode.setNextNode(this.lastNode);
        }
        this.size++;
    }

    public T dequeue() {
        T data = this.firstNode.getData();
        this.firstNode = this.firstNode.getNextNode();
        if (isEmpty()){
            this.lastNode = null;
        }
        return data;
    }

    public T peek(){
        return this.firstNode.getData();
    }

    private QueueNode<T> createNode(T data) {
        return new QueueNode<>(data);
    }

}
