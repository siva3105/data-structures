package bst;

public class BinarySearchTree<T extends Comparable<T>> implements TreeOperations<T> {
    private TreeNode<T> root;

    public TreeNode<T> createNode(T data) {
        return new TreeNode<T>(data);
    }

    @Override
    public void insert(T data) {
        TreeNode<T> newNode = createNode(data);
        if (root == null) {
            root = newNode;
        } else {
            insertNodeInTree(root, newNode);
        }

    }

    private void insertNodeInTree(TreeNode<T> node, TreeNode<T> newNode) {
        if (newNode.getData().compareTo(node.getData()) < 0) {
            if (node.getLeftChild() == null) {
                node.setLeftChild(newNode);
            } else {
                insertNodeInTree(node.getLeftChild(), newNode);
            }
        } else {
            if (node.getRightChild() == null) {
                node.setRightChild(newNode);
            } else {
                insertNodeInTree(node.getRightChild(), newNode);
            }
        }
    }

    @Override
    public void traversal() {
        //in-order traverse
        if (root != null) {
            inorderTraversal(root);
        }
    }

    private void inorderTraversal(TreeNode<T> node) {
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

    private TreeNode<T> deleteNode(TreeNode<T> node, T data) {
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
                TreeNode<T> rightChild = node.getRightChild();
                node = null;
                return rightChild;
            }
            if (node.getRightChild() == null) {
                System.out.println("removed element's right child is empty");
                TreeNode<T> leftChild = node.getLeftChild();
                node = null;
                return leftChild;
            }
            System.out.println("removed element contains two childrens");
            TreeNode<T> predecessor = getPredecessor(node.getLeftChild());
            node.setData(predecessor.getData());
            node.setLeftChild(deleteNode(node.getLeftChild(),predecessor.getData()));
        }
        return node;
    }

    private TreeNode<T> getPredecessor(TreeNode<T> node) {
        if (node.getRightChild() != null) {
            return getPredecessor(node.getRightChild());
        }
        System.out.println("predecessor is " + node.getData());
        return node;
    }
}
