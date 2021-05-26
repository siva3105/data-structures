package bst;

import java.util.Objects;

public class RedBlackTree<T extends Comparable<T>> implements TreeOperations<T> {
    private RedBlackNode<T> root;

    @Override
    public void insert(T data) {
        RedBlackNode<T> newNode = new RedBlackNode<>(data);
        root = insertToTree(root, newNode);
        fixViolation(newNode);
    }

    private void fixViolation(RedBlackNode<T> node) {
        RedBlackNode<T> parentNode = null;
        RedBlackNode<T> grandParentNode = null;
        while (node != root && node.getColor() != NodeColor.BLACK && node.getParent().getColor() == NodeColor.RED) {
            parentNode = node.getParent();
            grandParentNode = node.getParent().getParent();
            if (parentNode == grandParentNode.getLeftChild()) {
                RedBlackNode<T> parentSibling = grandParentNode.getRightChild();
                if (parentSibling != null && parentSibling.getColor() == NodeColor.RED) {
                    //case 1 and case 4
                    parentNode.setColor(NodeColor.BLACK);
                    parentSibling.setColor(NodeColor.BLACK);
                    grandParentNode.setColor(NodeColor.RED);
                    node = grandParentNode; // we need to check any voilation after case1 or case 4 in other parts of tree
                } else {
                    //case 2, after left rotation it will be come under case 3 so for case 2 we need to do case 2 and case 3
                    if (node == parentNode.getRightChild()) {
                        leftRotation(parentNode);
                        node = parentNode;
                        parentNode = node.getParent();
                    }
                    rightRotation(grandParentNode);
                    NodeColor temp = grandParentNode.getColor();
                    grandParentNode.setColor(parentNode.getColor());
                    parentNode.setColor(temp);
                    node = parentNode;
                }
            } else {
                RedBlackNode<T> parentSibling = grandParentNode.getLeftChild();
                if (parentSibling != null && parentSibling.getColor() == NodeColor.RED) {
                    //case 1 and case 4
                    parentNode.setColor(NodeColor.BLACK);
                    parentSibling.setColor(NodeColor.BLACK);
                    grandParentNode.setColor(NodeColor.RED);
                    node = grandParentNode; // we need to check any voilation after case1 or case 4 in other parts of tree
                } else {
                    if (node == parentNode.getLeftChild()) {
                        rightRotation(parentNode);
                        node = parentNode;
                        parentNode = node.getParent();
                    }
                    leftRotation(grandParentNode);
                    NodeColor temp = grandParentNode.getColor();
                    grandParentNode.setColor(parentNode.getColor());
                    parentNode.setColor(temp);
                    node = parentNode;
                }
            }
        }
        if (root.getColor() == NodeColor.RED) {
            root.setColor(NodeColor.BLACK);
        }
    }

    private RedBlackNode<T> insertToTree(RedBlackNode<T> root, RedBlackNode<T> newNode) {
        if (root == null) {
            return newNode;
        }

        if (newNode.getData().compareTo(root.getData()) > 0) {
            root.setRightChild(insertToTree(root.getRightChild(), newNode));
            root.getRightChild().setParent(root);
        } else {
            root.setLeftChild(insertToTree(root.getLeftChild(), newNode));
            root.getLeftChild().setParent(root);
        }
        return root;
    }

    private void rightRotation(RedBlackNode<T> node) {
        RedBlackNode<T> tempLeftNode = node.getLeftChild();
        RedBlackNode<T> temp = tempLeftNode.getRightChild();
        node.setLeftChild(temp);
        if (temp != null) {
            temp.setParent(node);
        }
        tempLeftNode.setParent(node.getParent());
        if (node.getParent() == null) {
            root = tempLeftNode;
        } else if (Objects.equals(node, node.getParent().getLeftChild())) {
            node.getParent().setLeftChild(tempLeftNode);
        } else {
            node.getParent().setRightChild(tempLeftNode);
        }
        tempLeftNode.setRightChild(node);
        node.setParent(tempLeftNode);
    }

    private void leftRotation(RedBlackNode<T> node) {
        RedBlackNode<T> tempRightNode = node.getRightChild();
        node.setRightChild(tempRightNode.getLeftChild());
        if (node.getRightChild() != null) {
            node.getRightChild().setParent(node);
        }
        tempRightNode.setParent(node.getParent());
        if (node.getParent() == null) {
            root = tempRightNode;
        } else if (Objects.equals(node, node.getParent().getLeftChild())) {
            node.getParent().setLeftChild(tempRightNode);
        } else {
            node.getParent().setRightChild(tempRightNode);
        }
        tempRightNode.setLeftChild(node);
        node.setParent(tempRightNode);
    }

    @Override
    public void traversal() {
        if (root != null) {
            inorderTraversal(root);
        }
    }

    private void inorderTraversal(RedBlackNode<T> node) {
        if (node.getLeftChild() != null)
            inorderTraversal(node.getLeftChild());

        System.out.println(node.getData());

        if (node.getRightChild() != null)
            inorderTraversal(node.getRightChild());
    }

    @Override
    public void delete(T data) {

    }
}
