package tries;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private Node root;
    private int singleChildIndex;

    public Trie() {
        this.root = new Node("");
    }

    public void put(String key, Integer value) {
        Node tempNode = root;
        for (int i = 0; i < key.length(); i++) {
            char character = key.charAt(i);
            int childIndex = character - 'a';
            if (tempNode.getChild(childIndex) == null) {
                Node newNode = new Node(Character.toString(character));
                tempNode.setChild(childIndex, newNode, null);
                tempNode = newNode;
            } else {
                tempNode = tempNode.getChild(childIndex);
            }
        }
        tempNode.setValue(value);
        tempNode.setLeaf(true);
    }

    public boolean containsKey(String key) {
        Node tempNode = root;
        for (int i = 0; i < key.length(); i++) {
            if (tempNode.getChild(key.charAt(i) - 'a') == null) {
                return false;
            } else {
                if (i == key.length() - 1 && !tempNode.getChild(key.charAt(i) - 'a').isLeaf()) {
                    return false;
                }
                tempNode = tempNode.getChild(key.charAt(i) - 'a');
            }
        }
        return true;
    }

    public Integer get(String key) {
        Node tempNode = root;
        for (int i = 0; i < key.length(); i++) {
            if (tempNode.getChild(key.charAt(i) - 'a') == null) {
                return null;
            } else {
                if (i == key.length() - 1 && !tempNode.getChild(key.charAt(i) - 'a').isLeaf()) {
                    return null;
                }
                tempNode = tempNode.getChild(key.charAt(i) - 'a');
            }
        }
        return tempNode.getValue();
    }

    public void delete(String key) {
        if (key == null) {
            System.out.println("key is empty");
            return;
        }
        deleteHelper(root, key, key.length(), 0);
        return;
    }

    private boolean deleteHelper(Node node, String key, int length, int level) {
        if (node == null) {
            System.out.println("key doesnt exist");
            return false;
        }
        boolean isDeleted = false;
        //base condition
        if (level == length) {
            if (node.getChildNodes() == null) {
                node = null;
                isDeleted = true;
            } else {
                node.setLeaf(false);
            }
        } else {
            Node childNode = node.getChild(key.charAt(level) - 'a');
            boolean childDelete = deleteHelper(childNode, key, length, level + 1);
            if (childDelete){
                node.setChild(key.charAt(level) - 'a',null, null);
                if (node.isLeaf() || countNumberOfChildNode(node) > 0) {
                    isDeleted = false;
                }
                else {
                    node = null;
                    isDeleted = true;
                }
            } else {
                isDeleted = false;
            }
        }
        return isDeleted;
    }

    public String getLongestCommonPrefix() {
        Node node = root;
        String lcp = "";
        boolean isSingledChildNode = countNumberOfChildNode(node) == 1;
        while (isSingledChildNode) {
            lcp = lcp + node.getChild(singleChildIndex).getCharacter();
            node = node.getChild(singleChildIndex);
            isSingledChildNode = countNumberOfChildNode(node) == 1;
        }
        return lcp;
    }

    private int countNumberOfChildNode(Node node) {
        int noOfChild = 0;
        for (int i = 0; i < node.getChildNodes().length; i++) {
            if (node.getChild(i) != null) {
                noOfChild++;
                singleChildIndex = i;
            }
        }
        return noOfChild;
    }


    public List<String> sortKeys() {
        List<String> allwords = new ArrayList<>();
        collectAllwords(root, "", allwords);
        return allwords;
    }

    private void collectAllwords(Node node, String prefix, List<String> allwords) {
        if (node == null)
            return;
        if (node.isLeaf())
            allwords.add(prefix);
        for (Node childNode : node.getChildNodes()) {
            if (childNode == null)
                continue;
            collectAllwords(childNode, prefix + childNode.getCharacter(), allwords);
        }
    }
}
