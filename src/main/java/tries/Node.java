package tries;

public class Node {
    private String character;
    private Integer value; //to make trie as hash map
    private Node[] childNodes;
    private boolean leaf;
    private boolean isVisited;

    public Node(String character) {
        this.character = character;
        this.childNodes = new Node[TrieConstants.CHILDREN_SIZE];
    }

    public void setChild(int index, Node node, Integer value) {
        node.setValue(value);
        this.childNodes[index] = node;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Node[] getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(Node[] childNodes) {
        this.childNodes = childNodes;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public Node getChild(int index) {
        return this.childNodes[index];
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
