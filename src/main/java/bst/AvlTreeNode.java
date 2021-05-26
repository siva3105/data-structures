package bst;

public class AvlTreeNode<T>  {
    private T data;
    private AvlTreeNode<T> leftChild;
    private AvlTreeNode<T> rightChild;
    private int height;
    public AvlTreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public AvlTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AvlTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public AvlTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(AvlTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
