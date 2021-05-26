package bst;

public class RedBlackNode<T> {
    private T data;
    private NodeColor color;
    private RedBlackNode<T> leftChild;
    private RedBlackNode<T> rightChild;
    private RedBlackNode<T> parent;

    public RedBlackNode(T data) {
        this.data = data;
        this.color = NodeColor.RED;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeColor getColor() {
        return color;
    }

    public void setColor(NodeColor color) {
        this.color = color;
    }

    public RedBlackNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(RedBlackNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public RedBlackNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(RedBlackNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public RedBlackNode<T> getParent() {
        return parent;
    }

    public void setParent(RedBlackNode<T> parent) {
        this.parent = parent;
    }
}
