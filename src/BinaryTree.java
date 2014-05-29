/**
 * Class that provides vertex implementation in Binary tree
 */
public final class BinaryTree {
    /**
     * The value, that contains all vertex in tree
     */
    public final int key;
    /**
     * Reference to left child of vertex
     */
    public final BinaryTree left;
    /**
     * Reference to right child of vertex
     */
    public final BinaryTree right;

    /**
     * Basic constructor for creating vertex
     * @param key value in vertex
     * @param left left child
     * @param right right child
     */
    public BinaryTree(int key, BinaryTree left, BinaryTree right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}
