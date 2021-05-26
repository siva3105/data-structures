package linkedlist;

public class DoubleRefNode {
    private int data;
    private DoubleRefNode nextNode;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoubleRefNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoubleRefNode nextNode) {
        this.nextNode = nextNode;
    }

    public DoubleRefNode getPrevNode() {
        return PrevNode;
    }

    public void setPrevNode(DoubleRefNode prevNode) {
        PrevNode = prevNode;
    }

    private DoubleRefNode PrevNode;

    public DoubleRefNode(int data) {
        this.data = data;
    }
}
