package bst;

public class AvlTree<T extends Comparable<T>> implements TreeOperations<T> {
    private AvlTreeNode<T> root;

    @Override
    public void insert(T data) {
        root = insertInTree(root, data);

    }


    private AvlTreeNode<T> insertInTree(AvlTreeNode<T> node, T data) {
        if (node == null) {
            return new AvlTreeNode<>(data);
        }
        if (data.compareTo(node.getData()) > 0)
            node.setRightChild(insertInTree(node.getRightChild(), data));
        else
            node.setLeftChild(insertInTree(node.getLeftChild(), data));
        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
        node = BalancedTreeMakerForInsert(data, node);
        return node;
    }

    private AvlTreeNode<T> BalancedTreeMakerForInsert(T data, AvlTreeNode<T> node) {
        int balanceFactorValue = getBalance(node);
        if (balanceFactorValue > 1 && data.compareTo(node.getLeftChild().getData()) < 0) {
            System.out.println("right rotation");
            return rightRotation(node);
        }
        if (balanceFactorValue < -1 && data.compareTo(node.getRightChild().getData()) > 0) {
            System.out.println("left rotation");
            return leftRotation(node);
        }
        if (balanceFactorValue > 1 && data.compareTo(node.getLeftChild().getData()) > 0) {
            node.setLeftChild(leftRotation(node.getLeftChild()));
            return rightRotation(node);
        }
        if (balanceFactorValue < -1 && data.compareTo(node.getRightChild().getData()) < 0) {
            node.setRightChild(rightRotation(node.getRightChild()));
            return leftRotation(node);
        }
        return node;
    }

    private AvlTreeNode<T> rightRotation(AvlTreeNode<T> node) {
        System.out.println("right rotation");
        AvlTreeNode<T> tempLeftNode = node.getLeftChild();
        AvlTreeNode<T> temp = tempLeftNode.getRightChild();
        tempLeftNode.setRightChild(node);
        node.setLeftChild(temp);
        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
        tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeftChild()), height(tempLeftNode.getRightChild())) + 1);
        return tempLeftNode;
    }

    private AvlTreeNode<T> leftRotation(AvlTreeNode<T> node) {
        System.out.println("left rotation");
        AvlTreeNode<T> tempRightNode = node.getRightChild();
        AvlTreeNode<T> temp = tempRightNode.getLeftChild();
        tempRightNode.setLeftChild(node);
        node.setRightChild(temp);
        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
        tempRightNode.setHeight(Math.max(height(tempRightNode.getLeftChild()), height(tempRightNode.getRightChild())) + 1);
        return tempRightNode;
    }

    private int height(AvlTreeNode<T> node) {
        if (node == null) {
            return -1;
        }
        return node.getHeight();
    }

    private int getBalance(AvlTreeNode<T> node) {
        if (node == null)
            return 0;
        return height(node.getLeftChild()) - height(node.getRightChild());
    }

    @Override
    public void traversal() {
        if (root != null) {
            inorderTraversal(root);
        }
    }

    private void inorderTraversal(AvlTreeNode<T> node) {
        if (node.getLeftChild() != null)
            inorderTraversal(node.getLeftChild());

        System.out.println(node.getData());

        if (node.getRightChild() != null)
            inorderTraversal(node.getRightChild());
    }

    @Override
    public void delete(T data) {
        if (root != null) {
            deleteNode(root, data);
        }
    }

    private AvlTreeNode<T> deleteNode(AvlTreeNode<T> node, T data) {
        if (node == null)
            return node;
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(deleteNode(node.getLeftChild(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(deleteNode(node.getRightChild(), data));
        } else {
            if (node.getRightChild() == null && node.getLeftChild() == null) {
                System.out.println("removed element is leaf node");
                return null;
            }
            if (node.getLeftChild() == null) {
                System.out.println("removed element's left child is empty");
                AvlTreeNode<T> rightChild = node.getRightChild();
                node = null;
                return rightChild;
            }
            if (node.getRightChild() == null) {
                System.out.println("removed element's right child is empty");
                AvlTreeNode<T> leftChild = node.getLeftChild();
                node = null;
                return leftChild;
            }
            System.out.println("removed element contains two childrens");
            AvlTreeNode<T> predecessor = getPredecessor(node.getLeftChild());
            node.setData(predecessor.getData());
            node.setLeftChild(deleteNode(node.getLeftChild(), predecessor.getData()));
        }
        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
        return balancedTreeMakerForDelete(node);
    }

    private AvlTreeNode<T> balancedTreeMakerForDelete(AvlTreeNode<T> node) {
        if (getBalance(node) > 1) {
            //balance > 1 indiates left heave tree but we need to check left-left heave or left right heavy
            if (getBalance(node.getLeftChild()) < 0) {
                //left child has negative balance then left right heavy means left rotation on parent and right rotation on grand parent
                node.setLeftChild(leftRotation(node.getLeftChild()));
            }
            //only right rotation is sufficient if we have left left heavy
            return rightRotation(node);
        }
        if (getBalance(node) < -1) {
            if (getBalance(node.getRightChild()) > 0) {
                node.setRightChild(rightRotation(node.getRightChild()));
            }
            return leftRotation(node);
        }

        return node;
    }

    private AvlTreeNode<T> getPredecessor(AvlTreeNode<T> node) {
        if (node.getRightChild() != null) {
            return getPredecessor(node.getRightChild());
        }
        System.out.println("predecessor is " + node.getData());
        return node;
    }
}
